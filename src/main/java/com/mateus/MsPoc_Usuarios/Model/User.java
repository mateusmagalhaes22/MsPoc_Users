package com.mateus.MsPoc_Usuarios.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	
	@Column(nullable = false)
	private String usuario;
	
	@Column(nullable = false)
	private String senha;

}
