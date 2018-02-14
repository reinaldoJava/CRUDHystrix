package br.com.CRUDHystrix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.CRUDHystrix.model.Pessoa;

public interface CRUDRepositiry extends MongoRepository<Pessoa ,Long>{

}
