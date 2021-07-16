package com.educando.curso.model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDTO {

	@NotNull(message = "Campo nome deve conter mais de duas letras")
	@Size(min = 2, max = 200)
	private String name;

	@NotNull(message = "Senha invalida")
	@Size(min = 6, max = 200)
	private String password;

	@NotNull(message = "Campo Não pode ser Nulo")
	@Email(message = "Coloque um E-mail Valido")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
