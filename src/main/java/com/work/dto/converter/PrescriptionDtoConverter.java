package com.work.dto.converter;

import com.work.dto.PrescriptionDto;
import com.work.entity.Prescription;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionDtoConverter {
    public PrescriptionDto convert(Prescription prescription){
        return PrescriptionDto.builder()
                .id(prescription.getId())
                .name(prescription.getName())
                .serialNumber(prescription.getSerialNumber())
                .prescriptionType(prescription.getPrescriptionType())
                .build();
    }
}
