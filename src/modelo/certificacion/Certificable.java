package modelo.certificacion;

import modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "";

    String generarCertificado(Estudiante estudiante);
}
