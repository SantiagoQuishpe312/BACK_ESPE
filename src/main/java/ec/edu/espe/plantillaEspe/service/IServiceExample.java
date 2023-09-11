package ec.edu.espe.plantillaEspe.service;

import ec.edu.espe.plantillaEspe.model.ModelExample;
import java.util.List;

public interface IServiceExample {

    public ModelExample find(Long id);

    public List<ModelExample> findAll();
}

