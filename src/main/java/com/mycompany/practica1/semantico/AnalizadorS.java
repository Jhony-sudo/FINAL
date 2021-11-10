package com.mycompany.practica1.semantico;

import com.mycompany.practica1.lexico.Analizador;
import com.mycompany.practica1.lexico.ManejadorToken;
import com.mycompany.practica1.lexico.TipoToken;
import com.mycompany.practica1.lexico.Token;
import java.util.Stack;


public class AnalizadorS{
    private static int NoToken = 17;
    public static String Salida = "";
    private static int NoTerminales = 15;
    private static String [][] TablaAnalisis = new String [NoTerminales][NoToken];
    private Token TokenSiguiente;
    private Token TokenActual;
    private int TerminalActual = 0;
    private Stack<String> Pilap = new Stack();
    private Pila p = new Pila(Pilap);
    
    {
      
      TablaAnalisis[0][0] = "S-EXPRESION";
      TablaAnalisis[0][1] = "S-EXPRESION";
      TablaAnalisis[0][5] = "S-EXPRESION";
      TablaAnalisis[0][8] = "S-ESCRITURA";
      TablaAnalisis[0][10] = "S-CONDICIONAL";
      TablaAnalisis[0][13] = "S-R";
      TablaAnalisis[0][16] = "e";
      TablaAnalisis[1][8] = "FIN-A-ESCRIBIR";
      TablaAnalisis[2][13] = "FIN-P-INICIO-B-REPETIR";
      TablaAnalisis[3][10] = "FIN-V-ENTONCES-W-SI";
      TablaAnalisis[4][0] = "X'-T";
      TablaAnalisis[4][1] = "X'-T";
      TablaAnalisis[4][5] = "X'-T";
      TablaAnalisis[5][1] = "FIN-EXPRESION-=-Identificador";
      TablaAnalisis[6][0] = "Numero";
      TablaAnalisis[6][1] = "Identificador";
      TablaAnalisis[6][4] = "Literal";
      TablaAnalisis[7][0] = "Numero";
      TablaAnalisis[7][1] = "Identificador";
      TablaAnalisis[8][8] = "P-ESCRITURA";
      TablaAnalisis[8][9] = "e";
      TablaAnalisis[9][11] = "VERDADERO";
      TablaAnalisis[9][12] = "FALSO";
      TablaAnalisis[10][8] = "ESCRITURA";
      TablaAnalisis[10][9] = "e";
      TablaAnalisis[11][0] = "e";
      TablaAnalisis[11][1] = "e";      
      TablaAnalisis[11][2] = "X'-T-+";
      TablaAnalisis[11][5] = "e";
      TablaAnalisis[11][6] = "e";
      TablaAnalisis[11][8] = "e";
      TablaAnalisis[11][9] = "e";
      TablaAnalisis[11][10] = "e";
      TablaAnalisis[11][13] = "e";
      TablaAnalisis[11][16] = "e";
      TablaAnalisis[12][0] = "T'-E";
      TablaAnalisis[12][1] = "T'-E";
      TablaAnalisis[12][5] = "T'-E";
      TablaAnalisis[12][16] = "e";
      TablaAnalisis[13][0] = "e";
      TablaAnalisis[13][1] = "e";
      TablaAnalisis[13][2] = "e";
      TablaAnalisis[13][3] = "T'-E-*";
      TablaAnalisis[13][6] = "e";
      TablaAnalisis[13][8] = "e";
      TablaAnalisis[13][9] = "e";
      TablaAnalisis[13][10] = "e";
      TablaAnalisis[13][13] = "e";
      TablaAnalisis[13][16] = "e";
      TablaAnalisis[14][0] = "Numero";
      TablaAnalisis[14][1] = "Identificador";
      TablaAnalisis[14][5] = ")-EXPRESION-(";      
    }
    
    public AnalizadorS(){
    
    }
    
    public void Analizar(){
        p.Iniciar();
        TokenActual = p.PedirToken();
        TokenSiguiente = p.TokenSiguiente();
        Token Antes = TokenActual;
        boolean Continuar = true;
        
        while(p.Continuar() | Continuar){
            int Tipo = -1;
            if(Pila.Posicion < ManejadorToken.Token.size()){
            Tipo = getTipo(TokenActual);
            } else Tipo = 16;
                
                
            System.out.println("TERMINAL AL INICIO " + TerminalActual);
            System.out.println("Tipo de Token " + TokenActual.getTipo().name());
            System.out.println("Token Siguiente " + TokenSiguiente.getTipo().name());
            if(TokenActual.getTipo() == TipoToken.Identificador && p.TokenSiguiente().getTipo() == TipoToken.Igual){
                TablaAnalisis[0][1] = "S-ASIGNACION";
            }
            if(TerminalActual == -1 && Compatible(TokenActual)){
                System.out.println("Eliminando Token REDUCE");
                
                Pilap.pop();
                TokenActual = null;
            }else {
                if(TerminalActual == -1){
                     TerminalActual = getNoTerminal(Pilap.lastElement());
                     
                }
                System.out.println("Terminal Actual " + TerminalActual);
                System.out.println("Token Actual " + getTipo(TokenActual));
                if(TerminalActual == -1){
                    System.out.println("Error");
                    Analizador.Pasos = Analizador.Pasos + " Error Sintactico en Linea" +  TokenActual.getColumna() + " Columna " + TokenActual.getFila() +
                    " Se esperaba " + Error.getError(getTipo(Antes))  ;
                    Continuar = false;
                } else {
                 
                
                String Produccion = TablaAnalisis[TerminalActual][Tipo];
                
                
                
                if(!"e".equals(Produccion)){
                    
                    System.out.println("Epsilon");
                    p.Cambiar(Produccion);  
                } else Pilap.pop();
                System.out.println("Primer elemento pila " + Pilap.firstElement());
                System.out.println("Ultimo elemento pila " + Pilap.lastElement());
                TerminalActual = getNoTerminal(Pilap.lastElement()); }
                
            }
            
            TablaAnalisis[0][1] = "S-EXPRESION";
            if(TokenActual == null && Pila.Posicion < ManejadorToken.Token.size()){
                Antes = TokenActual;
                TokenActual = p.PedirToken();
                if(Pila.Posicion < ManejadorToken.Token.size())
                TokenSiguiente = p.TokenSiguiente();
            }
            if(TokenActual == null && Pila.Posicion == ManejadorToken.Token.size()){
                
                TokenActual = ManejadorToken.TokenFinal();
            }
            System.out.println("TERMINAL AL FINALIZAR" + TerminalActual);
            System.out.println("Pila ACTUAL " + p.Escribir());
            System.out.println("Token Actual" + TokenActual.getTipo().name());
        }
        if(Continuar){
        System.out.println("Interpretando");
        Interpretar(); }
        
    }
    
    public void Interpretar(){
        int x =0;
        while(x<ManejadorToken.Token.size()){
            Token T = ManejadorToken.Token.get(x);
            
            if(getTipo(T) == 8){
                Token Siguiente = ManejadorToken.Token.get(x+1);
                String n = Siguiente.getLexema();
                switch(getTipo(Siguiente)){
                    case 0:
                        Salida = Salida + n + "\n";
                        break;
                    case 1:
                        if(TablaValores.Devolver(n)){
                            Salida = Salida + n + "\n";
                        }
                        break;
                    case 4:
                        StringBuilder S = new StringBuilder(n); 
                        S = S.deleteCharAt(0);
                        S = S.deleteCharAt(S.length()-1);
                        Salida = Salida + S + "\n";
                        break;
                }
                
            }
            if(getTipo(T) == 1 && ManejadorToken.Token.get(x+1).getTipo() == TipoToken.Igual){
                System.out.println("Asignacion");
            }
            if(getTipo(T) == 10){
            }
            x++;
        }
    }
    
    public int getTipo(Token t){
        int n =0;
        if(t.getTipo() == TipoToken.Numero){
            n =0;
        }
        
        if(t.getTipo() == TipoToken.Identificador){
            n =1;
        }
        
        if(t.getTipo() == TipoToken.Operador){
            if("+".equals(t.getLexema())){
                n=2;
            }else n=3;
        }
        
        if(t.getTipo() == TipoToken.Literal){
            n=4;
        } 
        
        if(t.getTipo() == TipoToken.ParentesisAbre){
            n=5;
        }
         if(t.getTipo() == TipoToken.ParentesisCierra){
            n=6;
        }
         if(t.getTipo() == TipoToken.Igual){
            n=7;
        }
         if(t.getTipo() == TipoToken.Reservada){
            if ("ESCRIBIR".equals(t.getLexema())) n=8;
            if ("FIN".equals(t.getLexema())) n=9;
            if ("SI".equals(t.getLexema())) n=10;
            if ("VERDADERO".equals(t.getLexema())) n=11;
            if ("FALSO".equals(t.getLexema())) n=12;
            if ("REPETIR".equals(t.getLexema())) n=13;
            if ("INICIO".equals(t.getLexema())) n=14;
            if ("ENTONCES".equals(t.getLexema())) n=15;
        }
         if(ManejadorToken.Token.isEmpty()){
             n=16;
         }
        
        
        return n;
        
    }
    
    public int getNoTerminal(String Produccion){
        int n =-1;
        if("S".equals(Produccion))n=0;
        if("ESCRITURA".equals(Produccion))n=1;
        if("R".equals(Produccion))n=2;
        if("CONDICIONAL".equals(Produccion))n=3;
        if("EXPRESION".equals(Produccion))n=4;
        if("ASIGNACION".equals(Produccion))n=5;
        if("A".equals(Produccion))n=6;
        if("B".equals(Produccion))n=7;
        if("P".equals(Produccion))n=8;
        if("W".equals(Produccion))n=9;
        if("V".equals(Produccion))n=10;
        if("X'".equals(Produccion))n=11;
        if("T".equals(Produccion))n=12;
        if("T'".equals(Produccion))n=13;
        if("E".equals(Produccion))n=14;
        
        return n;
    
    }
    
    public boolean Compatible(Token T){
        boolean tmp = false;
        String Tipo = T.getTipo().name();
        String n = Pilap.lastElement();
        
        if("Reservada".equals(Tipo)){
            if(T.getLexema().equals(n)) 
            tmp = true;
        } else if(n.equals(Tipo)) tmp = true;
        
        if(n.equals(T.getLexema())){
            tmp = true;
        }
        if(TokenActual.getTipo() == TipoToken.Final){
            tmp = true;
        }
        return tmp;
    }
}
