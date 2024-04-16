package Modelos;

public class RefaccionM {
    private int id;
    private String nombre;
    private String marca;
    private String proveedor;
    private int existencias;
    private double precio;

    // Constructor
    public RefaccionM(int id, String nombre, String marca, String proveedor, int existencias, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.proveedor = proveedor;
        this.existencias = existencias;
        this.precio = precio;
    }

    // Métodos para obtener y establecer el ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos para obtener y establecer el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener y establecer la marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Métodos para obtener y establecer el proveedor
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    // Métodos para obtener y establecer las existencias
    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    // Métodos para obtener y establecer el precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
