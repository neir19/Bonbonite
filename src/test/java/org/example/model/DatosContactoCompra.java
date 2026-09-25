package org.example.model;

public record DatosContactoCompra(
        String telefono,
        String direccion,
        String ciudad,
        String departamento,
        String pais,
        String codigoPostal
) {
}
