/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.serialjava;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author Jesus Zeballos
 */
public class frmEnvResData extends javax.swing.JFrame {

    public frmEnvResData() {
        initComponents();
        buscaPuertos();
        this.setLocationRelativeTo(null);
    }

    ObservableList<String> lstPuertos;
    SerialPort puertoSerial;
    intenaConexion iConn = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbListaPuertos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblEstadoCN = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTexto = new javax.swing.JTextArea();
        txtDatos = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Datos Puerto Serial JAVA");

        cmbListaPuertos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un Puerto" }));
        cmbListaPuertos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaPuertosActionPerformed(evt);
            }
        });

        jLabel1.setText("PUERTOS DISPONIBLES :");

        lblEstadoCN.setText("Estado  :");

        jLabel2.setText("Datos recibidos :");

        jTexto.setColumns(20);
        jTexto.setRows(5);
        jScrollPane1.setViewportView(jTexto);

        btnEnviar.setText("Enviar Datos");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbListaPuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbListaPuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstadoCN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbListaPuertosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaPuertosActionPerformed
        String puerto = "";
        puerto = cmbListaPuertos.getSelectedItem().toString();
        System.out.println("Puerto seleccionado : " + puerto);
        lblEstadoCN.setText("Estado : ...");
        iConn = new intenaConexion(this, puerto);
        iConn.start();     

    }//GEN-LAST:event_cmbListaPuertosActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (iConn != null) {
            if (iConn.getEstado() == 1) {
                String respDato = iConn.enviarDatos(txtDatos.getText().trim());
                if (!respDato.equalsIgnoreCase("0")){
                    JOptionPane.showMessageDialog(null, respDato);
                }
            } else if (iConn.getEstado() == 2) {
                JOptionPane.showMessageDialog(null, "En espera de conectarse a un puerto");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha conectado a algun puerto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Para enviar datos debes conectarte a un Puerto");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private boolean realizaConexion(String puerto) {
        boolean resp = false;
        System.out.println("Intenta conectar al puerto:" + " " + puerto);
        puertoSerial = new SerialPort(puerto);
        try {
            puertoSerial.openPort();
            puertoSerial.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            puertoSerial.setEventsMask(MASK_RXCHAR);
            puertoSerial.addEventListener((SerialPortEvent serialPortEvent) -> {
                if (serialPortEvent.isRXCHAR()) {
                    try {
                        String st = puertoSerial.readString();
                        if (st != null) {
                            System.out.println("Mensaje recibido : " + st);
                            jTexto.setText(st);
                        }
                    } catch (SerialPortException ex) {
                        System.out.println("Error al recibir datos....");
                    }
                }
            });
            resp = true;
            lblEstadoCN.setText("Conexion exitosa en puerto " + puerto);
        } catch (Exception e) {
            System.out.println("Error al conectar al puerto : " + puerto + "\n Err: " + e.getMessage());
            lblEstadoCN.setText("Error de conexion en el puerto " + puerto);
        }
        return resp;
    }

    public void setEstado(String estado) {
        lblEstadoCN.setText("Estado : " + estado);
    }

    public void setDatosRecibidos(String datos) {
        jTexto.setText(datos);
    }

    private void buscaPuertos() {
        lstPuertos = FXCollections.observableArrayList();
        String[] serialPortNames = SerialPortList.getPortNames();
        for (String name : serialPortNames) {
            lstPuertos.add(name);
            cmbListaPuertos.addItem(name);
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmEnvResData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEnvResData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEnvResData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEnvResData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEnvResData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cmbListaPuertos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTexto;
    private javax.swing.JLabel lblEstadoCN;
    private javax.swing.JTextField txtDatos;
    // End of variables declaration//GEN-END:variables
}

class intenaConexion extends Thread {

    SerialPort puertoSerial;
    String puerto = "";
    frmEnvResData frm = null;
    int estado = 0;

    public intenaConexion(frmEnvResData form, String prto) {
        this.frm = form;
        this.puerto = prto;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            realizaConexion(puerto);
        } catch (Exception e) {
            System.out.println("Error en hilo");
        }
    }

    public int getEstado() {
        return this.estado;
    }

    private void realizaConexion(String puerto) {
        System.out.println("Intenta conectar al puerto:" + " " + puerto);
        this.estado = 2;
        puertoSerial = new SerialPort(puerto);
        try {
            this.frm.setEstado("Esperando conexion con el puerto " + puerto);
            puertoSerial.openPort();
            puertoSerial.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            puertoSerial.setEventsMask(MASK_RXCHAR);
            puertoSerial.addEventListener((SerialPortEvent serialPortEvent) -> {
                if (serialPortEvent.isRXCHAR()) {
                    try {
                        String dato = puertoSerial.readString();
                        if (dato != null) {
                            this.frm.setDatosRecibidos(dato);
                        }
                    } catch (SerialPortException ex) {
                        System.out.println("Error al recibir datos....");
                    }
                }
            });
            this.estado = 1;
            this.frm.setEstado("Conexion exitosa en puerto " + puerto);
        } catch (Exception e) {
            System.out.println("Error al conectar al puerto : " + puerto + "\n Err: " + e.getMessage());
            this.frm.setEstado("Error de conexion en el puerto " + puerto);
            this.estado = 0;
        }

    }

    public String enviarDatos(String dato) {
        try {
            puertoSerial.writeString(dato);
            return "0";
        } catch (SerialPortException ex) {
            System.out.println("Error al enviar Datos !!!!");
            return "No se han podido enviar los datos";
        }
    }
}
