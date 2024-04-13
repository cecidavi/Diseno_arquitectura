public class Admin {
    private String id;
    private String usuario;
    private String contrasena;

    // Getters y setters

    public boolean autenticarUsuario(String usuario, String contrasena) {
        // Lógica para autenticar al usuario administrador
        return usuario.equals(this.usuario) && contrasena.equals(this.contrasena);
    }
}