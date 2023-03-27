package ec.edu.espe.movilidad.MovilidadWS.service;

import ec.edu.espe.movilidad.MovilidadWS.dao.DaoExample;
import ec.edu.espe.movilidad.MovilidadWS.model.ModelExample;
import ec.edu.espe.movilidad.MovilidadWS.model.ModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.edu.espe.movilidad.MovilidadWS.service.IServiceExample;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceExample implements IServiceExample{
    @Autowired
    private DaoExample daoExample;

    @Override
    public ModelExample find(Long id) {
        return daoExample.findByIdEnable(id).orElse(new ModelExample());
    }

    @Override
    public List<ModelExample> findAll() {
        return daoExample.findAllEnable().orElse(new ArrayList<>());
    }

}
