/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import javax.swing.JMenuItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Conexiones.Conexion;
/**
 *
 * @author yairs
 */
public class ServicioCorrectivo extends javax.swing.JFrame {

    /**
     * Creates new form ServicioCorrectivo
     */
    public ServicioCorrectivo() {
        initComponents();
        configurarMenu(); 
    }

    private void configurarMenu() {
        // TODO Auto-generated method stub
         // Crear el elemento del menú "Salir"
         JMenuItem menuItemSalir = new JMenuItem("Salir");
         menuItemSalir.addActionListener(evt -> {
             // Lógica para manejar el evento del menú "Salir"
             System.exit(0);
         });
 
         // Agregar el elemento del menú "Salir" al menú "Archivo"
         jMenuSalir.add(menuItemSalir);
 
 
         JMenuItem menuItemNuevo = new JMenuItem("Nuevo");
         menuItemNuevo.addActionListener(evt -> {
             // Lógica para manejar el evento del menú "Nuevo"
             agregarNuevoServicioCorrectivo();
         });
     
         // Agregar el elemento del menú "Nuevo" al menú "Archivo"
         jMenuNuevo.add(menuItemNuevo);
 
         JMenuItem menuItemConsultar = new JMenuItem("Consultar");
         menuItemConsultar.addActionListener(evt -> {
             // Lógica para manejar el evento del menú "Consultar"
             consultarServicioCorrectivo();
         });
     
         // Agregar el elemento del menú "Consultar" al menú "Archivo"
         jMenuConsultar.add(menuItemConsultar);
 
         JMenuItem menuItemModificar = new JMenuItem("Modificar");
         menuItemModificar.addActionListener(evt -> {
             // Lógica para manejar el evento del menú "Modificar"
             modificarServicioCorrectivo();
         });
     
         // Agregar el elemento del menú "Modificar" al menú "Archivo"
         jMenuModificar.add(menuItemModificar);
 
             // Crear el elemento del menú "Eliminar"
     JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
     menuItemEliminar.addActionListener(evt -> {
         // Lógica para manejar el evento del menú "Eliminar"
         eliminarServicioCorrectivo();
     });

     
 
     // Agregar el elemento del menú "Eliminar" al menú "Archivo"
     jMenuEliminar.add(menuItemEliminar);
 
        }

    private void eliminarServicioCorrectivo() {
        // TODO Auto-generated method stub

        String idEliminacion = JOptionPane.showInputDialog(this, "Ingrese el ID del servicio preventivo a eliminar:");

        // Confirmar la eliminación con un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el servicio preventivo con ID " + idEliminacion + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar el servicio preventivo de la base de datos
            try {
                Connection con = new Conexion().getConexion();
                String query = "DELETE FROM Servicio_correctivo WHERE Id = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, idEliminacion);
                int filasAfectadas = pstmt.executeUpdate();
                
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Servicio preventivo eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún servicio preventivo con el ID especificado");
                }
                
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el servicio preventivo");
            }
        }
    }

    private void modificarServicioCorrectivo() {
        // TODO Auto-generated method stub
        String idModificacion = JOptionPane.showInputDialog(this, "Ingrese el ID del servicio preventivo a modificar:");

        // Consultar el servicio preventivo en la base de datos
        try {
            Connection con = new Conexion().getConexion();
            String query = "SELECT * FROM Servicio_correctivo WHERE Id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, idModificacion);
            ResultSet rs = pstmt.executeQuery();
            
            // Mostrar los resultados de la consulta en un cuadro de diálogo
            if (rs.next()) {
                // Obtener los datos actuales del servicio preventivo
                String modeloCocheActual = rs.getString("Modelo_Coche");
                String descripcionActual = rs.getString("Descripcion");
                String estadoActual = rs.getString("Estado_Servicio");
                long costoActual = rs.getLong("Costo_Estimado");
                String fechaActual = rs.getString("Fecha");
                String horaActual = rs.getString("Hora");
                String folioClienteActual = rs.getString("Clientes_Id");
                
                // Mostrar un formulario para que el usuario modifique los datos
                ModificarServicioDialog dialog = new ModificarServicioDialog(this, true, idModificacion, modeloCocheActual, descripcionActual, estadoActual, costoActual, fechaActual, horaActual, folioClienteActual);
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún servicio preventivo con el ID especificado");
            }
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar el servicio preventivo");
        }

    }

    private void consultarServicioCorrectivo() {
        // TODO Auto-generated method stub
        String idConsulta = JOptionPane.showInputDialog(this, "Ingrese el ID del servicio preventivo a consultar:");

        // Consultar el servicio preventivo en la base de datos
        try {
            Connection con = new Conexion().getConexion();
            String query = "SELECT * FROM Servicio_Correctivo WHERE Id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, idConsulta);
            ResultSet rs = pstmt.executeQuery();
            
            // Llenar los campos de texto con la información del servicio preventivo
            if (rs.next()) {
                txtId.setText(rs.getString("Id"));
                txtModelo.setText(rs.getString("Modelo_Coche"));
                txtDescripcion.setText(rs.getString("Descripcion"));
                txtEstado.setText(rs.getString("Estado_Servicio"));
                txtCosto.setText(Long.toString(rs.getLong("Costo_Estimado")));
                txtFecha.setText(rs.getString("Fecha"));
                txtHora.setText(rs.getString("Hora"));
                txtFolio.setText(rs.getString("Clientes_Id"));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún servicio preventivo con el ID especificado");
            }
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar el servicio preventivo");
        }

    }

    private void agregarNuevoServicioCorrectivo() {
        // TODO Auto-generated method stub
        String id = txtId.getText();
        String modeloCoche = txtModelo.getText();
        String descripcion = txtDescripcion.getText();
        String estadoServicio = txtEstado.getText();
        long costoEstimado = Long.parseLong(txtCosto.getText());
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        String clientesId = txtFolio.getText();
       
        // Insertar los datos en la base de datos
        try {
            Connection con = new Conexion().getConexion();
            String query = "INSERT INTO Servicio_correctivo (Id, Modelo_Coche, Descripcion, Estado_Servicio, Costo_Estimado, Fecha, Hora, Clientes_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, modeloCoche);
            pstmt.setString(3, descripcion);
            pstmt.setString(4, estadoServicio);
            pstmt.setLong(5, costoEstimado);
            pstmt.setString(6, fecha);
            pstmt.setString(7, hora);
            pstmt.setString(8, clientesId);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Servicio preventivo agregado correctamente");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar el servicio preventivo");
        }
        


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStatServicio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNuevo = new javax.swing.JMenu();
        jMenuConsultar = new javax.swing.JMenu();
        jMenuAgregar = new javax.swing.JMenu();
        jMenuModificar = new javax.swing.JMenu();
        jMenuEliminar = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Descripción:");

        jLabel4.setText("Estado del Coche:");

        jLabel5.setText("Status Servicio:");

        jLabel6.setText("Fecha:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel7.setText("Hora:");

        jLabel8.setText("Costo Estimado:");

        jLabel9.setText("Folio del Cliente:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Correctivo");

        jLabel1.setText("ID Servicio:");

        jLabel2.setText("Modelo del Coche:");

        jMenuNuevo.setText("Nuevo");
        jMenuBar1.add(jMenuNuevo);

        jMenuConsultar.setText("Consultar");
        jMenuBar1.add(jMenuConsultar);

        jMenuAgregar.setText("Agregar");
        jMenuBar1.add(jMenuAgregar);

        jMenuModificar.setText("Modificar");
        jMenuBar1.add(jMenuModificar);

        jMenuEliminar.setText("Eliminar");
        jMenuBar1.add(jMenuEliminar);

        jMenuSalir.setText("Salir");
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStatServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel10)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStatServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ServicioCorrectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicioCorrectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicioCorrectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicioCorrectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioCorrectivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenuAgregar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConsultar;
    private javax.swing.JMenu jMenuEliminar;
    private javax.swing.JMenu jMenuModificar;
    private javax.swing.JMenu jMenuNuevo;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtStatServicio;
    // End of variables declaration//GEN-END:variables
}
