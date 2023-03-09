package com.work.dto;

import com.work.entity.Prescription;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterialsRequest {
    @Length(message = "Description cannot exceed 50 characters.", max = 50)
    @NotBlank(message = "Please Enter Description")
    private String description;

    private Prescription prescription;
}
