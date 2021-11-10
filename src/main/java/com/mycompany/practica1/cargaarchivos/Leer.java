
package com.mycompany.practica1.cargaarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JTextArea;

public class Leer {
    private static File Archivo;
    
    public static void LeerArchivo(String Direccion, JTextArea Espacio){
        try{
        Archivo = new File(Direccion);
        FileReader fr = new FileReader(Archivo);
        BufferedReader br = new BufferedReader(fr);
        String Linea;
        while((Linea = br.readLine()) != null){
         Espacio.setText(Linea);
        }
        }
        catch(Exception e){
        }
    
    }
    
    public static void Escribir(String Direccion, String Texto){
            FileWriter fichero = null;
            PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(Direccion);
            pw = new PrintWriter(fichero);

            
                pw.println(Texto);

        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    }
    

