package com.mateus.MsPoc_Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mateus.MsPoc_Usuarios.Model.User;
import com.mateus.MsPoc_Usuarios.infra.UserService;



@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    
    @GetMapping
    public List<User> findAllUsers(@RequestParam String param) {
        return service.listAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> postMethodName(@RequestBody User User) {
        User user = service.createUser(User);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}