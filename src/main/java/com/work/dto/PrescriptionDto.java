package com.work.dto;

import com.work.utils.PrescriptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PrescriptionDto {
    private Long id;
    private String name;
    private Long serialNumber;
    private PrescriptionType prescriptionType;

}
