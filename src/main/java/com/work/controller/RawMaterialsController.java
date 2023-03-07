package com.work.controller;

import com.work.dto.RawMaterialsDto;
import com.work.dto.RawMaterialsRequest;
import com.work.entity.RawMaterials;
import com.work.service.RawMaterialsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rawmaterials")
public class RawMaterialsController {
    private final RawMaterialsServiceImpl rawMaterialsService;

    public RawMaterialsController(RawMaterialsServiceImpl rawMaterialsService) {
        this.rawMaterialsService = rawMaterialsService;
    }

    @PostMapping("/save")
    public RawMaterialsDto save(@RequestBody @Valid RawMaterialsRequest rawMaterialsRequest){
        return rawMaterialsService.save(rawMaterialsRequest);
    }

    @PutMapping("/update")
    public RawMaterialsDto update(@RequestParam Long id,@RequestBody @Valid RawMaterialsRequest rawMaterialsRequest){
        return rawMaterialsService.update(id,rawMaterialsRequest);
    }

    @GetMapping("/getAll")
    public List<RawMaterialsDto> getAll(){
        return rawMaterialsService.getAll();
    }


    @GetMapping("/prescriptionMaterials")
    public List<RawMaterialsDto> prescriptionMaterial(@RequestParam Long id){
        return rawMaterialsService.getPrescriptionMaterials(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        rawMaterialsService.delete(id);
    }
}
