package com.mycompany.proyecto.edet.presentation.controller;

import com.mycompany.proyecto.edet.domain.entities.Cuenta;
import com.mycompany.proyecto.edet.aplication.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("/confirmar")
    public ResponseEntity<String> confirmarCuenta(@RequestParam String email, @RequestParam String codigo) {
        cuentaService.confirmarCuenta(email, codigo);
        return ResponseEntity.ok("Cuenta confirmada correctamente");
    }

    @PostMapping("/enviar-codigo")
    public ResponseEntity<String> enviarCodigo(@RequestParam String email, @RequestParam String codigo) {
        cuentaService.enviarCodigoConfirmacion(email, codigo);
        return ResponseEntity.ok("Código enviado correctamente");
    }
}



