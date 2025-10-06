// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Clase de apoyo para separar la representación de categoría del material.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Clase sencilla para manejar las categorías de materiales (por ejemplo: libros, electrónicos, etc.)
// Sirve para clasificar los materiales dentro del sistema.

package com.inventario.entities;

public class Category {
    private Long id;
    private String name;

    public Category() {}

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
