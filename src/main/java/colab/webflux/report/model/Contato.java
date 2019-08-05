/* MODEL - MODELO DO BANCO*/
package colab.webflux.report.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contato {
	
	@Id
	private String id;
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	
	public Contato() {}
	
//	public Contato(String id, String nome, String sobrenome, String telefone) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.sobrenome = sobrenome;
//		this.telefone = telefone;
//	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
