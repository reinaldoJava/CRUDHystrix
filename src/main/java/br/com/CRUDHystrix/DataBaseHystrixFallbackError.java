package br.com.CRUDHystrix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.CRUDHystrix.config.JsonUtils;
import br.com.CRUDHystrix.model.Pessoa;
import br.com.CRUDHystrix.repository.CRUDRepositiry;

@Component
public class DataBaseHystrixFallbackError {
	
	private static Logger logger = LoggerFactory.getLogger(DataBaseHystrixFallbackError.class);
	
	@Autowired
	private CRUDRepositiry crudRepositiry;
	

	@HystrixCommand(fallbackMethod = "fallbackErrorListarPessoas")
	public List<Pessoa> listPessoas(){
		 throw new  NullPointerException();
	}
	
	public List<Pessoa> fallbackErrorListarPessoas(Throwable e) throws JSONException {
		logger.error("Erro qualquer ao listar Pessoas!!");
		
		JsonUtils.parseJsonObjectLog(e.toString(),e.getMessage() +" Time :"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss")).toString()
				, "listPessoas");
		return null;
	}
	
	@HystrixCommand(fallbackMethod = "fallbackErrorSalvarPessoa")
	public void salvarPessoa(Pessoa pessoa) {
		crudRepositiry.save(pessoa);		
	}
	
	public void fallbackErrorSalvarPessoa() {
		logger.error("Erro qualquer ao listar Pessoas!!");
	}
	
	@HystrixCommand(fallbackMethod = "fallbackErrorDeletarPessoa")
	public void deletarPessoa(Pessoa pessoa) {
		crudRepositiry.delete(pessoa);	
	}
	public void fallbackErrorDeletarPessoa() {
		logger.error("Erro qualquer ao listar Pessoas!!");
	}
	
}
