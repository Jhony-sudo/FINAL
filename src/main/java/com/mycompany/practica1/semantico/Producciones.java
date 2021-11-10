package com.mycompany.practica1.semantico;

public class Producciones {

    public static String Produccion;
    
    
    
    public void Cambiar(){
       int Longitud =  Produccion.length();
       int No = 0;
       for(int i =0;i<Longitud;i++){
           if(Character.isSpaceChar(Produccion.charAt(i))){
               No = 2;
           }
       }
    
    }
}
