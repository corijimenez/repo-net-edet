package com.mycompany.proyecto.edet.aplication.services;

import com.mycompany.proyecto.edet.domain.entities.Cuenta;
import com.mycompany.proyecto.edet.domain.entities.CodigoConfirmacion;
import com.mycompany.proyecto.edet.domain.repositories.CuentaRepositorio;
import com.mycompany.proyecto.edet.infraestructure_transversal.emails.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorRNC {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    public void ingresarDatos(String email, String contraseña, String confirmacionContraseña, boolean seAceptoTerminos) {
        // 1. Crear cuenta en estado INACTIVA
        Cuenta nuevaCuenta = cuentaRepositorio.findByEmail(email);
        if (nuevaCuenta ==null && contraseña.equals(confirmacionContraseña)&& seAceptoTerminos){
        nuevaCuenta = new Cuenta(email, contraseña, seAceptoTerminos);
        cuentaRepositorio.save(nuevaCuenta); 
        
        String codigoConfirmacion = nuevaCuenta.getCodigoConfirmacion(); // Ahora obtenemos el código como String
        emailService.enviarCodigoConfirmacion(email, codigoConfirmacion);
        
        }else {
            throw new IllegalArgumentException("Verifique que los terminos hayan sido aceptados y que las contraseñas coincidan");
        } 
    }
}
