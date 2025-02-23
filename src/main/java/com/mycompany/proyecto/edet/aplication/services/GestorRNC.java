package com.mycompany.proyecto.edet.aplication.services;

import com.mycompany.proyecto.edet.domain.entities.Cuenta;
import com.mycompany.proyecto.edet.domain.entities.CodigoConfirmacion;
import com.mycompany.proyecto.edet.domain.repositories.CuentaRepositorio;
import com.mycompany.proyecto.edet.infraestructure_transversal.emails.EmailService ;
import com.mycompany.proyecto.edet.infraestructure_transversal.utils.GeneradorCodigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorRNC {
    private final EmailService emailService;
    @Autowired
    private CuentaRepositorio cuentaRepositorio;
    
    @Autowired
    private Cuenta cuenta;
    private GeneradorCodigo generador;

    public GestorRNC(EmailService emailService) {
        this.emailService = emailService;
    }

        public void ingresarDatos(String email, String contraseña,String confirmacionContraseña, boolean seAceptoTerminos) {
        // 1. Crear cuenta en estado INACTIVA
        Cuenta nuevaCuenta = cuentaRepositorio.findByEmail(email);
        if (nuevaCuenta ==null && contraseña.equals(confirmacionContraseña)&& seAceptoTerminos){
        nuevaCuenta = new Cuenta(email, contraseña);
        cuentaRepositorio.save(nuevaCuenta); 
        String codigoGenerado = generador.generarCodigo();
        CodigoConfirmacion codigoConfirmacion = new CodigoConfirmacion(codigoGenerado);
        nuevaCuenta.setCodigoConfirmacion(codigoConfirmacion);
   
        
        
        // 3. Enviar código de confirmación al correo del cliente
        emailService.enviarCodigoConfirmacion(email, codigoConfirmacion);
        }else {
            throw new IllegalArgumentException("Verifique que los terminos hayan sido aceptados y que las contraseñas coincidan");
        } 
       
         

        System.out.println(" Cuenta creada, revisa tu correo para confirmar"); 
        
    } 

        
}

