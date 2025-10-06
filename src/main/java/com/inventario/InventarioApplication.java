// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Clase de arranque. Mantenerla limpia y sin lógica para que Spring la gestione.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Clase principal que inicia el proyecto Spring Boot.
// Desde aquí arranca el servidor embebido (Tomcat) y se cargan todos los componentes del sistema.

package com.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventarioApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }
}
