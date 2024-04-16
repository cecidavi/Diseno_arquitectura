package Controladores;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdminC {
    private static final Conexion conexion = new Conexion();

    public static void leerDatos() {
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Admin");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("ID"));
                System.out.println("Nombre de usuario: " + rs.getString("Nombre_Usuario"));
                System.out.println("Contraseña: " + rs.getString("Contraseña"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
        }
    }

    public static boolean iniciarSesion(String nombreUsuario, String contraseña) {
        boolean sesionIniciada = false;
        String sql = "SELECT * FROM Admin WHERE Nombre_Usuario = ? AND Contraseña = ?";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contraseña);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Las credenciales son correctas
                    sesionIniciada = true;
                } else {
                    // Las credenciales son incorrectas
                }
            }
        } catch (SQLException e) {
        }
        
        return sesionIniciada;
    }
}




