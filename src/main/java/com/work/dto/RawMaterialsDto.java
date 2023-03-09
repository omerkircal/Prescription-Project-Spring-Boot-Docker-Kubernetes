package com.work.dto;

import com.work.entity.Prescription;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RawMaterialsDto {
    private Long id;
    private String description;
    private Prescription prescription;
}
