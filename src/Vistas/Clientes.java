

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas; 

import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import Conexiones.Conexion;
/**
 *
 * @author yairs
 */
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        initButtons();
        this.setPreferredSize(new Dimension(500, 500));
        pack();

        
    }
    private void initButtons() {
        // Crear los botones

        JButton btnSalir = new JButton("Salir");
        JButton btnRefacciones = new JButton("Refacciones");
JButton btnServicioCorrectivo = new JButton("Servicio Correctivo");
JButton btnServicioPreventivo = new JButton("Servicio Preventivo");
    
        // Agregar ActionListener al botón "Nuevo"
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
            // Agregar ActionListener al botón "Eliminar"
    btnEliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnEliminarActionPerformed(evt);
        }
    });
    btnModificar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnModificarActionPerformed(evt);
        }
    });
    btnRefacciones.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Refacciones Refacciones = new Refacciones();
            Refacciones.setVisible(true);
            this.dispose();
        }

        private void dispose() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'dispose'");
        }
    });
    
    btnServicioCorrectivo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ServicioCorrectivo ServicioCorrectivo = new ServicioCorrectivo();
            ServicioCorrectivo.setVisible(true);
            this.dispose(); }

        private void dispose() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'dispose'");
        }
    });
    
    btnServicioPreventivo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ServicioPreventivo servicioPreventivo = new ServicioPreventivo();
            servicioPreventivo.setVisible(true);
            dispose(); // Cierra la ventana actual de Clientes
        } 

        private void dispose() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'dispose'");
        }
    });
    
    btnConsultar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnConsultarActionPerformed(evt);
        }
    });
    
    // Agregar los botones al panel principal
    getContentPane().add(btnNuevo);

    // Establecer el diseño del panel principal
    GroupLayout layout = (GroupLayout) getContentPane().getLayout();
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo)
            .addComponent(btnEliminar)
            .addComponent(btnModificar) 
            .addComponent(btnConsultar)
            .addComponent(btnAgregar)
            .addComponent(btnRefacciones)
            .addComponent(btnServicioCorrectivo)
            .addComponent(btnServicioPreventivo)


    );
    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNuevo)
            .addComponent(btnEliminar)
            .addComponent(btnModificar)
            .addComponent(btnConsultar)
            .addComponent(btnAgregar)
            .addComponent(btnRefacciones)
            .addComponent(btnServicioCorrectivo)
            .addComponent(btnServicioPreventivo)

    );

    // Hacer visible la ventana
    pack();
    }// Close the abrirMenu() method

        private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                          
            MenuPrincipal MenuPrincipal = new MenuPrincipal();
            MenuPrincipal.setVisible(true);
            // Cierra la ventana actual
            this.dispose();
        }  
        
        private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {
            agregarCliente();
        }
        private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                          
    // Obtener el ID del cliente que se va a eliminar
    String id = txtFolio.getText();

    try (Connection con = conexion.getConexion();
         PreparedStatement ps = con.prepareStatement("DELETE FROM Clientes WHERE Id = ?")) {
        ps.setString(1, id);

        // Ejecutar la sentencia SQL
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            // Limpiar los campos después de eliminar
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el cliente con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }        }

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        String id = txtFolio.getText();
        String nombre = txtNombre.getText();
        String apPaterno = txtPaterno.getText();
        String apMaterno = txtMaterno.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
    
        try (Connection con = conexion.getConexion();
        PreparedStatement ps = con.prepareStatement("UPDATE Clientes SET Nombre=?, Ap_Paterno=?, Ap_Materno=?, Direccion=?, Telefono=? WHERE Id=?"))
        {
            ps.setString(1, nombre);
            ps.setString(2, apPaterno);
            ps.setString(3, apMaterno);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, id);
    
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el cliente con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener el ID del cliente a consultar
        String id = txtFolio.getText();
    
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Clientes WHERE Id = ?")) {
            ps.setString(1, id);
    
            // Ejecutar la consulta SQL
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
                // Mostrar los datos del cliente encontrado en los campos de texto
                txtNombre.setText(rs.getString("Nombre"));
                txtPaterno.setText(rs.getString("Ap_Paterno"));
                txtMaterno.setText(rs.getString("Ap_Materno"));
                txtDireccion.setText(rs.getString("Direccion"));
                txtTelefono.setText(rs.getString("Telefono"));
            } else {
                // Si no se encuentra el cliente, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "No se encontró el cliente con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción SQL
            JOptionPane.showMessageDialog(null, "Error al consultar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

        private void agregarCliente() {
            String id = txtFolio.getText();
            String nombre = txtNombre.getText();
            String apPaterno = txtPaterno.getText();
            String apMaterno = txtMaterno.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
        
            try (Connection con = conexion.getConexion();
                 PreparedStatement ps = con.prepareStatement("INSERT INTO Clientes (Id, Nombre, Ap_Paterno, Ap_Materno, Direccion, Telefono) VALUES (?, ?, ?, ?, ?, ?)")) {
                ps.setString(1, id);
                ps.setString(2, nombre);
                ps.setString(3, apPaterno);
                ps.setString(4, apMaterno);
                ps.setString(5, direccion);
                ps.setString(6, telefono);

        
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al agregar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        private void limpiarCampos() {
            txtFolio.setText("");
            txtNombre.setText("");
            txtMaterno.setText("");
            txtPaterno.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
        }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        txtFolio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jLabel8.setText("Folio:");

        jLabel9.setText("Nombre/s:");

        jLabel10.setText("Ap. Materno:");

        jLabel11.setText("Ap. Paterno:");

        jLabel12.setText("Direccion:");

        jLabel13.setText("Teléfono:");


        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Clientes");

        btnNuevo.setText("Nuevo");

        btnConsultar.setText("Consultar");

        btnAgregar.setText("Agregar");

        btnModificar.setText("Modificar");

        btnEliminar.setText("Eliminar");

        btnSalir.setText("Salir");

        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1)))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel12))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
            .addComponent(btnNuevo)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnConsultar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnAgregar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnModificar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnEliminar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSalir)
            .addGap(27, 27, 27))
    );

    pack();
}// </editor-fold>//GEN-END:initComponents


public void txtFrecuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFrecuenteActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtFrecuenteActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    // TODO add your handling code here:
    System.exit(0);
}//GEN-LAST:event_btnSalirActionPerformed

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
        java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Clientes().setVisible(true);
        }
    });
}



// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JButton btnAgregar;
private javax.swing.JButton btnConsultar;
private javax.swing.JButton btnEliminar;
private javax.swing.JButton btnModificar;
private javax.swing.JButton btnNuevo;
private javax.swing.JButton btnSalir;
public javax.swing.JLabel jLabel1;
public javax.swing.JLabel jLabel10;
public javax.swing.JLabel jLabel11;
public javax.swing.JLabel jLabel12;
public javax.swing.JLabel jLabel13;
public javax.swing.JLabel jLabel14;
public javax.swing.JLabel jLabel8;
public javax.swing.JLabel jLabel9;
public javax.swing.JTextField txtDireccion;
public javax.swing.JTextField txtFolio;
public javax.swing.JTextField txtMaterno;
public javax.swing.JTextField txtNombre;
public javax.swing.JTextField txtPaterno;
public javax.swing.JTextField txtTelefono;
private Conexion conexion = new Conexion();
private Connection con = conexion.getConexion();
// End of variables declaration//GEN-END:variables
public Object getjMenuNuevo() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getjMenuNuevo'");
}

public Object getjMenuSalir() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getjMenuSalir'");
}


}

