package org.example.model;

import java.util.Map;

public record DatosCuenta(
        String nombres,
        String apellidos,
        String correo
) {

    public static DatosCuenta desde(Map<String, String> fila) {
        return new DatosCuenta(
                fila.get("nombres"),
                fila.get("apellidos"),
                fila.get("correo")
        );
    }
}
