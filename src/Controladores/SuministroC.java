package Controladores;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuministroC {
    private static final Conexion conexion = new Conexion();

    public boolean agregarSuministro(String id, String nombre, String marca, String proveedor, String existencias, String precio) {
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Suministro (Id, Nombre, Marca, Proveedor, Existencias, Precio) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, marca);
            ps.setString(4, proveedor);
            ps.setString(5, existencias);
            ps.setString(6, precio);

            // Ejecutar la consulta y verificar si se insertó correctamente
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
