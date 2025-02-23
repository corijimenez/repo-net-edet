/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto.edet;


import javax.swing.JFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoEdet {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoEdet.class, args);
        JFrame ventana = new JFrame();
        ventana.setVisible(true);

    }
}