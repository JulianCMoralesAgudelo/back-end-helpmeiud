package co.iud.iudigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.iud.iudigital.dto.DelitoDTO;
import co.iud.iudigital.model.Delito;
import co.iud.iudigital.repository.IDelitoRepository;
import co.iud.iudigital.service.IDelitoService;
import co.iud.iudigital.util.Helper;

@Service
public class DelitoServiceImpl implements IDelitoService {

	@Autowired
	private IDelitoRepository delitoRepository;

	@Transactional(readOnly = true)
	@Override
	public List<DelitoDTO> findAll() {
		List<Delito> delitos = delitoRepository.findAll();
		List<DelitoDTO> delitosDTO = Helper.convertListDelitoDTO(delitos);
		return delitosDTO;
	}

	@Override
	public DelitoDTO findById(Long id) {
		return null;
	}

	@Override
	public DelitoDTO save(DelitoDTO delitoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}