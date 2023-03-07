package com.work.service;

import com.work.dto.RawMaterialsDto;
import com.work.dto.RawMaterialsRequest;
import com.work.dto.converter.RawMaterialsDtoConverter;
import com.work.entity.RawMaterials;
import com.work.exception.RawMaterialsNotFoundException;
import com.work.repository.RawMaterialsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RawMaterialsServiceImpl implements RawMaterialsService{

    private final RawMaterialsRepository rawMaterialsRepository;
    private final RawMaterialsDtoConverter rawMaterialsDtoConverter;

    public RawMaterialsServiceImpl(RawMaterialsRepository rawMaterialsRepository, RawMaterialsDtoConverter rawMaterialsDtoConverter) {
        this.rawMaterialsRepository = rawMaterialsRepository;
        this.rawMaterialsDtoConverter = rawMaterialsDtoConverter;
    }

    @Override
    public RawMaterialsDto save(RawMaterialsRequest rawMaterialsRequest) {
        RawMaterials rawMaterials=RawMaterials.builder()
                .description(rawMaterialsRequest.getDescription())
                .prescription(rawMaterialsRequest.getPrescription())
                .build();

        return rawMaterialsDtoConverter.convert(rawMaterialsRepository.save(rawMaterials));
    }

    @Override
    public RawMaterialsDto update(Long id, RawMaterialsRequest rawMaterialsRequest) {
        RawMaterials existingRawMaterials=rawMaterialsRepository.findById(id)
                .orElseThrow(() -> new RawMaterialsNotFoundException("Raw material could not found by id: "+id));

        existingRawMaterials.setDescription(rawMaterialsRequest.getDescription());
        existingRawMaterials.setPrescription(rawMaterialsRequest.getPrescription());

        return rawMaterialsDtoConverter.convert(rawMaterialsRepository.save(existingRawMaterials));
    }

    @Override
    public List<RawMaterialsDto> getAll() {
        List<RawMaterials> rawMaterialsList=rawMaterialsRepository.findAll();

        return rawMaterialsList.stream().map(rawMaterialsDtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public List<RawMaterialsDto> getPrescriptionMaterials(Long id) {
        List<RawMaterials> rawMaterialsList=rawMaterialsRepository.findByPrescription_Id(id);

        return rawMaterialsList.stream().map(rawMaterialsDtoConverter::convert).collect(Collectors.toList());
    }


    @Override
    public void delete(Long id){
        RawMaterials rawMaterials=rawMaterialsRepository.findById(id)
                .orElseThrow(()->new RawMaterialsNotFoundException("Raw material could not found by id: "+id));

        rawMaterialsRepository.delete(rawMaterials);

    }
}