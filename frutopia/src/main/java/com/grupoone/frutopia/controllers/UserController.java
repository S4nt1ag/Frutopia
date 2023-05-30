package com.grupoone.frutopia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoone.frutopia.dto.UserDTO;
import com.grupoone.frutopia.services.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsuarios() {
        return new ResponseEntity<>(userService.getAllUsuarios(), HttpStatus.OK);
    }
}