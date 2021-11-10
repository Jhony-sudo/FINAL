package com.mycompany.practica1.semantico;

import java.util.ArrayList;

public class TablaValores {
    public static ArrayList<Variable> TablaVariables = new ArrayList<> ();
    
    
    public boolean Agregar(Variable V){
        boolean tmp = true;
        for(int i =0;i<TablaVariables.size();i++){
            if(V.getNombre().equals(TablaVariables.get(i).getNombre())){
                tmp = false;
            }
        }
        return tmp;
    }
    
    public static boolean Devolver(String Nombre){
        boolean tmp = false;
        for(int i =0;i<TablaVariables.size();i++){
            if(Nombre.equals(TablaVariables.get(i).getNombre())){
                tmp = true;
            }
        }
        return tmp;
    }
}
