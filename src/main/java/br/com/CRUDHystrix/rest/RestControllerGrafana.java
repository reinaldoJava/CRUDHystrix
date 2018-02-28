package br.com.CRUDHystrix.rest;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.CRUDHystrix.config.JsonUtils;

@RestController
public class RestControllerGrafana {
	
	@RequestMapping(value = "/")
	public void init() {
		System.out.println("Init Grafana!");
	}
	
	@RequestMapping(value = "/query")
	public  @ResponseBody String query() {
		System.out.println("query Grafana!");
		return JsonUtils.logJson.toString();
	}
	@RequestMapping(value = "/search")
	public @ResponseBody String search() {	
		System.out.println("search Grafana!!");
		return JsonUtils.logJson.toString();
		
	}
	@RequestMapping(value = "/annotations")
	public void annotations() {
	
		System.out.println("annotations Grafana!!");
	} 
}
