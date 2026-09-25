package org.example.model;

import java.util.Map;

public record DatosCompraInvitado(
        String documento,
        String nombres,
        String apellidos,
        String correo,
        String telefono,
        String direccion,
        String ciudad,
        String departamento,
        String pais,
        String codigoPostal
) {

    public static DatosCompraInvitado desde(Map<String, String> fila) {
        return new DatosCompraInvitado(
                fila.get("documento"),
                fila.get("nombres"),
                fila.get("apellidos"),
                fila.get("correo"),
                fila.get("telefono"),
                fila.get("direccion"),
                fila.get("ciudad"),
                fila.get("departamento"),
                fila.get("pais"),
                fila.get("codigoPostal")
        );
    }
}
