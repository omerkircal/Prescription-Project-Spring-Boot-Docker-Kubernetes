package com.work.service;

import com.work.entity.Prescription;

import java.util.List;

public interface PrescriptionService {

    Prescription save(Prescription prescription);

    Prescription update(Long id, Prescription prescription);

    List<Prescription> allPrescription();

    Prescription getById(Long id);

    void delete(Long id);
}