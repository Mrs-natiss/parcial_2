// Controlador que maneja las peticiones del usuario.
// Se comunica con el servicio para crear, listar y actualizar materiales.

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

    // Crea un nuevo material
    @PostMapping
    public ResponseEntity<Material> crear(@RequestBody MaterialRequest req) {
        Material nuevo = service.create(req);
        return ResponseEntity.ok(nuevo);
    }

    // Muestra todos los materiales
    @GetMapping
    public ResponseEntity<List<Material>> listarTodos() {
        return ResponseEntity.ok(service.getAll());
    }

    // Muestra los materiales activos
    @GetMapping("/activos")
    public ResponseEntity<List<Material>> listarActivos() {
        return ResponseEntity.ok(service.getActive());
    }

    // Actualiza la cantidad de un material
    @PatchMapping("/cantidad")
    public ResponseEntity<Material> actualizarCantidad(@RequestBody UpdateQuantityRequest req) {
        Material actualizado = service.updateQuantity(req);
        return ResponseEntity.ok(actualizado);
    }
}
