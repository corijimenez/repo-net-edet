package com.mycompany.proyecto.edet.domain.entities;

import com.mycompany.proyecto.edet.infraestructure_transversal.utils.GeneradorCodigo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCuenta estado;

    @Column(nullable = false)
    private CodigoConfirmacion codigoConfirmacion;

    @Column(nullable = false)
    private boolean seAceptoTerminos;

    public Cuenta(String email, String contraseña, boolean seAceptoTerminos) {
        this.email = email;
        this.contraseña = contraseña;
        this.estado = EstadoCuenta.INACTIVO;
        this.seAceptoTerminos = seAceptoTerminos;
        generarCodigoConfirmacion(); // Genera automáticamente el código de confirmación
    }

    // Genera el código de confirmación
    public void generarCodigoConfirmacion() {
        String codigo = GeneradorCodigo.getInstancia().generarCodigo();
        this.codigoConfirmacion = new CodigoConfirmacion(codigo); // Crea el objeto CodigoConfirmacion
    }

    // Obtener el código de confirmación como String (usado en GestorRNC)
    public String getCodigoConfirmacion() {
        return this.codigoConfirmacion.getCodigo(); // Obtener solo el código como String
    }
}

