
package com.mycompany.practica1.lexico;

public enum TipoToken {
        Identificador(""),
        Numero(""),
        Reservada(""),
        Literal(""),
        Comentarios(""),
        Igual(""),
        ParentesisAbre(""),
        ParentesisCierra(""),
        Operador(""),
        Final("");
        
        private String Lexema;
        
        private TipoToken(String Lexema){
            this.Lexema = Lexema;
        }

    
    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    } 
        
}
