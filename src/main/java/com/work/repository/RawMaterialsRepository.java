package com.work.repository;

import com.work.entity.RawMaterials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RawMaterialsRepository extends JpaRepository<RawMaterials, Long> {
    List<RawMaterials> findByPrescription_Id(Long id);

}