package co.iud.iudigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.iud.iudigital.model.Caso;

@Repository
public interface ICasoRepository extends JpaRepository<Caso, Long> {

	@Query("UPDATE Caso c SET c.visible = ?1 WHERE " + "c.id = ?2")
	Boolean setVisible(Boolean visible, Long id);
}
