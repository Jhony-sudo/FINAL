/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1.ventanas;

import com.mycompany.practica1.cargaarchivos.Leer;
import com.mycompany.practica1.lexico.Analizador;
import com.mycompany.practica1.lexico.ManejadorToken;
import com.mycompany.practica1.semantico.AnalizadorS;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;


/**
 *
 * @author ROM
 */
public class Principal extends javax.swing.JFrame {

   private Principal AnalizarR;
   
    public Principal() {
        initComponents();
     Log.setEditable(false);
     Texto.addCaretListener( new CaretListener() {

     public void caretUpdate( CaretEvent e ) {

     int pos = e.getDot();
         
        try {

           int row = Texto.getLineOfOffset( pos ) + 1;

           int col = pos - Texto.getLineStartOffset( row - 1 ) + 1;
           
           Posicion.setText("Línea: " + row + " Columna: " + col );

       }

       catch( BadLocationException exc ){

           System.out.println(exc);

       }

    }

    });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Texto = new javax.swing.JTextArea();
        Analizar = new javax.swing.JButton();
        Posicion = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Palabra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Log = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Abrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Texto.setColumns(20);
        Texto.setRows(5);
        jScrollPane1.setViewportView(Texto);

        Analizar.setText("Ejecutar");
        Analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarActionPerformed(evt);
            }
        });

        Posicion.setText(".");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Log.setColumns(20);
        Log.setRows(5);
        jScrollPane2.setViewportView(Log);

        jLabel1.setText("Buscar Palabra");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Posicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Palabra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Analizar)
                                    .addGap(5, 5, 5))
                                .addComponent(Buscar)))
                        .addGap(13, 13, 13)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Guardar)
                .addGap(27, 27, 27)
                .addComponent(Abrir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Abrir))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Analizar)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Palabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Buscar)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(Posicion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarActionPerformed
       Analizador n = new Analizador(Texto.getText());
       ManejadorToken Manejador = new ManejadorToken();
       AnalizadorS S = new AnalizadorS();
       
        n.Iniciar();
        Errores R;
        Manejador.ConteoTokens();
        ReporteToken T;
        if(Analizador.HayError){
            R = new Errores(); 
            R.setVisible(true);
        } 
        else{
            Resultado r = new Resultado();
            T = new ReporteToken();
            T.setVisible(true);
            S.Analizar();
            r.setVisible(true);
            Resultado.Resultado.setText(AnalizadorS.Salida);
        }
        
        Analizador.HayError = false;
        
        Manejador.Reiniciar();
        Log.setText(Analizador.Pasos);
        Analizador.Pasos = "";
        
    }//GEN-LAST:event_AnalizarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        if(Palabra.getText().length() >= 1){
        Busqueda n = new Busqueda(Texto.getText(),Palabra.getText());
        n.setVisible(true);
        } else {
          javax.swing.JOptionPane.showMessageDialog(Texto,"la palabra a buscar no puede ser vacia");
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Inicio n = new Inicio();
        n.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        JFileChooser fileChosser = new JFileChooser();
       AnalizarR = new Principal();
        int seleccion = fileChosser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChosser.getSelectedFile();
            String Direccion = fileChosser.getSelectedFile().getAbsolutePath();
            Leer.LeerArchivo(Direccion,this.getEspacio());
            //this.setVisible(true);
        }
        
    }//GEN-LAST:event_AbrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChosser.getSelectedFile();
            String Direccion = fileChosser.getSelectedFile().getAbsolutePath();
            Leer.Escribir(Direccion, Texto.getText());
            
        }
    }//GEN-LAST:event_GuardarActionPerformed

    
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abrir;
    private javax.swing.JButton Analizar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextArea Log;
    private javax.swing.JTextField Palabra;
    private javax.swing.JLabel Posicion;
    private javax.swing.JTextArea Texto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JTextArea getEspacio(){
    
       return Texto;
    }
}
