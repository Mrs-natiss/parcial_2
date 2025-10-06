// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Nota: esta clase es un POJO simple. No está pensada para lógica compleja — solo datos.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Clase que representa un material didáctico dentro del inventario.
// Contiene la información básica como nombre, categoría, cantidad y si está activo.

package com.inventario.entities;

public class Material {
    private Long id;
    private String name;
    private Category category;
    private int quantity;
    private boolean active;

    public Material() {}

    public Material(Long id, String name, Category category, int quantity, boolean active) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
