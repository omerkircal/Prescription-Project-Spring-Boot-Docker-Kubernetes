package com.work.service;

import com.work.entity.Prescription;
import com.work.exception.PrescriptionNotFoundException;
import com.work.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Prescription save(Prescription prescription){
        return  prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription update(Long id, Prescription prescription){
        Prescription existingPrescription=prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription could not found by id: "+id));

            existingPrescription.setName(prescription.getName());
            existingPrescription.setSerialNumber(prescription.getSerialNumber());
            existingPrescription.setPrescriptionType(prescription.getPrescriptionType());

            return prescriptionRepository.save(prescription);
    }

    @Override
    public List<Prescription> allPrescription(){
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription getById(Long id){
        return prescriptionRepository.findById(id)
                .orElseThrow(()->new PrescriptionNotFoundException("Prescription could not found by id: "+id));
    }

    @Override
    public void delete(Long id){
        Prescription prescription=prescriptionRepository.findById(id)
                .orElseThrow(()->new PrescriptionNotFoundException("Prescription could not found by id: "+id));

            prescriptionRepository.delete(prescription);

    }


}