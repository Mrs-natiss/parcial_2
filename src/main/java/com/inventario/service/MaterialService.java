// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Lógica de negocio: aquí controlo la creación y actualización de materiales.

// Autor: Natalia Afanador
// Proyecto: Sistema de Control de Inventario de Material Didáctico
// Fecha: Octubre 2025
// Capa de servicio donde se aplica la lógica del negocio.
// Aquí se controlan las reglas para registrar materiales, actualizar cantidades y obtener listados.
// Se comunica con el repositorio pero no directamente con el controlador (encapsulación).

package com.inventario.service;

import com.inventario.dto.MaterialRequest;
import com.inventario.dto.UpdateQuantityRequest;
import com.inventario.entities.Category;
import com.inventario.entities.Material;
import com.inventario.repository.MaterialRepository;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MaterialService {
    private final MaterialRepository materialRepo;
    private final Map<Long, Category> categories = new HashMap<>();
    private long categoryIdGen = 1;

    public MaterialService(MaterialRepository materialRepo) {
        this.materialRepo = materialRepo;
        // dato inicial
        Category libros = new Category(categoryIdGen++, "Libros");
        categories.put(libros.getId(), libros);
    }

    public Material registerMaterial(MaterialRequest req) {
        Category cat;
        if (req.getCategoryId() != null && categories.containsKey(req.getCategoryId())) {
            cat = categories.get(req.getCategoryId());
        } else {
            Long newCatId = categoryIdGen++;
            cat = new Category(newCatId,
                req.getCategoryName() == null ? "Sin categoría" : req.getCategoryName());
            categories.put(newCatId, cat);
        }

        Material material = new Material(null, req.getName(), cat, req.getQuantity(), req.isActive());
        return materialRepo.save(material);
    }

    public List<Material> getAllMaterials() {
        return materialRepo.findAll();
    }

    public List<Material> getActiveMaterials() {
        return materialRepo.findAllActive();
    }

    public Material updateQuantity(UpdateQuantityRequest req) {
        Material m = materialRepo.findById(req.getMaterialId())
                .orElseThrow(() -> new NoSuchElementException("Material no encontrado id=" + req.getMaterialId()));
        if (req.isReplace()) {
            m.setQuantity(req.getQuantity());
        } else {
            int newQ = m.getQuantity() + req.getQuantity();
            m.setQuantity(Math.max(newQ, 0));
        }
        materialRepo.update(m);
        return m;
    }

    public Optional<Material> findById(Long id) {
        return materialRepo.findById(id);
    }

    public List<Category> listCategories() { return new ArrayList<>(categories.values()); }
}
