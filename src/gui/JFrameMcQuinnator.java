/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import McQuinnator.Fase1;
import McQuinnator.Fase2;
import java.awt.event.KeyEvent;

/**
 *
 * @author Esteban
 */
public class JFrameMcQuinnator extends javax.swing.JFrame {

    private Fase1 fase1;
    private int tablaActual;
    
    /**
     * Creates new form JFrameHaceTablas
     */
    public JFrameMcQuinnator() {
        fase1 = null;
        initComponents();
        this.Error.setVisible(false);
        tablaActual = -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        Formato = new javax.swing.JLabel();
        Entrada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaTabla = new javax.swing.JTextArea();
        Creador = new javax.swing.JButton();
        Derecha = new javax.swing.JButton();
        Izquierda = new javax.swing.JButton();
        CantidadTablas = new javax.swing.JLabel();
        NumeroTabla = new javax.swing.JLabel();
        Error = new javax.swing.JLabel();
        FuncionAnterior = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BotonTPrimos = new javax.swing.JButton();
        BotonTPrimosNoColapsados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("McQuinnator");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("F0C");

        Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Label.setText("Ingrese la Función:");

        Formato.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Formato.setText("E<b>:(<Términos>)");

        Entrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EntradaFocusGained(evt);
            }
        });
        Entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EntradaKeyTyped(evt);
            }
        });

        TextAreaTabla.setEditable(false);
        TextAreaTabla.setColumns(20);
        TextAreaTabla.setRows(5);
        jScrollPane1.setViewportView(TextAreaTabla);

        Creador.setText("Hacer Tablas");
        Creador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreadorActionPerformed(evt);
            }
        });
        Creador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CreadorKeyTyped(evt);
            }
        });

        Derecha.setText("Siguiente Tabla");
        Derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DerechaActionPerformed(evt);
            }
        });

        Izquierda.setText("Anterior Tabla");
        Izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzquierdaActionPerformed(evt);
            }
        });

        CantidadTablas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CantidadTablas.setText("Cantidad de Tablas: 0");

        NumeroTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumeroTabla.setText("Tabla: ");

        Error.setText("Ingrese una función váilda");

        FuncionAnterior.setEditable(false);
        FuncionAnterior.setText("Aquí estará la función ingresada anteriormente");

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Kirstein");

        BotonTPrimos.setText("Mostrar/Ocultar Primos Colapsados");
        BotonTPrimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTPrimosActionPerformed(evt);
            }
        });

        BotonTPrimosNoColapsados.setText("Mostrar/Ocultar Primos No Colapsados");
        BotonTPrimosNoColapsados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTPrimosNoColapsadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NumeroTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Izquierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Formato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CantidadTablas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonTPrimos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Entrada)
                    .addComponent(FuncionAnterior)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Derecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Creador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonTPrimosNoColapsados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Formato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FuncionAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Creador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(Derecha)
                        .addGap(44, 44, 44)
                        .addComponent(BotonTPrimosNoColapsados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(Error, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(Izquierda)
                        .addGap(37, 37, 37)
                        .addComponent(BotonTPrimos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NumeroTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CantidadTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzquierdaActionPerformed
        // TODO add your handling code here:
        if(this.fase1 != null && this.tablaActual > 0){
            this.tablaActual--;
            this.TextAreaTabla.setText(this.fase1.getTablas().get(this.tablaActual).toString());
            this.NumeroTabla.setText("Tabla: " + (this.tablaActual+1));
        }
    }//GEN-LAST:event_IzquierdaActionPerformed

    private void CreadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreadorActionPerformed
        // TODO add your handling code here:
        try{
            this.fase1 = new Fase1(this.Entrada.getText());
            this.fase1.hacerTablas();
            this.tablaActual = 0;
            this.TextAreaTabla.setText(this.fase1.getTablas().get(this.tablaActual).toString());
            this.FuncionAnterior.setText(this.Entrada.getText());
            this.NumeroTabla.setText("Tabla: " + (this.tablaActual+1));
            this.CantidadTablas.setText("Cantidad de Tablas: " + this.fase1.getTablas().size());
        }catch(Exception exc){
            this.Error.setVisible(true);
            this.TextAreaTabla.setText("");
        }
    }//GEN-LAST:event_CreadorActionPerformed

    private void EntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EntradaFocusGained
        // TODO add your handling code here:
        this.Entrada.setText("");
    }//GEN-LAST:event_EntradaFocusGained

    private void DerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DerechaActionPerformed
        // TODO add your handling code here:
        if(this.fase1 != null && this.tablaActual < this.fase1.getTablas().size()-1){
            this.tablaActual++;
            this.TextAreaTabla.setText(this.fase1.getTablas().get(this.tablaActual).toString());
            this.NumeroTabla.setText("Tabla: " + (this.tablaActual+1));
        }
    }//GEN-LAST:event_DerechaActionPerformed

    private void CreadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CreadorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CreadorKeyTyped

    private void EntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntradaKeyTyped
        // TODO add your handling code here:
        char capturaTecla = evt.getKeyChar();
        
        if(capturaTecla == KeyEvent.VK_ENTER){
            this.Creador.doClick();
        }
    }//GEN-LAST:event_EntradaKeyTyped

    private void BotonTPrimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTPrimosActionPerformed
        // TODO add your handling code here:
        if(this.fase1 != null){
            if(!this.TextAreaTabla.getText().equals(new Fase2(this.fase1).getTablaEsenciales().mostrarPrimosString())){
                this.TextAreaTabla.setText(new Fase2(this.fase1).getTablaEsenciales().mostrarPrimosString());
            }
            else{
                this.TextAreaTabla.setText(this.fase1.getTablas().get(this.tablaActual).toString());
            }
        }
    }//GEN-LAST:event_BotonTPrimosActionPerformed

    private void BotonTPrimosNoColapsadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTPrimosNoColapsadosActionPerformed
        // TODO add your handling code here:
        if(this.fase1 != null){
            if(!this.TextAreaTabla.getText().equals(new Fase2(this.fase1).getTablaEsenciales().mostrarPrimosNoColapsadosString())){
                this.TextAreaTabla.setText(new Fase2(this.fase1).getTablaEsenciales().mostrarPrimosNoColapsadosString());
            }
            else{
                this.TextAreaTabla.setText(this.fase1.getTablas().get(this.tablaActual).toString());
            }
        }
    }//GEN-LAST:event_BotonTPrimosNoColapsadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMcQuinnator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMcQuinnator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMcQuinnator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMcQuinnator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMcQuinnator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonTPrimos;
    private javax.swing.JButton BotonTPrimosNoColapsados;
    private javax.swing.JLabel CantidadTablas;
    private javax.swing.JButton Creador;
    private javax.swing.JButton Derecha;
    private javax.swing.JTextField Entrada;
    private javax.swing.JLabel Error;
    private javax.swing.JLabel Formato;
    private javax.swing.JTextField FuncionAnterior;
    private javax.swing.JButton Izquierda;
    private javax.swing.JLabel Label;
    private javax.swing.JLabel NumeroTabla;
    private javax.swing.JTextArea TextAreaTabla;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}