package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.Usuario;

public class UsuarioDTO {
	//Quais usuários estão cadastrados na API:
	public Long id;
	public String nome;
	public String email;
	
	//SOBRECARGA
	//CONSTRUTOR VAZIO
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	//CONSTRUTOR CHEIO
	public UsuarioDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	//TRANSFERENCIA DE DADOS ENTRE USUARIO E USUARIODTO
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
