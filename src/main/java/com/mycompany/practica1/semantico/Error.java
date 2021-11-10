package com.mycompany.practica1.semantico;

public class Error {
    
    
    public static String getError(int Tipo){
        String Mensaje = "";
        switch(Tipo){
            case 0:
                Mensaje = " Operador, (, )";
                break;
            case 1:
                 Mensaje = " =,Operador,)";
                 break;
            case 2:
                 Mensaje = " Numero, (, )";
                 break;
            case 3:
                 Mensaje = " Numero, (, )";
                 break;
            
            
            case 4:
                Mensaje = " FIN";
                break;
            case 5:
                Mensaje = " Numero o Identificador";
                 break;
            case 6:
                Mensaje = " FIN o Numero o Operador";
                 break;
            case 7:
                Mensaje = " Expresion ";
                break;
            case 8:
                Mensaje = " Numero o Literal o Identificador";
                 break;
            case 9:
                 break;
            
            case 10:
                 Mensaje = " CONDICIONAL";
                break;
            case 11:
                 Mensaje = " ENTONCES";
                 break;
            case 12:
                 Mensaje = " ENTONCES";
                 break;
                 
            case 13:
                 Mensaje = " Numero o Identificador";
                break;
            case 14:
                 Mensaje = " ESCRITURA";
                 break;
            case 15:
                 Mensaje = " ESCRITURA";
                 break;
        }
        return Mensaje;
    }
    
}
