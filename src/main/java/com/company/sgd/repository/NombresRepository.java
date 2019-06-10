package com.company.sgd.repository;

import com.company.sgd.entity.NombresEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 * @author the_d
 */

@Repository
public interface NombresRepository extends CrudRepository<NombresEntity, Integer>{
    List<NombresEntity> findByVista(String vista);
}
