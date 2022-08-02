package co.iud.iudigital.service;

import java.util.List;

import co.iud.iudigital.exception.RestException;
import co.iud.iudigital.model.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll() throws RestException;
	
	public Usuario findById(Long id) throws RestException;
	
	public Usuario save(Usuario usuario) throws RestException;
	
	public Usuario findByUsername(String username);
}
