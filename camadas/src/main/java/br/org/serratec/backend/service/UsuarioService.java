package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.dto.UsuarioDTO;
import br.org.serratec.backend.dto.UsuarioInserirDTO;
import br.org.serratec.backend.exception.EmailException;
import br.org.serratec.backend.model.Usuario;
import br.org.serratec.backend.repository.UsuarioRepository;

//Anotação semântica para serviço
@Service
public class UsuarioService {
	//Agora quem chama o repositório(injeção de dependências) é o service
	//Delegando uma função a service que era de controller
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//Método para retornar uma lista de usuários
	public List<UsuarioDTO>listar(){
		//Criação da lista vazia do tipo UsuarioDTO
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		//Cria uma lista para receber do usuarioRepository todos os usuários
		List<Usuario> usuarios = usuarioRepository.findAll();
		//Percorrer a lista de usuários
		for (Usuario usuario : usuarios) {
			UsuarioDTO dto = new UsuarioDTO(usuario);
			usuarioDTOs.add(dto);
		}
		return usuarioDTOs;
	}
	public UsuarioDTO inserir (UsuarioInserirDTO usuarioInserirDTO) throws EmailException{
		Usuario u = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if(u!=null) {
			throw new EmailException("Email existente! Insira outro");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setPerfil("Usuário Padrão");
		//Método de criptografia da senha 
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}
}
