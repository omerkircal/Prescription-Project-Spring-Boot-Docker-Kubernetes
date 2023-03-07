package com.work.service;

import com.work.dto.PrescriptionRequest;
import com.work.dto.PrescriptionDto;
import com.work.dto.converter.PrescriptionDtoConverter;
import com.work.entity.Prescription;
import com.work.exception.PrescriptionNotFoundException;
import com.work.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionDtoConverter prescriptionDtoConverter;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository, PrescriptionDtoConverter prescriptionDtoConverter) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionDtoConverter = prescriptionDtoConverter;
    }

    @Override
    public PrescriptionDto save(PrescriptionRequest prescriptionRequest){

        Prescription prescription=Prescription.builder()
                .name(prescriptionRequest.getName())
                .serialNumber(prescriptionRequest.getSerialNumber())
                .prescriptionType(prescriptionRequest.getPrescriptionType())
                .build();

        return prescriptionDtoConverter.convert(prescriptionRepository.save(prescription));

    }

    @Override
    public PrescriptionDto update(Long id, PrescriptionRequest prescriptionRequest){
        Prescription existingPrescription=prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription could not found by id: "+id));

            existingPrescription.setName(prescriptionRequest.getName());
            existingPrescription.setSerialNumber(prescriptionRequest.getSerialNumber());
            existingPrescription.setPrescriptionType(prescriptionRequest.getPrescriptionType());

            return prescriptionDtoConverter.convert(prescriptionRepository.save(existingPrescription));
    }

    @Override
    public List<PrescriptionDto> allPrescription(){
        List<Prescription> prescriptionList=prescriptionRepository.findAll();

        return prescriptionList.stream().map(prescriptionDtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public PrescriptionDto getById(Long id){
        return prescriptionRepository.findById(id)
                .map(prescriptionDtoConverter::convert)
                .orElseThrow(()->new PrescriptionNotFoundException("Prescription could not found by id: "+id));

    }

    @Override
    public void delete(Long id){
        Prescription prescription=prescriptionRepository.findById(id)
                .orElseThrow(()->new PrescriptionNotFoundException("Prescription could not found by id: "+id));

            prescriptionRepository.delete(prescription);

    }


}