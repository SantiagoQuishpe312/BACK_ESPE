package ec.edu.espe.movilidad.MovilidadWS.dao;

import ec.edu.espe.movilidad.MovilidadWS.model.ModelExample;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface DaoExample extends CrudRepository<ModelExample, Long> {

    @Query(value = "SELECT u FROM ModelExample u WHERE u.state = 1")
    public Optional<List<ModelExample>> findAllEnable();

    @Query(value = "SELECT u FROM ModelExample u WHERE u.state = 1 and u.id=?1")
    public Optional<ModelExample> findByIdEnable(Long id);
}