// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Importante: los datos se pierden al reiniciar la aplicación — ideal para pruebas rápidas.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Implementación del repositorio en memoria usando un HashMap.
// Sirve para guardar los datos temporalmente sin necesidad de una base de datos real.

package com.inventario.repository;

import com.inventario.entities.Material;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMaterialRepository implements MaterialRepository {
    private final Map<Long, Material> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Material save(Material material) {
        Long id = idGenerator.getAndIncrement();
        material.setId(id);
        storage.put(id, material);
        return material;
    }

    @Override
    public Optional<Material> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Material> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public List<Material> findAllActive() {
        return storage.values().stream()
                .filter(Material::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Material material) {
        if (material.getId() == null || !storage.containsKey(material.getId())) {
            throw new NoSuchElementException("Material no encontrado con id = " + material.getId());
        }
        storage.put(material.getId(), material);
    }

    @Override
    public void deleteById(Long id) {
        Material m = storage.get(id);
        if (m != null) {
            m.setActive(false);
            storage.put(id, m);
        }
    }
}
