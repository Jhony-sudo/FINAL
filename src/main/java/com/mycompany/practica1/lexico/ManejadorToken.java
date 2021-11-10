
package com.mycompany.practica1.lexico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ManejadorToken {
    
    public static ArrayList<Token> Token = new ArrayList<Token>();
    public static ArrayList<Error> Errores =  new ArrayList<Error>();
    public static ArrayList<Token> ConteoT = new ArrayList<Token>();
    
    public ManejadorToken(){
        
        
    }
    
    public void Llenar(TipoToken T,String n,int Fila,int Columna){
       Token t =  new Token(T,n,Fila,Columna);
       t.setLexema(n);
       ManejadorToken.Token.add(t); 
    }   
    public void ReportarError(String Cadena, int Columna, int Fila){
        Error t =  new Error(Cadena,Columna,Fila);
        ManejadorToken.Errores.add(t);
    }
    public void ConteoTokens(){
        
        ArrayList<String> n = new ArrayList<String>();
        for(int i =0;i<Token.size();i++){
            n.add(Token.get(i).getLexema());
        }
        Set<String> set = new HashSet<>(n);
        n.clear();
        n.addAll(set);
        for(int i=0;i<n.size();i++){
            int Contador = 0;
            String Palabra = n.get(i);
            TipoToken T = TipoToken.Comentarios;
            for(int x =0;x<Token.size();x++){
                if (Palabra.equals(Token.get(x).getLexema())) {
                    Contador++;
                    T = Token.get(x).getTipo();
                }
            }
            Token t = new Token(Palabra,Contador,T);
            ConteoT.add(t);
        }
        Escribir(n);
    }
    
    public void Reiniciar(){
        Token = new ArrayList<Token>();
        Errores =  new ArrayList<Error>();
        ConteoT = new ArrayList<Token>();
    }
    
    public void Escribir(ArrayList n ){
        
        
        for(int i =0;i<n.size();i++){
            
            System.out.println(n.get(i));
        }
        System.out.println(ConteoT.size());
        for(int i =0;i<ConteoT.size();i++){
            
            
        }
        
    }
    
    public Token DevolverToken(int Posicion){
        return Token.get(Posicion);
    }
    
    public static Token TokenFinal(){
        Token t = new Token(TipoToken.Final,"$",0,0);
        return t;
    }
   
}
