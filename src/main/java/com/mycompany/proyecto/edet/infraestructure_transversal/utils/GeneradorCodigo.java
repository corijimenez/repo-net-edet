
package com.mycompany.proyecto.edet.infraestructure_transversal.utils;


import java.security.SecureRandom;

public class GeneradorCodigo {
    private static final GeneradorCodigo instancia = new GeneradorCodigo();
    private static final SecureRandom random = new SecureRandom();

    // Constructor privado para evitar instanciación externa
    private GeneradorCodigo() {}

    // Método estático para obtener la única instancia del Singleton
    public static GeneradorCodigo getInstancia() {
        return instancia;
    }

    // Método para generar un código de 6 dígitos
    public String generarCodigo() {
        int codigo = 100000 + random.nextInt(900000);  // Genera un número entre 100000 y 999999
        
        return String.valueOf(codigo);
    }
}
