package co.iud.iudigital.service;

import java.util.List;

import co.iud.iudigital.dto.CasoDTO;

public interface ICasoService {

	// consulta todos los casos
	List<CasoDTO> findAll();

	// crear un caso
	CasoDTO save(CasoDTO caso);

	// inactivar el caso
	Boolean visible(Boolean visible, Long id);

	// consultar caso por Id
	CasoDTO findById(Long id);
}
