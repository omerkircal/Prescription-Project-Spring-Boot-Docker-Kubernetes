package com.work.controller;

import com.work.dto.PrescriptionRequest;
import com.work.dto.PrescriptionDto;
import com.work.entity.Prescription;
import com.work.service.PrescriptionServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    private final PrescriptionServiceImpl prescriptionService;

    public PrescriptionController(PrescriptionServiceImpl prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public PrescriptionDto save(@RequestBody @Valid PrescriptionRequest prescriptionRequest){
        return prescriptionService.save(prescriptionRequest);
    }

    @PutMapping("/{id}")
    public PrescriptionDto update(@PathVariable Long id, @RequestBody @Valid PrescriptionRequest prescriptionRequest){
        return prescriptionService.update(id, prescriptionRequest);
    }

    @GetMapping
    public List<PrescriptionDto> allPrescription(){
        return prescriptionService.allPrescription();
    }

    @GetMapping("/{id}")
    public PrescriptionDto getById(@PathVariable Long id){
        return prescriptionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        prescriptionService.delete(id);
    }
}
