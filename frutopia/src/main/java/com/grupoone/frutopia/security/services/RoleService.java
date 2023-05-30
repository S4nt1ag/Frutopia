package com.grupoone.frutopia.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.frutopia.entities.Role;
import com.grupoone.frutopia.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
}

