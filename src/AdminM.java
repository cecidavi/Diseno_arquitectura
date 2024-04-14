public class AdminM {
    private String username;
    private String password;

    // Constructor
    public AdminM(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Métodos para obtener y establecer el nombre de usuario
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Métodos para obtener y establecer la contraseña
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
