package com.company.sgd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author the_d
 */


public class Zipper {
    public static void main(String args[]){
        String x=("C:\\apache-tomcat-8.5.37\\almacendocumental\\facturasactivos\\inmuebles");
        try{
            System.out.println(zipFile(x,"inmuebles.zip"));
        }catch(IOException ex){
        ex.printStackTrace();
        }
    }
    
    static List<String> filesListInDir = new ArrayList<String>();
    
    public static String zipFile(String ruta, String nombre) throws IOException {    
        File dir = new File(ruta);
        populateFilesList(dir,nombre);
            //now zip files one by one
            //create ZipOutputStream to write to the zip file
            FileOutputStream fos = new FileOutputStream(ruta+File.separator+nombre);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(String filePath : filesListInDir){
                System.out.println("Zipping "+filePath);
                //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                //read the file and write to ZipOutputStream
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        return ruta+File.separator+nombre;
    }
    
    private static void populateFilesList(File dir,String nombre) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()){
                System.out.println(file.getName());
                if(!file.getName().matches(nombre))
                filesListInDir.add(file.getAbsolutePath());
            }
            else 
                populateFilesList(file,nombre);
        }
    }
}
