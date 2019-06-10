/**
 *
 */
package com.company.sgd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.sgd.entity.DocumentosActivosEntity;

/**
 * @author the_d
 *
 */
@Repository
public interface DocumentosActivosRepository extends CrudRepository<DocumentosActivosEntity, Integer> {
    DocumentosActivosEntity findByDocumentoid(Integer documentoid);
    DocumentosActivosEntity findByRutaAndNombre(String ruta, String nombre);
}
