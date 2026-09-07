package modelo;

import java.util.List;
import java.util.ArrayList;
import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Taller;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantEventos;

    private Sala sala;

    private List<Actividad> actividades;

    //Constructor estático
    static {
        cantEventos = 0;
    }

    //Constructor
    public EventoUniversitario (String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        setTitulo(titulo);
        setCostoBase(costoBase);
        setGratuito(gratuito);
        actividades = new ArrayList<>();
        cantEventos++;

    }

    public void setTitulo (String titulo) {
        if (titulo != null && !titulo.isEmpty())
            this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCostoBase(double costoBase) {
        if (costoBase >= 0)
            this.costoBase = costoBase;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public static int getCantEventos() {
        return cantEventos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public EventoUniversitario (EventoUniversitario obj) {
            this.id = obj.id + "-COPIA";
            this.titulo = obj.titulo;
            this.costoBase = obj.costoBase;
            this.gratuito = obj.gratuito;
            this.actividades = new ArrayList<>(obj.actividades);
            this.sala = obj.sala;
            cantEventos++;
    }

    public double calcularCostoEstimado() {

        if(this.gratuito) {
            return 0;
        }

        double costoTotal = costoBase;

        for(Actividad actividad : actividades) {
            costoTotal += actividad.calcularCostoMateriales();
        }
        return (costoTotal * 1.21);
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupoMaximo, int CUPO_MINIMO, String tipo, String disertante, boolean requiereNotebook) {
        Actividad actividad;
        switch (tipo.trim().toLowerCase()) {
            case "charla":
                actividad = new Charla(id, titulo, cupoMaximo, CUPO_MINIMO, disertante);
                break;
            case  "taller":
                actividad = new Taller(id, titulo, cupoMaximo, CUPO_MINIMO, requiereNotebook);
                break;
            default:
                actividad = null;
                break;
        }
        this.actividades.add(actividad);
    }

    public void mostrarDatos() {
        System.out.println("Datos del Evento: " + getTitulo());
        System.out.println(" - ID: " + id);
        if (gratuito) {
            System.out.println(" - El evento es gratuito");
        } else {
            System.out.println(" - El evento no es gratuito");
            System.out.println(" - Costo: $" + this.calcularCostoEstimado());
        }
        System.out.println("modelo.Sala: " + sala.getNombre() + ", id: " + sala.getId());
        for (Actividad actividad : actividades) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println( actividad.getId() +  ". "+ actividad.getTipo() + " de "+ actividad.getTitulo());

            switch (actividad.getTipo()) {
                case "modelo.actividades.Charla":
                    Charla charla = (Charla) actividad;
                    System.out.println("Cupo máximo: " + actividad.getCupoMaximo() + ", cupo mínimo: " + actividad.CUPO_MINIMO + ", disertante: " + charla.getDisertante());
                    break;
                case "modelo.actividades.Taller":
                    Taller taller = (Taller) actividad;
                    if (taller.isRequiereNotebook()){
                        System.out.println("Cupo máximo: " + actividad.getCupoMaximo() + ", cupo mínimo: " + actividad.CUPO_MINIMO + ", requiere Notebook");

                    } else {
                        System.out.println("Cupo máximo: " + actividad.getCupoMaximo() + ", cupo mínimo: " + actividad.CUPO_MINIMO + ", no requiere Notebook");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Estudiantes inscriptos: ");
            actividad.mostrarInscripciones(actividad.getInscripciones());
            System.out.println("");
        }
    }
}
