
package com.mycompany.practica1.lexico;

public class Token {
    TipoToken Tipo;
    String Lexema;
    private int Fila;
    private int Columna;
    private int Contador;

    public Token(TipoToken Tipo, String Lexema, int Fila, int Columna) {
        this.Tipo = Tipo;
        this.Lexema = Lexema;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public int getContador() {
        return Contador;
    }
    
    public Token(String Lexema,int Contador, TipoToken Tipo){
        this.Lexema = Lexema;
        this.Contador = Contador;
        this.Tipo = Tipo;
    
    }

    public int getFila() {
        return Fila;
    }

    public void setFila(int Fila) {
        this.Fila = Fila;
    }

    public int getColumna() {
        return Columna;
    }

    public void setColumna(int Columna) {
        this.Columna = Columna;
    }
    

    public TipoToken getTipo() {
        return Tipo;
    }

    public void setTipo(TipoToken Tipo) {
        this.Tipo = Tipo;
    }

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }
    
    
}
