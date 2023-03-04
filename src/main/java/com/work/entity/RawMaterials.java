package com.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "raw_materials")
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(message = "Description cannot exceed 50 characters.", max = 50)
    @NotBlank(message = "Please Enter Description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prescription_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Prescription prescription;
}
