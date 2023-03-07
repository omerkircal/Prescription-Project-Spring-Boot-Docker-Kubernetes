package com.work.service;

import com.work.dto.PrescriptionRequest;
import com.work.dto.PrescriptionDto;
import com.work.entity.Prescription;

import java.util.List;

public interface PrescriptionService {

    PrescriptionDto save(PrescriptionRequest prescriptionRequest);

    PrescriptionDto update(Long id, PrescriptionRequest prescriptionRequest);

    List<PrescriptionDto> allPrescription();

    PrescriptionDto getById(Long id);

    void delete(Long id);
}