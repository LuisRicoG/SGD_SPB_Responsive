/**
 * 
 */
package com.company.sgd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.sgd.entity.LoginEntity;

/**
 * @author the_d
 *
 */
@Repository
public interface LoginRepository extends CrudRepository<LoginEntity,Integer>{	
    LoginEntity findByUsuarioAndContrasena(String usuario,String contrasena);
    LoginEntity findByUsuario(String usuario);
}
