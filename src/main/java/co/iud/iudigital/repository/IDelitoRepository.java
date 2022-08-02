package co.iud.iudigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.iud.iudigital.model.Delito;

@Repository
public interface IDelitoRepository 
	extends JpaRepository<Delito, Long>{
}
