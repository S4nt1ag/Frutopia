package com.grupoone.frutopia.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.dto.UserDTO;
import com.grupoone.frutopia.entities.User;
import com.grupoone.frutopia.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsuarios() {
        List<User> listaUsuarios = userRepository.findAll();
        List<UserDTO> listaUserDto = modelMapper.map(listaUsuarios, new TypeToken<List<UserDTO>>() {}.getType());

        return listaUserDto;
    }
}
