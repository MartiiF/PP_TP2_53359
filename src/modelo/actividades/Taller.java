package modelo.actividades;

import modelo.Estudiante;
import modelo.certificacion.Certificable;

import java.time.LocalDate;

public class Taller extends Actividad implements Certificable {
    private boolean requiereNotebook;

    public Taller (int id, String titulo, int cupoMaximo, int CUPO_MINIMO, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo, CUPO_MINIMO);
        this.requiereNotebook = requiereNotebook;
    }

    public void setRequiereNoteboook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public double calcularCostoMateriales() {
        if (requiereNotebook) {
            return 5000;
        } else {
            return 2000;
        }
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Se certifica que " + estudiante.getNombre() + " participó en un taller el día " + LocalDate.now() + ".";
    }
}
