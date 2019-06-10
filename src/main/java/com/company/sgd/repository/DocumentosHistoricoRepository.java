/**
 * 
 */
package com.company.sgd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.sgd.entity.DocumentosHistoricoEntity;

/**
 * @author the_d
 *
 */
@Repository
public interface DocumentosHistoricoRepository extends CrudRepository<DocumentosHistoricoEntity,Integer>{

}
