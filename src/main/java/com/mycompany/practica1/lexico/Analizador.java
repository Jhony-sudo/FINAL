
package com.mycompany.practica1.lexico;




public class Analizador {
    private static int Estados = 12;
    private static int Alfabeto = 13;
    int [][] Transicion = new int [Estados][Alfabeto];
    String [] PalabrasReservadas = {"SI","FIN","INICIO","ESCRIBIR","VERDADERO","FALSO","ENTONCES","INICIAR","REPETIR"};
    private String Texto;
    private int Posicion = 0;
    private int EstadoActual;
    private int EstadoAnterior;
    private String Lexema = "";
    private int Linea = 1;
    private int Columna = 1;
    public static boolean HayError = false;
    private ManejadorToken n = new ManejadorToken();
    public static String Pasos = "";
    //Transiciones y Estados
    {
        
      for(int i =0;i<Estados;i++){
          for(int x=0;x<Alfabeto;x++){
              Transicion[i][x]=-1;
              
          }
      }
      Transicion[0][0] = 1;
      Transicion[0][1] = 2;
      Transicion[0][2] = 1;
      Transicion[0][3] = 2;
      Transicion[0][4] = 4;
      Transicion[0][12] = 3;
      Transicion[0][8] = 8;
      Transicion[0][9] = 9;
      Transicion[0][10] = 10;
      Transicion[0][11] = 11;
      Transicion[1][0] = 1;
      Transicion[1][1] = 1;
      Transicion[1][2] = 1;
      Transicion[2][1] = 2;
      Transicion[3][12] = 5;
      Transicion[4][0] = 4;
      Transicion[4][4] = 7;
      Transicion[5][7] = 6;
      Transicion[5][0] = 5;
      
      
      Transicion[11][6] = 0;
      Transicion[10][6] = 0;
      Transicion[9][6] = 0;
      Transicion[8][6] = 0;
      Transicion[7][6] = 0;
      Transicion[6][6] = 0;
      Transicion[5][6] = 0;
      Transicion[4][6] = 0;
      Transicion[3][6] = 0;
      Transicion[2][6] = 0;
      Transicion[1][6] = 0;
      Transicion[0][6] = 0;
      
       Transicion[11][7] = 0;
      Transicion[10][7] = 0;
      Transicion[9][7] = 0;
      Transicion[8][7] = 0;
      Transicion[7][7] = 0;
      Transicion[6][7] = 0;
      Transicion[4][7] = 0;
      Transicion[3][7] = 0;
      Transicion[2][7] = 0;
      Transicion[1][7] = 0;
      Transicion[0][7] = 0;
      
      
      
    }
    
   
    public Analizador(String Texto){
        this.Texto = Texto;
    }
    
    public void Iniciar(){
       int Longitud = Texto.length();
       
       EstadoActual = 0;
       while(Posicion < Longitud){
           char CaracterA = Texto.charAt(Posicion);
           EstadoAnterior =  EstadoActual;
           
           
           if(getCaracter(CaracterA) != -1){    
           EstadoActual = Transicion[EstadoActual][getCaracter(CaracterA)];
           //EstadoActual = (Character.isSpaceChar(CaracterA))?0:EstadoActual;
            
                if(!Reiniciar(EstadoActual,EstadoAnterior,CaracterA)){
                 
                Pasos = Pasos + "Me movi del estado" + EstadoAnterior + " al estado" + EstadoActual + " CON UNA " + CaracterA + "\n";
                Lexema = Lexema + CaracterA;
                }
           
           
           
           }else{ 
                 Pasos = Pasos + ("Error "  + CaracterA + " No se encuentra en el alfabeto") + "\n"; 
                 Lexema = Lexema + CaracterA;
                 n.ReportarError(Lexema, Columna, Linea);
                 HayError = true;
                 Lexema = "";
                 EstadoActual = 0;
                 }
           Posicion ++;
           Linea ++;
           
           if(Posicion == Longitud){
               Pasos = Pasos+"Fin de la cadena" + "\n";
               AsignarToken(EstadoActual);
           }
           
           
       }
    }
    
    public boolean Reiniciar(int Estado, int Anterior, char CaracterA){
        boolean tmp = false;
        
        /*if(Estado == 6 | Estado == 5 | Estado == 8 ){
            
            Pasos = Pasos+"Me movi del estado" + EstadoAnterior + " al estado" + EstadoActual + " CON UNA " + CaracterA + "\n";
            Lexema = CaracterA + "";
            tmp = true;
            
        }*/
        if(getCaracter(CaracterA) == 6){
            EstadoActual = 0;
            Pasos = Pasos+"Se encontro un espacio, reiniciando automata" + "\n";
            
            AsignarToken(Anterior);
            
           Lexema = "";
            tmp = true;
        }
        if(CaracterA == '\n'){
            if (EstadoAnterior == 5)
                Anterior =6;
            
            EstadoActual = 0;
            Pasos = Pasos + " Salto de Linea" + "\n";
            
            AsignarToken(Anterior);
            Linea = 0;
            Columna++;
            
            Lexema = "";
            tmp = true;
        }
        if(Estado == -1){
            
            EstadoActual = 0;
            Pasos = Pasos+"Error con " + CaracterA + " en " + Lexema + ("en Columna " + Columna + " Linea: " + Linea )+"\n";
            Pasos = Pasos+"Reiniciando Automata" + "\n";
            Lexema = Lexema + CaracterA;
            n.ReportarError(Lexema, Columna, Linea);
            HayError =  true;
            
            Lexema = "";
            tmp = true;
        }
        return tmp;
    }
    
    
    
    public void AsignarToken(int Estado){
       
        switch(Estado){
            
            case 1:
                  if(esReservada(Lexema)){
                  n.Llenar(TipoToken.Reservada,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Palabra Reservada Lexema:" + Lexema + "\n";
                  }else{
                  n.Llenar(TipoToken.Identificador,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Identificador Lexema:" + Lexema + "\n";
                  }
                  break;
            case 2:
                  n.Llenar(TipoToken.Numero,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Numero Lexema: " + Lexema+"\n";
                
                break;
            
            case 6:
                  n.Llenar(TipoToken.Comentarios,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Comentario Lexema:" + Lexema+"\n";
                
                break;
            case 7:
                  n.Llenar(TipoToken.Literal,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Identificador Lexema:" + Lexema+"\n";
                
                break;
            case 8:
                  n.Llenar(TipoToken.Igual,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Identificador Lexema:" + Lexema+"\n";
                
                break;
            
            case 9:
                  n.Llenar(TipoToken.Operador,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Identificador Lexema:" + Lexema+"\n";
                
                break;
                
            case 10:  
                  n.Llenar(TipoToken.ParentesisAbre,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Identificador Lexema:" + Lexema+"\n";
                
                break;
            
            case 11:  
                  n.Llenar(TipoToken.ParentesisCierra,Lexema,Linea,Columna);
                  Pasos = Pasos + "Asignando Token: Identificador Lexema:" + Lexema+"\n";
                
                break;
            
                
            default:
                
                break; 
                
        }
        
        
    }
    
    public int getCaracter(char Caracter){
        int tmp = -1;
        if(EstadoActual == 4 | EstadoActual == 5){
            tmp = 0;
            if(Caracter == '\n'){
            tmp= 7;
            }
            if(Caracter == '"'){
            tmp = 4;
             }
        }else{
            
        if(Character.isDigit(Caracter)){
            if(EstadoActual == 0 && Caracter != '0'){
            tmp = 1;
            }
            if(EstadoActual == 2 ){
                if(Lexema.equals("-") && Caracter !='0'){
                    
                   
                    tmp = 1;
                }
                if(!Lexema.equals("-") ){
                    
                    tmp = 1;
                }
            }
            
            if(EstadoActual == 1){
                tmp = 1;
            }
        }
        if(Character.isLetter(Caracter) && Caracter != 'ñ'){
            tmp = 0;
        }
        if(Caracter == '_'){
            tmp = 2;
        }
        if(Caracter == '-'){
            tmp = 3;
        }
        if(Caracter == '"'){
            tmp = 4;
        }
        if(Character.isSpaceChar(Caracter)){
            tmp= 6;
        }
        if(Caracter == '\n' | Caracter == '\t' | Caracter == '\r'  ){
        tmp= 7;
        }
        
        
        if(Caracter =='/'){
            tmp = 12;
        }
        if(Caracter == '"' && EstadoActual == 4){
            
            tmp = 5;
        }
        if(Caracter == '='){
            tmp = 8;
        }
        if(esOperador(Caracter)){
            tmp = 9;
        }
        if(Caracter == '('){
            tmp = 10;
        }
        
        if(Caracter == ')'){
            tmp = 11;
        }
         }
        return tmp;
    }
    
    
    
    public boolean esOperador(char Caracter){
        boolean tmp = false;
        if(Caracter == '+' | Caracter == '*') {
            tmp = true;
        }
        return tmp;
    }
    
    public boolean esPuntuacion(char Caracter){
        boolean tmp = false;
        if(Caracter == '.' | Caracter == ';' | Caracter == ',' | Caracter == ':' ){
            tmp = true;
        }
        return tmp;
    }
    
    public boolean esReservada(String Lexema){
        boolean tmp = false;
        for(int x =0;x<PalabrasReservadas.length;x++){
            if(PalabrasReservadas[x].equals(Lexema)){
                tmp =true;
            }
        }
        return tmp;
    }
    
    
}
