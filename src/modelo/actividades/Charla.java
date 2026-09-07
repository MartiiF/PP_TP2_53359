package modelo.actividades;

public class Charla extends Actividad {
    private String disertante;

    public Charla(int id, String titulo, int cupoMaximo, int CUPO_MINIMO, String disertante) {
        super(id, titulo, cupoMaximo, CUPO_MINIMO);
        this.disertante = disertante;
    }

    public String getDisertante() {
        return disertante;
    }

    public void setDisertante(String disertante) {
        this.disertante = disertante;
    }

    @Override
    public String getTipo() {
        /* Método polimórfico: get class retorna al propia clase, getSimpleName retorna el nombre de la clase actual.*/
          return this.getClass().getSimpleName();
    }

    @Override
    public double calcularCostoMateriales() {
        return 0;
    }
}
