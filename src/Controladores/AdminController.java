package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Vistas.Admins;
import Modelos.AdminM;
import conexion.Conexion;
public class AdminController {
    private AdminM adminModel;
    private Admins adminView;
    private Conexion conexion;

    public AdminController(AdminM adminModel, Admins adminView) {
        this.adminModel = adminModel;
        this.adminView = adminView;
        this.conexion = new Conexion();
    }

    public void authenticateAdmin() {
        String username = adminView.getTxtUsuario().getText();
        String password = new String(adminView.getTxtContraseña().getPassword());

        if (isAdminValid(username, password)) {
            // La autenticación es correcta
            // Aquí puedes agregar la lógica adicional que necesites
            System.out.println("Inicio de sesión exitoso");
        } else {
            // La autenticación falló
            JOptionPane.showMessageDialog(adminView, "Usuario o contraseña incorrectos");
        }
    }

    private boolean isAdminValid(String username, String password) {
        try (Connection conn = conexion.getConexion()) {
            String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }
    }

    public void updateAdminCredentials() {
        String newUsername = JOptionPane.showInputDialog(adminView, "Ingrese el nuevo nombre de usuario:");
        String newPassword = JOptionPane.showInputDialog(adminView, "Ingrese la nueva contraseña:");

        adminModel.setUsername(newUsername);
        adminModel.setPassword(newPassword);

        JOptionPane.showMessageDialog(adminView, "Credenciales actualizadas exitosamente");
    }

    public void setupListeners() {
        adminView.getBtnAceptar().addActionListener(e -> authenticateAdmin());
        adminView.getBtnCancelar().addActionListener(e -> adminView.dispose());
    }
}
