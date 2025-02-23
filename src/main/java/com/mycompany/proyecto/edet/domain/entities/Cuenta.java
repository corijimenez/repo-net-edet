package com.mycompany.proyecto.edet.domain.entities;

import com.mycompany.proyecto.edet.infraestructure_transversal.utils.GeneradorCodigo;
import com.mycompany.proyecto.edet.domain.entities.CodigoConfirmacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.lang.String ;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
private GeneradorCodigo generador;
private CodigoConfirmacion codigo;


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

    
    public Cuenta(String email, String contraseña, EstadoCuenta estado, CodigoConfirmacion codigoConfirmacion, boolean seAceptoTerminos) {
        this.email = email;
        this.contraseña = contraseña;
        this.estado = estado.INACTIVO;
        this.seAceptoTerminos = seAceptoTerminos;
    }

    public Cuenta(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }
    public CodigoConfirmacion getCodigoConfirmacion() {
        return codigoConfirmacion;
    }

    public void setCodigoConfirmacion(CodigoConfirmacion codigoConfirmacion) {
        this.codigoConfirmacion = codigoConfirmacion;
    }
    
    public void activarCuenta() {
        this.estado = estado.ACTIVO;
    }
}

