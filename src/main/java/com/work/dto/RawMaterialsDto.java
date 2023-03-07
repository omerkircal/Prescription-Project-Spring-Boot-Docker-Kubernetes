package com.work.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class RawMaterialsDto {
    private Long id;
    private String description;
    private PrescriptionDto prescription;
}
