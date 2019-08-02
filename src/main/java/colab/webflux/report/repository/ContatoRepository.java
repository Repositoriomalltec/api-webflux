/*INTERFACE - CRUD*/
package colab.webflux.report.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import colab.webflux.report.model.Contato;

public interface ContatoRepository extends ReactiveMongoRepository<Contato, String>{

}
