package com.educando.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.curso.model.User;
import com.educando.curso.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repositoryUser;
	
	public Optional<Object> cadastraUser (String email){
		Optional<User> usuarioExistente = repositoryUser.findByEmail(email);
		if(usuarioExistente.isPresent()) {
			return Optional.empty();
		}else {
			return Optional.of(repositoryUser.save(email));
		}
		
	}
}
