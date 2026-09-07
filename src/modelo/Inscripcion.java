package modelo;

import java.time.LocalDate;
import modelo.actividades.Actividad;
public class Inscripcion {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante, Actividad actividad) {
        setFecha(fecha);
        setEstado(estado);
        this.estudiante = estudiante;
        this.actividad = actividad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}
