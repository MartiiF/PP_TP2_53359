package modelo.actividades;

public class Taller extends Actividad {
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
        return "modelo.actividades.Taller";
    }

    @Override
    public double calcularCostoMateriales() {
        if (requiereNotebook) {
            return 5000;
        } else {
            return 2000;
        }
    }

}
