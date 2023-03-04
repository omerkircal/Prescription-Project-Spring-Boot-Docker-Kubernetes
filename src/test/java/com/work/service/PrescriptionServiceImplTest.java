package com.work.service;

import com.work.entity.Prescription;
import com.work.entity.PrescriptionType;
import com.work.repository.PrescriptionRepository;
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
class PrescriptionServiceImplTest {

    @InjectMocks
    private PrescriptionServiceImpl prescriptionService;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    private Prescription sample1;
    private Prescription sample2;

    @BeforeEach
    void setUp() {
        sample1=new Prescription();
        sample1.setId(1L);
        sample1.setName("Test Name");
        sample1.setSerialNumber(123L);
        sample1.setPrescriptionType(PrescriptionType.TYPE_1);

        sample2=new Prescription();
        sample2.setId(2L);
        sample2.setName("Test Name");
        sample2.setSerialNumber(123L);
        sample2.setPrescriptionType(PrescriptionType.TYPE_2);
    }

    @Test
    void save() {
        when(prescriptionRepository.save(any(Prescription.class))).thenReturn(sample1);

        Prescription prescription=prescriptionService.save(sample1);

        assertNotNull(prescription);

        assertEquals("Test Name",prescription.getName());
    }

    @Test
    void update() {
        when(prescriptionRepository.findById(anyLong())).thenReturn(Optional.of(sample1));

        when(prescriptionRepository.save(any(Prescription.class))).thenReturn(sample1);
        sample1.setPrescriptionType(PrescriptionType.TYPE_2);

        Prescription prescription=prescriptionService.update(sample1.getId(),sample1);

        assertNotNull(prescription);

        assertEquals(PrescriptionType.TYPE_2,prescription.getPrescriptionType());

    }

    @Test
    void allPrescription() {
        List<Prescription> list=new ArrayList<>();
        list.add(sample1);
        list.add(sample2);

        when(prescriptionRepository.findAll()).thenReturn(list);

        List<Prescription> prescriptions=prescriptionService.allPrescription();

        assertEquals(2,prescriptions.size());
        assertNotNull(prescriptions);
    }

    @Test
    void getById() {
        when(prescriptionRepository.findById(anyLong())).thenReturn(Optional.of(sample1));

        Prescription prescription=prescriptionService.getById(sample1.getId());

        assertNotNull(prescription);
        assertNotEquals(null,prescription.getId());
    }

    @Test
    void getByIdForException(){
        when(prescriptionRepository.findById(2L)).thenReturn(Optional.of(sample1));

        assertThrows(RuntimeException.class,()-> prescriptionService.getById(sample1.getId()));

    }

    @Test
    void delete() {
        Long prescriptionId=1L;

        when(prescriptionRepository.findById(anyLong())).thenReturn(Optional.of(sample1));
        doNothing().when(prescriptionRepository).delete(any(Prescription.class));

        prescriptionService.delete(prescriptionId);

        verify(prescriptionRepository,times(1)).delete(sample1);
    }
}