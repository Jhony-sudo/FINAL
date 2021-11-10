package com.mycompany.practica1.semantico;

import com.mycompany.practica1.lexico.ManejadorToken;
import com.mycompany.practica1.lexico.Token;
import java.util.Stack;


public class Pila {
    public static int Posicion = 0;
    public static Stack<String> P = new Stack();
    
        ManejadorToken n = new ManejadorToken();
    
    public Pila(Stack Pila){
        this.P = Pila;
    }
    
    public Token PedirToken(){
            
            Token t =n.DevolverToken(Posicion);
            Posicion++;
        
            return t;
        
        
        
    }
    
    public Token TokenSiguiente(){
        System.out.println("Posicion Token " + Posicion);
        Token t =n.DevolverToken(Posicion);
        return t;
    }
    
    public void Iniciar(){
        P.push("&");
        P.push("S");
    }
    
    public void getEstructura(Token t){
    
    }
    
    public boolean Continuar(){
        boolean tmp = true;
        if (P.empty())
            tmp = false;
        
        return tmp;
    }
    
        public void Cambiar(String Produccion){
        
        boolean tmp;
        String Pr = "";
        P.pop();
        
            System.out.println("Produccion" + Produccion);
        for(int i=0;i<Produccion.length();i++){
            if(Produccion.charAt(i) != '-')
            Pr = Pr + Produccion.charAt(i);
            
            if(Produccion.charAt(i) == '-' | i == Produccion.length() - 1){
                P.push(Pr);
                System.out.println("Elemento a introducir " + Pr);
                Pr="";
            }
        }
        }
        
        public String Escribir(){
            String n = "";
            for(int i=0;i<P.size();i++){
                n=n+" " + P.get(i);
            }
            return n;
        }
    
}
