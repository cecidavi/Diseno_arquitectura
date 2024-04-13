import java.time.LocalDate;
import java.util.List;

public class ServicioCorrectivo {
    private String id;
    private String modeloCoche;
    private String descripcion;
    private String estadoCoche;
    private String estadoServicio;
    private LocalDate fecha;
    private String hora;
    private double costoEstimado;
    private Cliente cliente;

    // Getters y setters

    public void agregarRefacciones(List<Refaccion> refacciones) {
        // Lógica para agregar refacciones al servicio correctivo
    }

    public void actualizarEstadoServicio(String nuevoEstado) {
        // Lógica para actualizar el estado del servicio correctivo
    }
}