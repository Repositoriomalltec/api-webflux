/* Criar os métodos para transmitir os dados para banco */
package colab.webflux.report.services;

import colab.webflux.report.model.Contato;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContatoService {
	
	/* 
	 * Web flux trabalha com dois tipos: Flux e nomo;
	 * o retorno é um flux de informações
	 * */
	
	//Todos
	Flux<Contato> findAll();	
	
	//retorna somente um valor	
	Mono<Contato> findById(String id);
	
	//Save	
	Mono<Contato> save(Contato contato);
}
