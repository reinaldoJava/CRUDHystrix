package br.com.CRUDHystrix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.CRUDHystrix.model.Pessoa;
@Repository
public interface CRUDRepositiry extends MongoRepository<Pessoa ,Long>{

}
