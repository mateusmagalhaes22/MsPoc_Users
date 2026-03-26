package com.mateus.MsPoc_Usuarios.Repository;

import org.springframework.data.repository.CrudRepository;

import com.mateus.MsPoc_Usuarios.Model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
