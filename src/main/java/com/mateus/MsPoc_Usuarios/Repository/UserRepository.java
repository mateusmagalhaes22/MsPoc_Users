package com.mateus.MsPoc_Usuarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.MsPoc_Usuarios.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    public User findByEmail(String email);

}
