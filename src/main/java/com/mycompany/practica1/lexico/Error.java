
package com.mycompany.practica1.lexico;

public class Error {
    private String Error;
    private int Columna;
    private int Fila;
    private String Descripcion;

    public Error(String Error, int Columna, int Fila) {
        this.Error = Error;
        this.Columna = Columna;
        this.Fila = Fila;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public int getColumna() {
        return Columna;
    }

    public void setColumna(int Columna) {
        this.Columna = Columna;
    }

    public int getFila() {
        return Fila;
    }

    public void setFila(int Fila) {
        this.Fila = Fila;
    }
    
    
    
}
