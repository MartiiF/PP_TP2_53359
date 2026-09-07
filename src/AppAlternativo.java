import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;
import java.util.List;

public class AppAlternativo {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("50151", "Juan Pérez"));
        estudiantes.add(new Estudiante("52945", "Julia Álvarez"));
        estudiantes.add(new Estudiante("51237", "Pedro Fernandez"));

        EventoUniversitario evento = new EventoUniversitario("Ev-01", "Jornada Universitaria", 1500, false);

        Sala sala = new Sala(1, "SUM");
        evento.asignarSala(sala);

        evento.crearActividad(1, "Introducción a Java", 1, 20, "modelo.actividades.Charla", "Manuel Vásquez",  false);
        evento.crearActividad(2, "POO", 40, 15, "modelo.actividades.Taller", "",  true);

        try {
            evento.getActividades().get(0).inscribir(estudiantes.get(0));
            evento.getActividades().get(0).inscribir(estudiantes.get(1));

            evento.getActividades().get(1).inscribir(estudiantes.get(0));
            evento.getActividades().get(1).inscribir(estudiantes.get(2));
        } catch (CupoExcedidoException e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }


        EventoUniversitario eventoCopia = new EventoUniversitario(evento);

        evento.mostrarDatos();
        eventoCopia.mostrarDatos();

        System.out.println("Se crearon " + EventoUniversitario.getCantEventos() + " eventos.");


    }

}
