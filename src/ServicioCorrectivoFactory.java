import java.time.LocalDate;

public class ServicioCorrectivoFactory {
    public static ServicioCorrectivo crearServicio(String id, String modeloCoche, String descripcion, String estadoCoche, String estadoServicio, LocalDate fecha, String hora, double costoEstimado, Cliente cliente) {
        // Lógica de creación del servicio correctivo
        ServicioCorrectivo servicio = new ServicioCorrectivo();
        return servicio;
    }
}