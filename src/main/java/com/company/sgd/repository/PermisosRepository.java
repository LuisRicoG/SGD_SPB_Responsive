/**
 * 
 */
package com.company.sgd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.sgd.entity.PermisosEntity;

/**
 * @author the_d
 *
 */
@Repository
public interface PermisosRepository extends CrudRepository<PermisosEntity,Integer>{

}
