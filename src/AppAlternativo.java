import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.Sala;
import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Curso;
import modelo.actividades.Taller;
import modelo.certificacion.Certificable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppAlternativo {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();

        //e.printStackTrace(); muestra mensaje de error general con la linea de codigo de ubicacion del mismo

        estudiantes.add(new Estudiante("50151", "Juan Pérez"));
        estudiantes.add(new Estudiante("52945", "Julia Álvarez"));
        estudiantes.add(new Estudiante("51237", "Pedro Fernandez"));
        estudiantes.add(new Estudiante("50956", "Clara Rodríguez"));
        estudiantes.add(new Estudiante("51842", "Martín González"));
        estudiantes.add(new Estudiante("50376", "Sofía Martínez"));
        estudiantes.add(new Estudiante("52419", "Lucas Romero"));
        estudiantes.add(new Estudiante("50783", "Valentina López"));
        estudiantes.add(new Estudiante("53104", "Nicolás Torres"));
        estudiantes.add(new Estudiante("51658", "Camila Sánchez"));
        estudiantes.add(new Estudiante("50293", "Tomás Herrera"));
        estudiantes.add(new Estudiante("52741", "Agustina Castro"));
        estudiantes.add(new Estudiante("51426", "Franco Medina"));
        estudiantes.add(new Estudiante("53017", "Martina Silva"));
        estudiantes.add(new Estudiante("50864", "Santiago Acosta"));

        EventoUniversitario evento = new EventoUniversitario("Ev-01", "Jornada Universitaria", 1500, false);

        Sala sala = new Sala(1, "SUM");
        evento.asignarSala(sala);

        evento.crearActividad(1, "Introducción a Java", 1, 20, "Charla", "Manuel Vásquez",  false, 0);
        evento.crearActividad(2, "POO", 40, 15, "Taller", "",  true, 0 );
        evento.crearActividad(3, "Ciberseguridad", 30, 10, "Curso", "", false,1);
        evento.crearActividad(4, "IA", 50, 30, "Curso", "", false,2);
        evento.crearActividad(5, "Impresión 3D", 30, 20, "Taller", "", false,0);
        evento.crearActividad(6, "Energía y Tecnología", 100, 20, "Charla", "Verónica Sánchez", false,0);
        evento.crearActividad(7, "Visualización de Datos", 30, 20, "Taller", "", true,0);

        //un try-catch por actividad para evitar que el error de una impida la inscripción en las demás
        // Charla: Introducción a Java
        try {
            evento.getActividades().get(0).inscribir(estudiantes.get(0));
            evento.getActividades().get(0).inscribir(estudiantes.get(1));
            evento.getActividades().get(0).inscribir(estudiantes.get(2));
            evento.getActividades().get(0).inscribir(estudiantes.get(3));
            evento.getActividades().get(0).inscribir(estudiantes.get(4));
        } catch (CupoExcedidoException e) {
            System.out.println("Error en " + evento.getActividades().get(0).getTitulo() + ": " + e.getMessage());
        }

        // Taller: POO
        try {
            evento.getActividades().get(1).inscribir(estudiantes.get(0));
            evento.getActividades().get(1).inscribir(estudiantes.get(2));
            evento.getActividades().get(1).inscribir(estudiantes.get(5));
            evento.getActividades().get(1).inscribir(estudiantes.get(6));
            evento.getActividades().get(1).inscribir(estudiantes.get(7));
            evento.getActividades().get(1).inscribir(estudiantes.get(8));
        } catch (CupoExcedidoException e) {
            System.out.println("Error en " + evento.getActividades().get(1).getTitulo() + ": " + e.getMessage());
        }

        // Curso: Ciberseguridad
        try {
            evento.getActividades().get(2).inscribir(estudiantes.get(1));
            evento.getActividades().get(2).inscribir(estudiantes.get(3));
            evento.getActividades().get(2).inscribir(estudiantes.get(4));
            evento.getActividades().get(2).inscribir(estudiantes.get(9));
            evento.getActividades().get(2).inscribir(estudiantes.get(10));
        } catch (CupoExcedidoException e) {
            System.out.println("Error en " + evento.getActividades().get(2).getTitulo() + ": " + e.getMessage());
        }

        // Curso: IA
        try {
            evento.getActividades().get(3).inscribir(estudiantes.get(5));
            evento.getActividades().get(3).inscribir(estudiantes.get(6));
            evento.getActividades().get(3).inscribir(estudiantes.get(7));
            evento.getActividades().get(3).inscribir(estudiantes.get(8));
            evento.getActividades().get(3).inscribir(estudiantes.get(11));
            evento.getActividades().get(3).inscribir(estudiantes.get(12));
        } catch (CupoExcedidoException e) {
            System.out.println("Error en " + evento.getActividades().get(3).getTitulo() + ": " + e.getMessage());
        }

        // Taller: Impresión 3D
        try {
            evento.getActividades().get(4).inscribir(estudiantes.get(2));
            evento.getActividades().get(4).inscribir(estudiantes.get(4));
            evento.getActividades().get(4).inscribir(estudiantes.get(9));
            evento.getActividades().get(4).inscribir(estudiantes.get(13));
            evento.getActividades().get(4).inscribir(estudiantes.get(14));
        } catch (CupoExcedidoException e) {
            System.out.println("Error en " + evento.getActividades().get(4).getTitulo() + ": " + e.getMessage());
        }

        // Charla: Energía y Tecnología
        try {
            evento.getActividades().get(5).inscribir(estudiantes.get(0));
            evento.getActividades().get(5).inscribir(estudiantes.get(5));
            evento.getActividades().get(5).inscribir(estudiantes.get(9));
            evento.getActividades().get(5).inscribir(estudiantes.get(11));
            evento.getActividades().get(5).inscribir(estudiantes.get(14));
        } catch (CupoExcedidoException e) {
            System.out.println("Error en " + evento.getActividades().get(5).getTitulo() + ": " + e.getMessage());
        }

        // Taller: Visualización de Datos
        try {
            evento.getActividades().get(6).inscribir(estudiantes.get(1));
            evento.getActividades().get(6).inscribir(estudiantes.get(3));
            evento.getActividades().get(6).inscribir(estudiantes.get(7));
            evento.getActividades().get(6).inscribir(estudiantes.get(10));
            evento.getActividades().get(6).inscribir(estudiantes.get(13));
        } catch (CupoExcedidoException e) {
            System.out.println("Error en " + evento.getActividades().get(6).getTitulo() + ": " + e.getMessage());
        } finally {
            System.out.println("Inscripciones finalizadas");
            System.out.println();
        }

//        EventoUniversitario eventoCopia = new EventoUniversitario(evento);

        evento.mostrarDatos();
//        eventoCopia.mostrarDatos();

        System.out.println("Se ha/n creado " + EventoUniversitario.getCantEventos() + " evento/s.");

        //serialización
        try {
            System.out.println("Guardando evento " + evento.getId() + ": " + evento.getTitulo() + "...");
            evento.persistirEvento();
            System.out.println("Evento guradado con éxito");
        } catch (FileNotFoundException e){
            System.out.println("No es posible guardar el evento: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S, no es posible guardar el evento: " + e.getMessage());
        } finally {
            System.out.println("Persistencia finalizada.");
            System.out.println();
        }

        //deserialización
        try {
            System.out.println("Recuperando evento...");
            EventoUniversitario eventoRecup = evento.recuperarEvento(evento.getId());
            System.out.println("Evento " + eventoRecup.getId() + " recuperado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("No fue posible reconstruir el objeto almacenado: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S, no es posible recuperar el evento: " + e.getMessage());
        } finally {
            System.out.println();
        }

        for (Actividad actividad : evento.getActividades()){
            if (actividad instanceof Certificable certificable){
                System.out.println("Certificados del "+ actividad.getTipo() + " de " + actividad.getTitulo());
                for (Inscripcion inscripcion : actividad.getInscripciones()) {
                    System.out.println(certificable.generarCertificado(inscripcion.getEstudiante()));
                }
            }
        }

        //filtrado de actividadaes
        List<Charla> charlas = evento.filtrarActividadesPorTipo(Charla.class);
        List<Taller> talleres = evento.filtrarActividadesPorTipo(Taller.class);
        List<Curso> cursos = evento.filtrarActividadesPorTipo(Curso.class);

        //cantidad de actividades por tipo filtrado
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Actividades creadas:");
        System.out.println("Se crearon " + charlas.size() + " charlas.");
        System.out.println("El costo total de materiales de las charlas es: $" + evento.calcularCostoMateriales(charlas));
        System.out.println("Se crearon " + talleres.size() + " talleres.");
        System.out.println("El costo total de materiales de los talleres es: $" + evento.calcularCostoMateriales(talleres));
        System.out.println("Se crearon " + cursos.size() + " cursos.");
        System.out.println("El costo total de materiales de los cursos es: $" + evento.calcularCostoMateriales(cursos));

    }

}
