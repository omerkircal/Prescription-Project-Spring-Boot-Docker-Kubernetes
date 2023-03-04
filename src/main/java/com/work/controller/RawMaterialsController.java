package com.work.controller;

import com.work.entity.RawMaterials;
import com.work.service.RawMaterialsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rawmaterials")
public class RawMaterialsController {
    private final RawMaterialsServiceImpl rawMaterialsService;

    public RawMaterialsController(RawMaterialsServiceImpl rawMaterialsService) {
        this.rawMaterialsService = rawMaterialsService;
    }

    @PostMapping("/save")
    public RawMaterials save(@RequestBody RawMaterials rawMaterials){
        return rawMaterialsService.save(rawMaterials);
    }

    @PutMapping("/update")
    public RawMaterials update(@RequestParam Long id,@RequestBody RawMaterials rawMaterials){
        return rawMaterialsService.update(id,rawMaterials);
    }

    @GetMapping("/getAll")
    public List<RawMaterials> getAll(){
        return rawMaterialsService.getAll();
    }


    @GetMapping("/prescriptionMaterials")
    public List<RawMaterials> prescriptionMaterial(@RequestParam Long id){
        return rawMaterialsService.getPrescriptionMaterials(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        rawMaterialsService.delete(id);
    }
}
