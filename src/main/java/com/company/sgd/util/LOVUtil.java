package com.company.sgd.util;

import com.company.sgd.entity.ListaValoresEntity;
import com.company.sgd.repository.ListaValoresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Qualtop
 */
@Service
public class LOVUtil {

    List<ListaValoresEntity> entityList;
    @Autowired
    ListaValoresRepository listaValoresRepository;

    public List getLov(String lov) {

        entityList = listaValoresRepository.findByNombreLista(lov);
        return entityList;
    }
}
