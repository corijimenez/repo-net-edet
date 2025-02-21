package com.mycompany.proyecto.edet.domain.repositories;

import com.mycompany.proyecto.edet.domain.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {
    Cuenta findByEmail(String email);  
}

