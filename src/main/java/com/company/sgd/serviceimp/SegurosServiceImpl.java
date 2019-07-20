package com.company.sgd.serviceimp;

import com.company.sgd.entity.DocumentosActivosEntity;
import com.company.sgd.exceptions.AJAXException;
import com.company.sgd.exceptions.FileNotFoundException;
import com.company.sgd.repository.DocumentosActivosRepository;
import com.company.sgd.service.SegurosService;
import com.company.sgd.service.FileManager;
import com.company.sgd.util.ConstantsSGD;
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
public class SegurosServiceImpl implements SegurosService{
    @Value("${directorio}")
    private String dirPrincipal;
    @Value("${segurosfolder}")
    private String seguros;
    @Value("${prefijoseg}")
    private String prefijo;
    @Value("${inmueblesfolder}")
    private String inmuebles;
    @Value("${equipocomputofolder}")
    private String equipocomputo;
    @Value("${equipotransportefolder}")
    private String equipotransporte;
    @Value("${maquinariayequipofolder}")
    private String maquinariayequipo;
    @Value("${mobiliariofolder}")
    private String mobiliario;
    @Value("${documentosunicos}")
    private String docunicos;
    @Autowired
    DocumentosActivosRepository repository;

    @Autowired
    FileManager fileManager;

    @Override
    public void getS(String x) {
        try {
            String path = File.separator + dirPrincipal + File.separator + docunicos + File.separator + seguros + File.separator;
            if(x.startsWith("I"))
                path=path + inmuebles + File.separator;
            if(x.startsWith("MyE"))
                path=path + maquinariayequipo + File.separator;
            if(x.startsWith("EdT"))
                path=path + equipotransporte + File.separator;
            if(x.startsWith("Mo"))
                path=path + mobiliario + File.separator;
            if(x.startsWith("EdC"))
                path=path + equipocomputo + File.separator;
            String fileName = prefijo + x + ".pdf";
            DocumentosActivosEntity activosEntity = repository.findByRutaAndNombre(path, fileName);
            if (activosEntity != null) {
                fileManager.downloadFile(activosEntity,true);
            }
            else
            {
                throw new AJAXException("Archivo no Encontrado en db");
            }
        } catch (IOException | FileNotFoundException ex) {
            Logger.getLogger(SegurosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AJAXException(ex.getMessage());
        }
    }
    
    @Override
    public void getZip(String x){
        String HOME = ConstantsSGD.HOME;
        try {
            String path = File.separator + dirPrincipal + File.separator + docunicos + File.separator + seguros + File.separator + x + File.separator;            
            String fileName = prefijo + x + ".zip";
            boolean emptyzip=fileManager.zipFile(HOME + path, fileName);
            DocumentosActivosEntity entity = new DocumentosActivosEntity();
            entity.setRuta(path);
            entity.setNombre(fileName);
            if (emptyzip)
                fileManager.downloadFile(entity, false);
            else
                throw new AJAXException("Archivo zip vacio");              
        } catch (IOException | FileNotFoundException ex) {
            Logger.getLogger(SegurosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AJAXException(ex.getMessage());
        }
    }
}
