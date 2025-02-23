package com.mycompany.proyecto.edet.infraestructure_transversal.emails;

import com.mycompany.proyecto.edet.domain.entities.CodigoConfirmacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
   
    //  simula el envío de un correo
    public void enviarCodigoConfirmacion(String email, String codigoConfirmacion) {
        // Simular el envío de un correo
        String mensaje = "Hola, hemos recibido tu solicitud para crear una cuenta. "
                        + "Tu código de confirmación es: " + codigoConfirmacion
                        + "\nEste código tiene una validez de 24 horas.";
        
        // Simulamos que el correo fue enviado
        System.out.println("Enviando correo a: " + email);
        System.out.println("Contenido del correo: " + mensaje);
    }
}

    

