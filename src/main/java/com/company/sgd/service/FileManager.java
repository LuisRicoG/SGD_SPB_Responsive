
/*
 * ing.jorge.eduardo.p@gmail.com
 */
package com.company.sgd.service;

import com.company.sgd.entity.DocumentosActivosEntity;
import com.company.sgd.entity.DocumentosAcumuladosEntity;
import com.company.sgd.exceptions.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author JEPPLAP
 */
public interface FileManager {
public void downloadFile(DocumentosActivosEntity entidad, Boolean isEncripted) throws IOException, FileNotFoundException;
public void downloadFile(DocumentosAcumuladosEntity entidad, Boolean isEncripted) throws IOException, FileNotFoundException;
public boolean zipFile(String ruta, String nombre) throws IOException;
}
