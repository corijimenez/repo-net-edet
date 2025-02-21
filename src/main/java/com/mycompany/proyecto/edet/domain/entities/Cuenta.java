package com.mycompany.proyecto.edet.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
    private String codigoConfirmacion;

    @Column(nullable = false)
    private boolean terminosAceptados;

    // Constructor adicional si es necesario para simplificar la creación
    public Cuenta(String email, String contraseña, EstadoCuenta estado, String codigoConfirmacion, boolean terminosAceptados) {
        this.email = email;
        this.contraseña = contraseña;
        this.estado = estado;
        this.codigoConfirmacion = codigoConfirmacion;
        this.terminosAceptados = terminosAceptados;
    }
    
    
}

