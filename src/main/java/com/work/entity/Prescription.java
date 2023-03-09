package com.work.entity;

import com.work.dto.PrescriptionDto;
import com.work.utils.PrescriptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = "prescription")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Prescription extends PrescriptionDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
