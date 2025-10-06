// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Interfaz que abstrae las operaciones sobre materiales.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Interfaz que define las operaciones que se pueden hacer sobre los materiales.
// Aquí no se implementa la lógica, solo se declara lo que se debe hacer (abstracción).

package com.inventario.repository;

import com.inventario.entities.Material;
import java.util.List;
import java.util.Optional;

public interface MaterialRepository {
    Material save(Material material);
    Optional<Material> findById(Long id);
    List<Material> findAll();
    List<Material> findAllActive();
    void update(Material material);
    void deleteById(Long id);
}
