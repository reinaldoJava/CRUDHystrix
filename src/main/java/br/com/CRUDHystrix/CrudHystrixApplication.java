package br.com.CRUDHystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class CrudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudHystrixApplication.class, args);
	}
}
