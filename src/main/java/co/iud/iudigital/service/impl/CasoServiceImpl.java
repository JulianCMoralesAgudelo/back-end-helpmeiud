package co.iud.iudigital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.iud.iudigital.dto.CasoDTO;
import co.iud.iudigital.exception.ErrorDto;
import co.iud.iudigital.exception.NotFoundException;
import co.iud.iudigital.exception.RestException;
import co.iud.iudigital.model.Caso;
import co.iud.iudigital.model.Delito;
import co.iud.iudigital.model.Usuario;
import co.iud.iudigital.repository.ICasoRepository;
import co.iud.iudigital.repository.IDelitoRepository;
import co.iud.iudigital.repository.IUsuarioRepository;
import co.iud.iudigital.service.ICasoService;
import co.iud.iudigital.util.ConstUtil;
import co.iud.iudigital.util.Helper;

@Service
@Transactional
public class CasoServiceImpl implements ICasoService{

	@Autowired
	private ICasoRepository casoRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IDelitoRepository delitoRepository;

	@Override
	public List<CasoDTO> findAll() throws RestException {
		List<Caso> casos = casoRepository.findAll();
		return Helper.convertListCasoDTO(casos);
	}

	@Override
	public CasoDTO save(CasoDTO casoDTO) throws RestException {
		Optional<Usuario> usuarioOpt = usuarioRepository
				.findById(casoDTO.getUsuarioId());
		if(!usuarioOpt.isPresent()) {
			throw new NotFoundException(
					ErrorDto.getErrorDto(
							HttpStatus.NOT_FOUND.getReasonPhrase(), 
							ConstUtil.MESSAGE_NOT_FOUND, 
							HttpStatus.NOT_FOUND.value())
				);
		}
		Optional<Delito> delitoOpt = delitoRepository
				.findById(casoDTO.getDelitoId());
		if(!delitoOpt.isPresent()) {
			throw new NotFoundException(
					ErrorDto.getErrorDto(
							HttpStatus.NOT_FOUND.getReasonPhrase(), 
							ConstUtil.MESSAGE_NOT_FOUND, 
							HttpStatus.NOT_FOUND.value())
				);
		}
		Caso caso = Helper.convertCasoDTOToCaso(casoDTO);
		caso.setDelito(delitoOpt.get());
		caso.setUsuario(usuarioOpt.get());
		caso = casoRepository.save(caso);
		return Helper.convertCasoToCasoDTO(caso);
	}

	@Override
	public Boolean visible(Boolean visible, Long id) {
		return casoRepository.setVisible(visible, id);
	}

	@Override
	public CasoDTO findById(Long id) throws RestException {
		Optional<Caso> casoOpt = casoRepository.findById(id);
		if(!casoOpt.isPresent()) {
			throw new NotFoundException(
				ErrorDto.getErrorDto(
						HttpStatus.NOT_FOUND.getReasonPhrase(), 
						ConstUtil.MESSAGE_NOT_FOUND, 
						HttpStatus.NOT_FOUND.value())
			);
		}
		return Helper.convertCasoToCasoDTO(casoOpt.get());
	}
}
