package modelo.actividades;

import modelo.Estudiante;
import modelo.certificacion.Certificable;

import java.time.LocalDate;

public class Curso extends Actividad implements Certificable {
    private int nivel;

    public Curso (int id, String titulo, int cupoMaximo, int CUPO_MINIMO, int nivel) {
        super(id, titulo, cupoMaximo, CUPO_MINIMO);
        setNivel(nivel);
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        return 2000;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Se certifica que " + estudiante.getNombre() + " participó en un curso el día " + LocalDate.now() + ".";
    }

}
