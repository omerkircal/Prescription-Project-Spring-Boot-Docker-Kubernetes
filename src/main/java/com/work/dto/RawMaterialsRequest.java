package com.work.dto;

import com.work.entity.Prescription;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterialsRequest {
    @Length(message = "Description cannot exceed 50 characters.", max = 50)
    @NotBlank(message = "Please Enter Description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prescription_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Prescription prescription;
}
