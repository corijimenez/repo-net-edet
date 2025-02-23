package com.mycompany.proyecto.edet.presentation.controller;

import com.mycompany.proyecto.edet.domain.entities.Cuenta;
import com.mycompany.proyecto.edet.aplication.services.GestorRNC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CuentaController {
    private final GestorRNC gestor;

    public CuentaController(GestorRNC gestor) {
        this.gestor = gestor;
    }

    public void ingresarDatos( String email,  String contraseña, String confirmacionContraseña,  boolean seAceptoTerminos) {
        gestor.ingresarDatos(email, contraseña, confirmacionContraseña, seAceptoTerminos);
    }
//    @PostMapping("/confirmar")
//    public ResponseEntity<String> confirmarCuenta(@RequestParam String email, @RequestParam String codigo) {
//        gestor.confirmarCuenta(email, codigo);
//        return ResponseEntity.ok("Cuenta confirmada correctamente");
//    }
//
//    @PostMapping("/enviar-codigo")
//    public ResponseEntity<String> enviarCodigo(@RequestParam String email, @RequestParam String codigo) {
//        gestor.enviarCodigoConfirmacion(email, codigo);
//        return ResponseEntity.ok("Código enviado correctamente");
//    }
}



