package modelo;

public class Sala {
    private int id;
    private String nombre;

    public Sala (int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setId (int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("El ID ingresado no es válido");
        }
    }

    public int getId () {
        return id;
    }

    public void setNombre (String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("No puede ingresar como nombre una cadena vacía");
        }
    }

    public String getNombre() {
        return nombre;
    }
}