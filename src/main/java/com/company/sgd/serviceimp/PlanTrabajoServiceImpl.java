package com.company.sgd.serviceimp;

import com.company.sgd.entity.DocumentosActivosEntity;
import com.company.sgd.exceptions.AJAXException;
import com.company.sgd.exceptions.FileNotFoundException;
import com.company.sgd.repository.DocumentosActivosRepository;
import com.company.sgd.service.FileManager;
import com.company.sgd.service.PlanTrabajoService;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author the_d
 */

@Service
public class PlanTrabajoServiceImpl implements PlanTrabajoService{
    
    @Value("${directorio}")
    private String dirPrincipal;
    @Value("${documentosunicos}")
    private String docunicos;
    @Value("${plantrabajofolder}")
    private String plantrabajo;
    @Autowired
    DocumentosActivosRepository repository;
    @Autowired
    FileManager fileManager;
    
    @Override
    public void planTrabajo(){
        String path = File.separator + dirPrincipal + File.separator + docunicos + File.separator + plantrabajo + File.separator;
        String fileName = plantrabajo + ".pdf";
        try {
            DocumentosActivosEntity activosEntity = repository.findByRutaAndNombre(path, fileName);
            if (activosEntity != null) {
                fileManager.downloadFile(activosEntity, true);
            } else {
                throw new AJAXException("Archivo no Encontrado en db");
            }
        } catch (IOException | FileNotFoundException ex) {
            Logger.getLogger(PlanTrabajoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AJAXException(ex.getMessage());
        }
    }
}
