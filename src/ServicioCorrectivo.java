import java.util.Date;

public class ServicioCorrectivo {
    private int id;
    private String modelo;
    private String descripcion;
    private String estado;
    private String estatusServicio;
    private Date fecha;
    private String hora;
    private double costo;
    private int folioCliente;

    // Constructor
    public ServicioCorrectivo(int id, String modelo, String descripcion, String estado, String estatusServicio, Date fecha, String hora, double costo, int folioCliente) {
        this.id = id;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.estatusServicio = estatusServicio;
        this.fecha = fecha;
        this.hora = hora;
        this.costo = costo;
        this.folioCliente = folioCliente;
    }

    // Métodos para obtener y establecer el ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos para obtener y establecer el modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Métodos para obtener y establecer la descripción
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos para obtener y establecer el estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos para obtener y establecer el estatus del servicio
    public String getEstatusServicio() {
        return estatusServicio;
    }

    public void setEstatusServicio(String estatusServicio) {
        this.estatusServicio = estatusServicio;
    }

    // Métodos para obtener y establecer la fecha
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Métodos para obtener y establecer la hora
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    // Métodos para obtener y establecer el costo
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    // Métodos para obtener y establecer el folio del cliente
    public int getFolioCliente() {
        return folioCliente;
    }

    public void setFolioCliente(int folioCliente) {
        this.folioCliente = folioCliente;
    }
}
