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

    @PostMapping("/save")
    public PrescriptionDto save(@RequestBody @Valid PrescriptionRequest prescriptionRequest){
        return prescriptionService.save(prescriptionRequest);
    }

    @PutMapping("/update")
    public PrescriptionDto update(@RequestParam Long id, @RequestBody @Valid PrescriptionRequest prescriptionRequest){
        return prescriptionService.update(id, prescriptionRequest);
    }

    @GetMapping("/getAll")
    public List<PrescriptionDto> allPrescription(){
        return prescriptionService.allPrescription();
    }

    @GetMapping("/getById")
    public PrescriptionDto getById(@RequestParam Long id){
        return prescriptionService.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        prescriptionService.delete(id);
    }
}
