package com.work.service;

import com.work.dto.RawMaterialsDto;
import com.work.dto.RawMaterialsRequest;
import com.work.entity.RawMaterials;

import java.util.List;

public interface RawMaterialsService {
    RawMaterialsDto save(RawMaterialsRequest rawMaterialsRequest);

    RawMaterialsDto update(Long id,RawMaterialsRequest rawMaterialsRequest);

    List<RawMaterialsDto> getAll();

    List<RawMaterialsDto> getPrescriptionMaterials(Long id);

    void delete(Long id);
}