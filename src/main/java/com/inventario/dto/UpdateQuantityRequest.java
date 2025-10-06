// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// DTO para actualizar cantidades. 'replace' indica si sustituir o aplicar delta.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// DTO usado para actualizar la cantidad de un material existente.
// Permite decidir si reemplazar la cantidad o sumarle/restarle un valor.

package com.inventario.dto;

public class UpdateQuantityRequest {
    private Long materialId;
    private int quantity;
    private boolean replace = true;

    public UpdateQuantityRequest() {}

    public Long getMaterialId() { return materialId; }
    public void setMaterialId(Long materialId) { this.materialId = materialId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isReplace() { return replace; }
    public void setReplace(boolean replace) { this.replace = replace; }
}
