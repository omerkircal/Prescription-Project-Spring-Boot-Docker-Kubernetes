package com.work.service;

import com.work.entity.Prescription;
import com.work.entity.PrescriptionType;
import com.work.entity.RawMaterials;
import com.work.repository.PrescriptionRepository;
import com.work.repository.RawMaterialsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RawMaterialsServiceImplTest {

    @InjectMocks
    private RawMaterialsServiceImpl rawMaterialsService;

    @Mock
    private RawMaterialsRepository rawMaterialsRepository;
    @Mock
    private Prescription prescription;

    private RawMaterials sample1;
    private RawMaterials sample2;
    private RawMaterials sample3;

    @BeforeEach
    void setUp() {
        sample1=new RawMaterials();
        sample1.setId(1L);
        sample1.setDescription("Sample Description");
        sample1.setPrescription(new Prescription(1L,"Test",123L, PrescriptionType.TYPE_1));

        sample2=new RawMaterials();
        sample2.setId(2L);
        sample2.setDescription("Sample Description");
        sample2.setPrescription(new Prescription(1L,"Test",123L, PrescriptionType.TYPE_1));

        sample3=new RawMaterials();
        sample3.setId(3L);
        sample3.setDescription("Sample Description");
        sample3.setPrescription(new Prescription(2L,"Test",123L, PrescriptionType.TYPE_1));
    }

    @Test
    void save() {
        when(rawMaterialsRepository.save(any(RawMaterials.class))).thenReturn(sample1);

        RawMaterials rawMaterials=rawMaterialsService.save(sample1);

        assertNotNull(rawMaterials);

        assertEquals("Sample Description",rawMaterials.getDescription());
    }

    @Test
    void update() {
        when(rawMaterialsRepository.findById(anyLong())).thenReturn(Optional.of(sample1));

        when(rawMaterialsRepository.save(any(RawMaterials.class))).thenReturn(sample1);
        sample1.setDescription("Test Description");

        RawMaterials rawMaterials=rawMaterialsService.update(sample1.getId(),sample1);

        assertNotNull(rawMaterials);

        assertEquals("Test Description",rawMaterials.getDescription());
    }

    @Test
    void getAll() {
        List<RawMaterials> list=new ArrayList<>();
        list.add(sample1);
        list.add(sample2);
        list.add(sample3);

        when(rawMaterialsRepository.findAll()).thenReturn(list);

        List<RawMaterials> rawMaterials=rawMaterialsService.getAll();

        assertEquals(3,rawMaterials.size());
        assertNotNull(rawMaterials);
    }


    @Test
    void getPrescriptionMaterials(){
        List<RawMaterials> list=new ArrayList<>();
        list.add(sample1);
        list.add(sample2);

        when(rawMaterialsRepository.findByPrescription_Id(anyLong())).thenReturn(list);

        List<RawMaterials> rawMaterials=rawMaterialsService.getPrescriptionMaterials(anyLong());

        assertEquals(2,rawMaterials.size());
    }




}