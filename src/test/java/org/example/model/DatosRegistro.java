package org.example.model;

import java.util.Map;

public record DatosRegistro(
        String cedula,
        String nombres,
        String apellidos,
        String correo,
        String contrasena
) {

    public static DatosRegistro desde(Map<String, String> fila) {
        return new DatosRegistro(
                fila.get("cedula"),
                fila.get("nombres"),
                fila.get("apellidos"),
                fila.get("correo"),
                fila.get("contraseña")
        );
    }
}