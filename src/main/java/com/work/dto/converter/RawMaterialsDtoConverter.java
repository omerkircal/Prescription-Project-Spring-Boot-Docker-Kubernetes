package com.work.dto.converter;

import com.work.dto.RawMaterialsDto;
import com.work.entity.RawMaterials;
import org.springframework.stereotype.Component;

@Component
public class RawMaterialsDtoConverter {
    public RawMaterialsDto convert(RawMaterials rawMaterials){
       RawMaterialsDto rawMaterialsDto=new RawMaterialsDto();
        rawMaterialsDto.setId(rawMaterialsDto.getId());
        rawMaterialsDto.setDescription(rawMaterialsDto.getDescription());
        rawMaterialsDto.setPrescription(rawMaterials.getPrescription());

        return rawMaterialsDto;
    }
}
