// Class responsável por implementar métodos da classe ContatoService

package colab.webflux.report.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import colab.webflux.report.model.Contato;
import colab.webflux.report.repository.ContatoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContatoServiceImplement implements ContatoService{

	//repository para acessar os métodos
	@Autowired
	ContatoRepository cpr;
	
	@Override
	public Flux<Contato> findAll() {
		return cpr.findAll();
	}

	@Override
	public Mono<Contato> findById(String id) {
		return cpr.findById(id);
	}

	@Override
	public Mono<Contato> save(Contato contato) {
		return cpr.save(contato);
	}

}
