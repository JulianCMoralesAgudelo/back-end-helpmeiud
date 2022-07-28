package co.iud.iudigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.iud.iudigital.model.Role;
import co.iud.iudigital.service.IRoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@GetMapping
	public ResponseEntity<List<Role>> index(){
		List<Role> roles = roleService.getAll();
		return ResponseEntity.ok().body(roles);
	}
}