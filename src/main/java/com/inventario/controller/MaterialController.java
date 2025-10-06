// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Comentario: no añado autenticación por ahora para mantener el ejercicio claro.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Controlador REST que expone los endpoints HTTP.
// Recibe las peticiones del cliente (Postman, navegador, etc.) y usa el servicio para procesarlas.
// Es la capa que conecta el frontend con la lógica del sistema.

package com.inventario.controller;

import com.inventario.dto.MaterialRequest;
import com.inventario.dto.UpdateQuantityRequest;
import com.inventario.entities.Material;
import com.inventario.service.MaterialService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {
    private final MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Material> create(@RequestBody MaterialRequest req) {
        Material created = service.registerMaterial(req);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Material>> getActivos() {
        return ResponseEntity.ok(service.getActiveMaterials());
    }

    @PatchMapping("/cantidad")
    public ResponseEntity<Material> updateQuantity(@RequestBody UpdateQuantityRequest req) {
        Material updated = service.updateQuantity(req);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAll() {
        return ResponseEntity.ok(service.getAllMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
