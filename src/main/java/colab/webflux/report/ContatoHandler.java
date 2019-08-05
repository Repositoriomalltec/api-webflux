/*
 * Programação Funcional:
 * Essa classe faz o mesmo papel da ContatoController.
 * 
 *  Aqui se encontra métodos para ler,pesquisar e gravar.
 * 
 */
package colab.webflux.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import colab.webflux.report.model.Contato;
import colab.webflux.report.services.ContatoService;


import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import reactor.core.publisher.Mono;

//@Component
public class ContatoHandler {
	
	@Autowired
	ContatoService service;
	
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Contato.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Contato.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		//recebe o objeto para ser inserindo no banco
		/*
		 * service::save = Referenciando ao método
		 */
		final Mono<Contato> contato = request.bodyToMono(Contato.class); //Recebe o OB
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(contato.flatMap(service::save), Contato.class));// Publica o Ob do tipo map para o Contato
	}
	
}
