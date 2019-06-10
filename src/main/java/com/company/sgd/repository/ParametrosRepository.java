/**
 * 
 */
package com.company.sgd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.sgd.entity.ParametrosEntity;

/**
 * @author the_d
 *
 */
@Repository
public interface ParametrosRepository extends CrudRepository<ParametrosEntity,Integer>{
    ParametrosEntity findByParametroid(Integer id);

}
