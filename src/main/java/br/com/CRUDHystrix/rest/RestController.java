package br.com.CRUDHystrix.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.CRUDHystrix.model.Pessoa;
import br.com.CRUDHystrix.repository.CRUDRepositiry;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private CRUDRepositiry crudRepositiry;
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody Pessoa pessoa) {
		salvarPessoa(pessoa);
		System.out.println("ok");
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Pessoa> listUser() {
		
		return listPessoas();
		
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@RequestBody Pessoa pessoa) {
		deletarPessoa(pessoa);
		System.out.println("ok");
	}
	
	public void fallbackError() {
		System.out.println("Erro qualquer");
	}
	@HystrixCommand(fallbackMethod = "fallbackError")
	@Cacheable(value="listaPessoa")
	private List<Pessoa> listPessoas(){
		return crudRepositiry.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "fallbackError")
	private void salvarPessoa(Pessoa pessoa) {
		crudRepositiry.save(pessoa);		
	}
	
	@HystrixCommand(fallbackMethod = "fallbackError")
	private void deletarPessoa(Pessoa pessoa) {
		crudRepositiry.delete(pessoa);	
	}
}
