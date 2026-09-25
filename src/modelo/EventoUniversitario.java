package modelo;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Curso;
import modelo.actividades.Taller;

public class EventoUniversitario implements Serializable {

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

    public String getId() {
        return id;
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

    public void crearActividad(int id, String titulo, int cupoMaximo, int CUPO_MINIMO, String tipo, String disertante, boolean requiereNotebook, int nivel) {
        Actividad actividad;
        switch (tipo.trim().toLowerCase()) {
            case "charla":
                actividad = new Charla(id, titulo, cupoMaximo, CUPO_MINIMO, disertante);
                break;
            case  "taller":
                actividad = new Taller(id, titulo, cupoMaximo, CUPO_MINIMO, requiereNotebook);
                break;
            case "curso":
                actividad = new Curso(id, titulo, cupoMaximo, CUPO_MINIMO, nivel);
                break;
            default:
                actividad = null;
                break;
        }
        this.actividades.add(actividad);
    }

    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo) {
        List<T> resultado = new ArrayList<>();
        for (Actividad actividad : actividades) {
            if (tipo.isInstance(actividad)) {
                resultado.add(tipo.cast(actividad));
            }
        }
        return resultado;
    }

    public double calcularCostoMateriales(List<? extends Actividad> actividades) {
        double costoRes = 0.0;
        for (Actividad actividad : actividades){
            costoRes += actividad.calcularCostoMateriales();
        }
        return costoRes;
    }

    public boolean persistirEvento() throws IOException {
        String nombreArchivo = "evento_" + this.id + ".dat";
        //Manera optimizada: patrón try_with_resources que garaantiza que se cierren los recrusos
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))){
            oos.writeObject(this);
            return true;
        }
    }

    public EventoUniversitario recuperarEvento(String id) throws IOException, ClassNotFoundException {
        String nombreArchivo = "evento_" + id + ".dat";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (EventoUniversitario) ois.readObject();
        }
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
        System.out.println("Sala: " + sala.getNombre() + ", id: " + sala.getId());
        for (Actividad actividad : actividades) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println( actividad.getId() +  ". "+ actividad.getTipo() + " de "+ actividad.getTitulo());
            System.out.println("Cupo máximo: " + actividad.getCupoMaximo() + ", cupo mínimo: " + actividad.CUPO_MINIMO);
            System.out.println("Costo total: $" + actividad.calcularCostoMateriales());
            switch (actividad.getTipo()) {
                case "Charla":
                    Charla charla = (Charla) actividad;
                    System.out.println( "Disertante: " + charla.getDisertante());
                    break;
                case "Taller":
                    Taller taller = (Taller) actividad;
                    if (taller.isRequiereNotebook()){
                        System.out.println("Requiere Notebook");

                    } else {
                        System.out.println("No requiere Notebook");
                    }
                    break;
                case "Curso":
                    Curso curso = (Curso) actividad;
                    System.out.println("Nivel: " + curso.getNivel());
                default:
                    break;
            }
            System.out.println("Estudiantes inscriptos: ");
            actividad.mostrarInscripciones(actividad.getInscripciones());
            System.out.println();
        }

    }

    public static int getCantEventos() {
        return cantEventos;
    }

}
