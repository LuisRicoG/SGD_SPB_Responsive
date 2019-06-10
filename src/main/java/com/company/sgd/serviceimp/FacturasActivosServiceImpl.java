package com.company.sgd.serviceimp;

import com.company.sgd.entity.DocumentosActivosEntity;
import com.company.sgd.exceptions.AJAXException;
import com.company.sgd.exceptions.FileNotFoundException;
import com.company.sgd.repository.DocumentosActivosRepository;
import com.company.sgd.service.FacturasActivosService;
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
public class FacturasActivosServiceImpl implements FacturasActivosService {

    @Value("${directorio}")
    private String dirPrincipal;
    @Value("${facturasactivosfolder}")
    private String facturasactivos;
    @Value("${prefijofact}")
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
    public void getFA(String x) {
        try {
            String path = File.separator + dirPrincipal + File.separator + docunicos + File.separator + facturasactivos + File.separator;
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
                fileManager.downloadFile(activosEntity, true);
            }
            else
            {
                throw new AJAXException("Archivo no Encontrado en db");
            }
        } catch (IOException | FileNotFoundException ex) {
            Logger.getLogger(FacturasActivosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AJAXException(ex.getMessage());
        }
    }
    
    @Override
    public void getZip(String x){
        String HOME = ConstantsSGD.HOME;
        try {
            String path = File.separator + dirPrincipal + File.separator + docunicos + File.separator + facturasactivos + File.separator + x + File.separator;            
            String fileName = prefijo + x + ".zip";
            fileManager.zipFile(HOME + path, fileName);
            DocumentosActivosEntity entity = new DocumentosActivosEntity();
            entity.setRuta(path);
            entity.setNombre(fileName);
            fileManager.downloadFile(entity, false);            
        } catch (IOException ex) {
            Logger.getLogger(FacturasActivosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
