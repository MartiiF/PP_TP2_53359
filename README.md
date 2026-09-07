# PP_TP1_53359
# Trabajo Práctico N.º 1 — Paradigmas de Programación

**UTN - Facultad Regional Mendoza**
**Ingeniería en Sistemas**

## Descripción

Proyecto realizado en Java utilizando IntelliJ IDEA para el Trabajo Práctico N.º 1 de Paradigmas de Programación.

El proyecto incluye la resolución de los Ejercicios 1, 2, 3 y 4, trabajando con:

* Clases y objetos.
* Encapsulamiento.
* Asociación, agregación y composición.
* Herencia y polimorfismo.
* Clase abstracta y métodos `final`.
* Colecciones `List`.

## Clases principales

* `modelo.Estudiante`: representa a los estudiantes.
* `modelo.EventoUniversitario`: representa los eventos y sus actividades.
* `modelo.Sala`: representa las salas asignadas a los eventos.
* `modelo.actividades.Actividad`: clase abstracta para las actividades.
* `modelo.actividades.Charla`: actividad de tipo charla.
* `modelo.actividades.Taller`: actividad de tipo taller.
* `modelo.Inscripcion`: representa la inscripción de un estudiante a una actividad.

## Ejecución

El proyecto cuenta con dos clases ejecutables:

**App.java**
Permite ingresar los datos mediante la consola y crear estudiantes, eventos, salas, actividades e inscripciones.

**AppAlternativo.java**
Crea los datos directamente en el código para reproducir el escenario solicitado en el Ejercicio 4 y realizar el mapa de memoria.

## Imágenes

La carpeta `imagenes/` contiene:

* El mapa de memoria del Ejercicio 4.
* Las capturas de la salida por consola.

## Cómo clonar el repositorio

Para clonar el proyecto se debe tener Git instalado y ejecutar en una terminal:

```bash
git clone https://github.com/MartiiF/PP_TP1_53359.git
```

Luego ingresar a la carpeta:

```bash
cd PP_TP1_53359
```

Finalmente, abrir el proyecto con IntelliJ IDEA y ejecutar `App.java` o `AppAlternativo.java`.

## Repositorio

https://github.com/MartiiF/PP_TP1_53359
