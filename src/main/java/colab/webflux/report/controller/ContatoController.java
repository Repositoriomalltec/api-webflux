package colab.webflux.report.controller;

import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import colab.webflux.report.model.Contato;
import colab.webflux.report.services.ContatoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;

import reactor.util.function.Tuple2;
//import java.util.concurrent.TimeUnit;

@RestController
public class ContatoController {

	@Autowired
	ContatoService service;
	
	@GetMapping(value="/contato")
	public Flux<Contato> getContato(){
		return service.findAll();
	}
	
	@GetMapping(value="/oi")
	public String getOi(){
		return "Teste com sucesso";
	}
	
	@GetMapping(value="/contato/{id}")
	public Mono<Contato> getContatoId(@PathVariable String id){
		return service.findById(id);		
	}
	
	@PostMapping(value="/contato")
	public Mono<Contato> save(@RequestBody Contato contato){
		return service.save(contato);
	}
	
	@GetMapping(value="/contato/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Contato>> getPlaylistByEvents(){
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Contato> events = service.findAll();
        System.out.print("Passou aqui events");
        return Flux.zip(interval, events);        
	}
	
	@GetMapping(value="/pipeline")
	public String getPipeline(){
		return "Hello World!!!";
	}

}
