package com.work.controller;

import com.work.dto.RawMaterialsDto;
import com.work.dto.RawMaterialsRequest;
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

    @PostMapping
    public RawMaterialsDto save(@RequestBody @Valid RawMaterialsRequest rawMaterialsRequest){
        return rawMaterialsService.save(rawMaterialsRequest);
    }

    @PutMapping("/{id}")
    public RawMaterialsDto update(@PathVariable Long id,@RequestBody @Valid RawMaterialsRequest rawMaterialsRequest){
        return rawMaterialsService.update(id,rawMaterialsRequest);
    }

    @GetMapping
    public List<RawMaterialsDto> getAll(){
        return rawMaterialsService.getAll();
    }


    @GetMapping("/{id}")
    public List<RawMaterialsDto> prescriptionMaterial(@PathVariable Long id){
        return rawMaterialsService.getPrescriptionMaterials(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        rawMaterialsService.delete(id);
    }
}
