# PP_TP1_53359
# Trabajo Práctico 2 - Paradigmas de Programación

**UTN - Facultad Regional Mendoza**
**Ingeniería en Sistemas**

## Datos del proyecto

## Descripción

Este proyecto corresponde al Trabajo Práctico N.º 2 de la asignatura
Paradigmas de Programación.

El sistema representa un modelo de eventos universitarios implementado en Java,
incorporando conceptos de Programación Orientada a Objetos correspondientes a
la Unidad 2:

- manejo de paquetes (packages);
- excepciones chequeadas;
- creación y utilización de excepciones personalizadas;
- serialización y deserialización de objetos;
- interfaces;
- polimorfismo;
- clases abstractas;
- métodos genéricos parametrizados;
- límites genéricos (`extends`);
- wildcards;
- colecciones tipadas.

## Alcance

El proyecto implementa los Ejercicios 1, 2 y 3 del Trabajo Práctico 2.

El Ejercicio 4, correspondiente a clases anidadas e hilos, no se encuentra
implementado debido a que dichos contenidos todavía no fueron desarrollados
en la cursada al momento de realizar el trabajo.

## Ejecución

La clase que contiene la implementación principal del trabajo es:

```
AppAlternativo
```
## IMPORTANTE

Para comprobar el funcionamiento de los Ejercicios 1, 2 y 3 se debe ejecutar AppAlternativo.

La clase App contiene una implementación alternativa que utiliza entrada de datos mediante Scanner y no corresponde a la ejecución principal utilizada para demostrar los resultados de los ejercicios del trabajo práctico.

En IntelliJ IDEA:
- Abrir el proyecto.
- Ubicar la clase AppAlternativo.
- Ejecutar la clase mediante Run.
- Los resultados de los ejercicios se mostrarán por consola.

## Estructura
```text
PP_TP2_53359/
│
├── src/
│   ├── App.java
│   ├── AppAlternativo.java
│   │
│   ├── excepciones/
│   │   └── CupoExcedidoException.java
│   │
│   └── modelo/
│       ├── Estudiante.java
│       ├── EventoUniversitario.java
│       ├── Inscripcion.java
│       ├── Sala.java
│       │
│       ├── actividades/
│       │   ├── Actividad.java
│       │   ├── Charla.java
│       │   ├── Curso.java
│       │   └── Taller.java
│       │
│       └── certificacion/
│           └── Certificable.java
│
├── imagenes/
│   └── Capturas de la salida por consola
│
├── .gitignore
└── README.md
```

La carpeta imagenes contiene las capturas de la salida por consola obtenidas
durante la ejecución del programa.

## Archivo generado por serialización

Durante la ejecución del programa se genera un archivo:

``` evento_Ev-01.dat ```

Este archivo corresponde a la persistencia del evento mediante serialización de
objetos.

## Requisitos
- Java JDK 21
- IntelliJ IDEA
- Clonar el repositorio

## Clonar el repositorio
Para clonar el repositorio mediante HTTPS:

```git clone https://github.com/MartiiF/PP_TP2_53359.git```

Luego ingresar al directorio del proyecto:

```cd PP_TP2_53359```

Abrir el proyecto desde IntelliJ IDEA y ejecutar la clase:

```AppAlternativo```

## Autor
Legajo: 53359
