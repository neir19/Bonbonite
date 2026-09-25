package org.example.model;

import java.util.Map;

public record DatosLogin(
        String cedula,
        String contrasena
) {

    public static DatosLogin desde(Map<String, String> fila) {
        return new DatosLogin(
                fila.get("cedula"),
                fila.get("contraseña")
        );
    }
}