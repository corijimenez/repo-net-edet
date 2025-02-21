package com.mycompany.proyecto.edet.aplication.services;

import com.mycompany.proyecto.edet.infraestructure_transversal.emails.EmailService ;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {
    private final EmailService emailService;

    public CuentaService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void confirmarCuenta(String email, String codigo) {
        // Implementación de la confirmación
        System.out.println("Confirmando cuenta para: " + email + " con código: " + codigo);
    }

    public void enviarCodigoConfirmacion(String email, String codigo) {
        emailService.enviarEmail(email, "Código de Confirmación", "Su código es: " + codigo);
    }
}

