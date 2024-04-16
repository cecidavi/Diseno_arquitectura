package Vistas;

import Conexiones.Conexion;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Suministro extends javax.swing.JFrame {

    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtExistencias;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProveedor;
    private Conexion conexion = new Conexion();

    public Suministro() {
        initComponents();
        initButtons();
        this.setPreferredSize(new Dimension(700, 500));
        pack();
    }

    private void initButtons() {
        JButton btnNuevo = new JButton("Nuevo");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnSalir = new JButton("Salir");

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAdmins();
            }
        });

        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                consultarSuministro();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                modificarSuministro();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                eliminarSuministro();
            }
        });

        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.insets.bottom = 5;
        gbc.insets.left = 10;
        getContentPane().add(new javax.swing.JLabel("Id:"), gbc);
        gbc.gridy++;
        getContentPane().add(new javax.swing.JLabel("Nombre:"), gbc);
        gbc.gridy++;
        getContentPane().add(new javax.swing.JLabel("Marca:"), gbc);
        gbc.gridy++;
        getContentPane().add(new javax.swing.JLabel("Proveedor:"), gbc);
        gbc.gridy++;
        getContentPane().add(new javax.swing.JLabel("Existencias:"), gbc);
        gbc.gridy++;
        getContentPane().add(new javax.swing.JLabel("Precio:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets.left = 0;
        getContentPane().add(txtId, gbc);
        gbc.gridy++;
        getContentPane().add(txtNombre, gbc);
        gbc.gridy++;
        getContentPane().add(txtMarca, gbc);
        gbc.gridy++;
        getContentPane().add(txtProveedor, gbc);
        gbc.gridy++;
        getContentPane().add(txtExistencias, gbc);
        gbc.gridy++;
        getContentPane().add(txtPrecio, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        getContentPane().add(btnNuevo, gbc);
        gbc.gridy++;
        getContentPane().add(btnConsultar, gbc);
        gbc.gridy++;
        getContentPane().add(btnAgregar, gbc);
        gbc.gridy++;
        getContentPane().add(btnModificar, gbc);
        gbc.gridy++;
        getContentPane().add(btnEliminar, gbc);
        gbc.gridy++;
        getContentPane().add(btnSalir, gbc);
    }

    private void abrirAdmins() {
        Admins admins = new Admins();
        admins.setVisible(true);
        this.dispose();
    }

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        agregarSuministro();
    }

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        consultarSuministro();
    }
    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        modificarSuministro();
    }

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        eliminarSuministro();
    }

    private void agregarSuministro() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String marca = txtMarca.getText();
        String proveedor = txtProveedor.getText();
        String existencias = txtExistencias.getText();
        String precio = txtPrecio.getText();

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Suministros (Id, Nombre, Marca, Proveedor, Existencias, Precio_Unitario) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, marca);
            ps.setString(4, proveedor);
            ps.setString(5, existencias);
            ps.setString(6, precio);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Suministro agregado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el suministro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el suministro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultarSuministro() {
        String id = txtId.getText();

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Suministros WHERE Id = ?")) {
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Mostrar los resultados en los campos correspondientes
                txtNombre.setText(rs.getString("Nombre"));
                txtMarca.setText(rs.getString("Marca"));
                txtProveedor.setText(rs.getString("Proveedor"));
                txtExistencias.setText(rs.getString("Existencias"));
                txtPrecio.setText(rs.getString("Precio_unitario"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún suministro con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el suministro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void modificarSuministro() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String marca = txtMarca.getText();
        String proveedor = txtProveedor.getText();
        String existencias = txtExistencias.getText();
        String precio = txtPrecio.getText();
    
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("UPDATE Suministros SET Nombre = ?, Marca = ?, Proveedor = ?, Existencias = ?, Precio_Unitario = ? WHERE Id = ?")) {
            ps.setString(1, nombre);
            ps.setString(2, marca);
            ps.setString(3, proveedor);
            ps.setString(4, existencias);
            ps.setString(5, precio);
            ps.setString(6, id);
    
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Suministro modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún suministro con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el suministro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarSuministro() {
        String id = txtId.getText();
    
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Suministros WHERE Id = ?")) {
            ps.setString(1, id);
    
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Suministro eliminado correctamente.");
                // Limpiar los campos después de eliminar
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún suministro con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el suministro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpiarCampos'");
    }

    private void initComponents() {
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtExistencias = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel7.setText("Suministros");

        jLabel1.setText("Id:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Proveedor:");

        jLabel5.setText("Existencias:");

        jLabel6.setText("Precio:");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suministro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Suministro().setVisible(true);
        });
    }
}
