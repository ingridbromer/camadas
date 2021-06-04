package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.Usuario;

public class UsuarioInserirDTO {
	public String nome;
	public String email;
	//Na inserção é necessário a senha
	private String senha;
	
	//CONSTRUTOR VAZIO
	public UsuarioInserirDTO() {
	}
	//CONSTRUTOR CHEIO

	public UsuarioInserirDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	//GETTERS AND SETTERS[

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
