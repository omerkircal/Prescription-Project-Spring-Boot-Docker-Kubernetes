package com.work.service;

import com.work.entity.RawMaterials;

import java.util.List;

public interface RawMaterialsService {
    RawMaterials save(RawMaterials rawMaterials);

    RawMaterials update(Long id,RawMaterials rawMaterials);

    List<RawMaterials> getAll();

    List<RawMaterials> getPrescriptionMaterials(Long id);

    void delete(Long id);
}