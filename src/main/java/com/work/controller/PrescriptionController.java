package com.work.controller;

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
    public Prescription save(@RequestBody @Valid Prescription prescription){
        return prescriptionService.save(prescription);
    }

    @PutMapping("/update")
    public Prescription update(@RequestParam Long id, @RequestBody @Valid Prescription prescription){
        return prescriptionService.update(id,prescription);
    }

    @GetMapping("/getAll")
    public List<Prescription> allPrescription(){
        return prescriptionService.allPrescription();
    }

    @GetMapping("/getById")
    public Prescription getById(@RequestParam Long id){
        return prescriptionService.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        prescriptionService.delete(id);
    }
}
