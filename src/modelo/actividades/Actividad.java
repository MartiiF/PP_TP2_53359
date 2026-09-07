package modelo.actividades;

import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public final int CUPO_MINIMO;
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad(int id, String titulo, int cupoMaximo, int CUPO_MINIMO) {
        setId(id);
        setTitulo(titulo);
        setCupoMaximo(cupoMaximo);
        this.CUPO_MINIMO = CUPO_MINIMO;
       // inscripciones.add()
    }


    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if (inscripciones.size() >= cupoMaximo) {
            throw new CupoExcedidoException("No se puede realizar la inscripción del estudiante " + estudiante.getNombre());
        }
        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), "inscripto", estudiante, this);
        inscripciones.add(inscripcion);
        return inscripcion;

    }

    public void mostrarInscripciones(List<Inscripcion> inscripciones) {
        for(Inscripcion inscripcion : inscripciones) {
            System.out.println("-  " + inscripcion.getEstudiante().getNombre() + ", legajo: " + inscripcion.getEstudiante().getLegajo() + ", " + inscripcion.getEstado() + ", " + inscripcion.getFecha());
        }
    }

    public final void mostrarIdentificación() {
        System.out.println("ID: " + getId());
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();
}
