package ec.edu.espe.movilidad.MovilidadWS.service;

import ec.edu.espe.movilidad.MovilidadWS.model.ModelExample;

import java.util.List;

public interface IServiceExample {

    public ModelExample find(Long id);

    public List<ModelExample> findAll();
}

