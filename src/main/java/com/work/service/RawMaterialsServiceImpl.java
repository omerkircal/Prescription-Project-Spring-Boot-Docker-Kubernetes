package com.work.service;

import com.work.entity.Prescription;
import com.work.entity.RawMaterials;
import com.work.exception.PrescriptionNotFoundException;
import com.work.exception.RawMaterialsNotFoundException;
import com.work.repository.RawMaterialsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialsServiceImpl implements RawMaterialsService{

    private final RawMaterialsRepository rawMaterialsRepository;

    public RawMaterialsServiceImpl(RawMaterialsRepository rawMaterialsRepository) {
        this.rawMaterialsRepository = rawMaterialsRepository;
    }

    @Override
    public RawMaterials save(RawMaterials rawMaterials) {
        return rawMaterialsRepository.save(rawMaterials);
    }

    @Override
    public RawMaterials update(Long id, RawMaterials rawMaterials) {
        RawMaterials existingRawMaterials=rawMaterialsRepository.findById(id)
                .orElseThrow(() -> new RawMaterialsNotFoundException("Raw material could not found by id: "+id));

        existingRawMaterials.setDescription(rawMaterials.getDescription());

        return rawMaterialsRepository.save(rawMaterials);
    }

    @Override
    public List<RawMaterials> getAll() {
        return rawMaterialsRepository.findAll();
    }

    @Override
    public List<RawMaterials> getPrescriptionMaterials(Long id) {
        return rawMaterialsRepository.findByPrescription_Id(id);
    }


    @Override
    public void delete(Long id){
        RawMaterials rawMaterials=rawMaterialsRepository.findById(id)
                .orElseThrow(()->new RawMaterialsNotFoundException("Raw material could not found by id: "+id));

        rawMaterialsRepository.delete(rawMaterials);

    }
}