package com.mycompany.proyecto.edet;

import com.mycompany.proyecto.edet.presentation.vistas.CuentaForm;
import javax.swing.SwingUtilities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mycompany.proyecto.edet")

public class ProyectoEdet {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoEdet.class, args);
        var context = SpringApplication.run(ProyectoEdet.class, args);

        // Obtener instancia de GestorRNC desde el contexto de Spring
        CuentaForm ventana = context.getBean(CuentaForm.class);
        ventana.setVisible(true);
    }
}
