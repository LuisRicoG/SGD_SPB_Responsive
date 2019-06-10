/**
 *
 */
package com.company.sgd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.sgd.entity.ListaValoresEntity;
import java.util.ArrayList;

/**
 * @author the_d
 *
 */
@Repository
public interface ListaValoresRepository extends CrudRepository<ListaValoresEntity, Integer> {

    ArrayList<ListaValoresEntity> findByNombreLista(String nombreLista);
}
