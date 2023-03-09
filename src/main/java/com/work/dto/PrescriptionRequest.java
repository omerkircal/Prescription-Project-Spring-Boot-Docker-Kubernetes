package com.work.dto;

import com.work.utils.PrescriptionType;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionRequest {

    @Length(message = "Name cannot exceed 50 characters.", max = 50)
    @NotBlank(message = "Please Enter Name")
    private String name;

    @NotNull(message = "Please Enter Serial Number")
    private Long serialNumber;

    private PrescriptionType prescriptionType;
}
