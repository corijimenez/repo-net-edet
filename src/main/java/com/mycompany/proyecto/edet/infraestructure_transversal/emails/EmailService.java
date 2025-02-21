package com.mycompany.proyecto.edet.infraestructure_transversal.emails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        logger.info("Simulando envío de email...");
        logger.info("Para: {}", destinatario);
        logger.info("Asunto: {}", asunto);
        logger.info("Cuerpo:\n{}", cuerpo);
        logger.info("Email simulado enviado correctamente ✅");
    }
}
