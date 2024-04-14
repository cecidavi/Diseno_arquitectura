public class ClienteM {
    private int folio;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String direccion;
    private String telefono;
    private boolean esCliente;

    // Constructor
    public ClienteM(int folio, String nombre, String apellidoMaterno, String apellidoPaterno, String direccion, String telefono, boolean esCliente) {
        this.folio = folio;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.esCliente = esCliente;
    }

    // Métodos para obtener y establecer el folio
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    // Métodos para obtener y establecer el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener y establecer el apellido materno
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    // Métodos para obtener y establecer el apellido paterno
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    // Métodos para obtener y establecer la dirección
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Métodos para obtener y establecer el teléfono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Métodos para obtener y establecer si es cliente
    public boolean getEsCliente() {
        return esCliente;
    }

    public void setEsCliente(boolean esCliente) {
        this.esCliente = esCliente;
    }
}
