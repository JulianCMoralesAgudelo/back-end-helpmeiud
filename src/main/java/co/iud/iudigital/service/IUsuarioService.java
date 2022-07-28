package co.iud.iudigital.service;

import java.util.List;

import co.iud.iudigital.model.Usuario;

public interface IUsuarioService {

	List<Usuario> findAll();

	Usuario findById(Long id);

	Usuario save(Usuario usuario);

	Usuario findByUsername(String username);
}
