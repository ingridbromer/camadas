package br.org.serratec.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Anotação semântica: Classe de Configuração
@Configuration
public class AppConfig {
	//@Bean: esse método pode ser injetado de forma separada (não a classe completa)
	@Bean
	//Esse método gera um código aleatório para cada senha (salt), o que torna mais difícil decodificar uma senha (é um método mais seguro) 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
