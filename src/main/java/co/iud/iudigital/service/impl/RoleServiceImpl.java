package co.iud.iudigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.iud.iudigital.model.Role;
import co.iud.iudigital.repository.IRoleRepository;
import co.iud.iudigital.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired // inyección de dependencias
	private IRoleRepository roleRepository;
	
	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

}
