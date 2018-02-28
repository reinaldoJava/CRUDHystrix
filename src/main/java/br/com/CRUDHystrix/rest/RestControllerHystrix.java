package br.com.CRUDHystrix.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.CRUDHystrix.DataBaseHystrixFallbackError;
import br.com.CRUDHystrix.model.Pessoa;
import br.com.CRUDHystrix.repository.CRUDRepositiry;


@RestController
public class RestControllerHystrix {

	@Autowired
	private DataBaseHystrixFallbackError dataBaseHystrixFallbackError;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody Pessoa pessoa) {
		dataBaseHystrixFallbackError.salvarPessoa(pessoa);
		System.out.println("ok");
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Pessoa> listUser(){
		
		return dataBaseHystrixFallbackError.listPessoas();
		
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@RequestBody Pessoa pessoa) {
		dataBaseHystrixFallbackError.deletarPessoa(pessoa);
		System.out.println("ok");
	}
	
}
