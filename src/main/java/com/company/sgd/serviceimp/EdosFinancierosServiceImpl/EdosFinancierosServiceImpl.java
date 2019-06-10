/*
 * ing.jorge.eduardo.p@gmail.com
 */
package com.company.sgd.serviceimp.EdosFinancierosServiceImpl;

import com.company.sgd.entity.DocumentosActivosEntity;
import com.company.sgd.exceptions.AJAXException;
import com.company.sgd.exceptions.FileNotFoundException;
import com.company.sgd.repository.DocumentosActivosRepository;
import com.company.sgd.service.EdosFinancierosService.EdosFinancierosService;
import com.company.sgd.service.FileManager;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEPPLAP
 */
@Service
public class EdosFinancierosServiceImpl implements EdosFinancierosService {

    @Value("${directorio}")
    private String dirPrincipal;
    @Value("${estadosfinacierosfolder}")
    private String estadosfinacieros;
    @Value("${documentosunicos}")
    private String documentosunicos;
    @Value("${prefijoestadosfinancieros}")
    private String prefijoestadosfinancieros;
    @Autowired
    DocumentosActivosRepository repository;

    @Autowired
    FileManager fileManager;

    @Override
    public void getEstadoFinanciero(String year, String month) {
        try {
            Date date = new SimpleDateFormat("MMMM", new Locale("es", "ES")).parse(month);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String path = File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + estadosfinacieros + File.separator + year + File.separator;
            String fileName = prefijoestadosfinancieros + month + "-" + year + ".pdf";
            DocumentosActivosEntity activosEntity = repository.findByRutaAndNombre(path, fileName);
            if (activosEntity != null) {
                fileManager.downloadFile(activosEntity, true);
            } else {
                throw new AJAXException("Archivo no Encontrado en db");
            }
        } catch (IOException | ParseException | FileNotFoundException ex) {
            Logger.getLogger(EdosFinancierosServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AJAXException(ex.getMessage());
        }
    }
}
