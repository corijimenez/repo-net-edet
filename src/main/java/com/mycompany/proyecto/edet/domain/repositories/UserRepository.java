package com.mycompany.proyecto.edet.domain.repositories;

import com.mycompany.proyecto.edet.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //  métodos personalizados si es necesario, por ejemplo:
    User findByUsuario(String usuario);
}
