import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;
import modelo.actividades.Actividad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;//importo el escáner

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //creo el escáner
        List<Estudiante> estudiantes = new ArrayList<>();

        //Lista de estudiantes
        String continuar;
        String nombre;
        String legajo;
        System.out.println("Registro de Estudiantes");
        do {
            do {
                System.out.println("Ingrese nombre completo: ");
                nombre = scanner.nextLine();
            } while (nombre == null || nombre.isEmpty());

            do {
                System.out.println("Ingrese legajo: ");
                legajo = scanner.nextLine();
            } while (legajo == null || legajo.isEmpty());

            do {
                System.out.println("¿Desea registrar otro estudiante?(s/n)");
                continuar = scanner.nextLine();
                continuar = continuar.trim().toLowerCase(); // elimina espacios y pasa a minúscula
            } while (!continuar.equals("s") && !continuar.equals("n"));

            Estudiante estudiante = new Estudiante(legajo, nombre); //creo estudiante
            estudiantes.add(estudiante); //añado a la lista

        } while (continuar.equals("s"));

        //declaro datos de evento
//        String id;
        String titulo;
        double costoBase;
        boolean gratuito;
        //declaro datos de sala
        int idSala;
        String nombreSala;
        //declaro datos de actividad
        int idActividad;
        String tituloActividad;
        int cupoMaximo;
        int CUPO_MINIMO;
        String tipoActividad = "";
        int tipo;
        String disertante = "";
        boolean requiereNotebook = false;
        int nivel = -1;

        //creamos eventos
        do {
            System.out.println("DATOS DEL EVENTO");

            do {
                System.out.println("Ingrese el titulo del evento: ");
                titulo = scanner.nextLine();
            } while (titulo == null || titulo.isEmpty());

            do {
                System.out.println("Ingrese el costo base del evento: ");
                costoBase = scanner.nextInt();
                scanner.nextLine();
            } while (costoBase < 0);

            //vemos si es gratuito o no
            gratuito = !(costoBase > 0);

            EventoUniversitario evento = new EventoUniversitario("Ev-" + (EventoUniversitario.getCantEventos() + 1) , titulo, costoBase, gratuito);

            System.out.println("DATOS DE LA SALA");
            do {
                System.out.println("Ingrese el ID de la sala: ");
                idSala = scanner.nextInt();
                scanner.nextLine();
            } while (idSala < 0);

            do {
                System.out.println("Ingrese el nombre de la sala: ");
                nombreSala = scanner.nextLine();
            } while (nombreSala == null || nombreSala.isEmpty());

            Sala sala = new Sala(idSala, nombreSala);
            evento.asignarSala(sala);

            System.out.println("DATOS DE LAS ACTIVIDADES");
            //crear actividades

            do {
                do {
                    System.out.println("Ingrese el tipo de actividad (1 o 2)");
                    System.out.println("1. Charla");
                    System.out.println("2. Taller");
                    System.out.println("3. Curso");
                    tipo = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1 ) {
                        tipoActividad = "Charla";
                    } else if (tipo == 2) {
                        tipoActividad = "Taller";
                    } else if (tipo == 3) {
                        tipoActividad = "Curso";
                    } else {
                        System.out.println("Entrada no válida");
                        System.out.println("Ingrese un número de actividad válido");
                        tipo = 0;
                    }

                } while (tipo != 1 && tipo != 2);

                switch (tipoActividad.trim().toLowerCase()) {
                    case "charla":
                        do {
                            System.out.println("Ingrese el nombre del disertante: ");
                            disertante = scanner.nextLine();
                        } while (disertante == null || disertante.isEmpty());
                        break;
                    case "taller":
                        String respuesta;
                        do {
                            System.out.println("¿La actividad requiere notebook?(s/n)");
                            respuesta = scanner.nextLine().trim().toLowerCase();
                        } while (!respuesta.equals("s") && !respuesta.equals("n"));

                        requiereNotebook = respuesta.equals("s");
                        break;
                    case "curso":
                        do {
                            System.out.println("Ingrese el nivel del curso");
                            nivel = scanner.nextInt();
                            scanner.nextLine();
                        } while (nivel < 0 );
                        break;
                    default:
                        System.out.println("Tipo de actividad no válida");
                        break;
                }

                do {
                    System.out.println("Ingrese el ID de la actividad: ");
                    idActividad = scanner.nextInt();
                    scanner.nextLine();
                } while (idActividad < 0);


                do {
                    System.out.println("Ingrese el titulo de la actividad: ");
                    tituloActividad = scanner.nextLine();
                } while (tituloActividad == null || tituloActividad.isEmpty());

                do {
                    System.out.println("Ingrese la cantidad máxima de cupos ");
                    cupoMaximo = scanner.nextInt();
                    scanner.nextLine();
                } while (cupoMaximo < 0);


                do {
                    System.out.println("Ingrese la cantidad mínima de cupos: ");
                    CUPO_MINIMO = scanner.nextInt();
                    scanner.nextLine();
                } while (CUPO_MINIMO < 0);

                evento.crearActividad(idActividad, tituloActividad, cupoMaximo, CUPO_MINIMO, tipoActividad, disertante, requiereNotebook, nivel);
                Actividad actividad =  evento.getActividades().get(evento.getActividades().size() - 1);

                System.out.println("INSCRIPCIÓN DE ESTUDIANTES A LA ACTIVIDAD " + tituloActividad);
                do {
                    System.out.println("Ingrese el legajo del estudiante que desea inscribir:");
                    String legajoBuscado = scanner.nextLine();
                    boolean encontrado = false;

                    for (Estudiante estudiante : estudiantes) {
                        if (estudiante.getLegajo().equals(legajoBuscado)) {
                            if (actividad.getInscripciones().size() < cupoMaximo ) {
                                try {
                                    actividad.inscribir(estudiante);
                                    System.out.println("Estudiante inscripto correctamente");
                                } catch (CupoExcedidoException e) {
                                     System.out.println("Error al inscribir: " + e.getMessage());
                                }

                            } else {
                                System.out.println("No hay más cupos disponibles");
                            }
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un estudiante con ese legajo.");
                    }

                    if (actividad.getInscripciones().size() < cupoMaximo) {
                        do {
                            System.out.println("¿Desea inscribir otro estudiante? (s/n)");
                            continuar = scanner.nextLine().trim().toLowerCase();
                        } while (!continuar.equals("s") && !continuar.equals("n"));
                    } else {
                        System.out.println("Se alcanzó el cupo máximo");
                        continuar = "n";
                    }
                } while (continuar.equals("s"));

                System.out.println("¿Desea registrar otra actividad?(s/n)");
                continuar = scanner.nextLine();
                continuar = continuar.trim().toLowerCase();
            } while (continuar.equals("s"));

            do {
                System.out.println("¿Desea registrar otro evento?(s/n)");
                continuar = scanner.nextLine();
                continuar = continuar.trim().toLowerCase();
            } while (!continuar.equals("s") && !continuar.equals("n"));

        } while (continuar.equals("s"));

        System.out.println("Se crearon " + EventoUniversitario.getCantEventos() + " eventos");

    }
}