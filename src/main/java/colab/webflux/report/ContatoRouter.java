/*
 * Esta classe gerencia qual método vai ser executado
 * .route(GET("/contato").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
 * metodo e rota, tipo da resposta e nome do método
 */
package colab.webflux.report;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


//@Configuration
public class ContatoRouter {

	//@Bean
	public RouterFunction<ServerResponse> route(ContatoHandler handler){
		return RouterFunctions
				.route(GET("/contato").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/contato/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/contato").and(accept(MediaType.APPLICATION_JSON)), handler::save);
			
	}
}
