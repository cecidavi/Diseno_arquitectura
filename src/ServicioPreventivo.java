import java.time.LocalDate;
import java.util.List;

public class ServicioPreventivo {
    private String id;
    private String modeloCoche;
    private String descripcion;
    private String estadoServicio;
    private double costoEstimado;
    private LocalDate fecha;
    private String hora;
    private Cliente cliente;

    // Getters y setters

    public void agregarSuministros(List<Suministro> suministros) {
        // Lógica para agregar suministros al servicio preventivo
    }

    public void actualizarEstadoServicio(String nuevoEstado) {
        // Lógica para actualizar el estado del servicio preventivo
    }
}