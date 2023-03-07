package com.work.dto;

import com.work.entity.PrescriptionType;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionRequest {

    @NotNull(message = "Please Enter Id")
    private Long id;

    @Length(message = "Name cannot exceed 50 characters.", max = 50)
    @NotBlank(message = "Please Enter Name")
    private String name;

    @NotNull(message = "Please Enter Serial Number")
    private Long serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrescriptionType prescriptionType;
}
