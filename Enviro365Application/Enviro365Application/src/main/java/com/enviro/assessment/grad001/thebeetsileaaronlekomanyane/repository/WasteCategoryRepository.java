package com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.repository;

import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    List<WasteCategory> findByName(String name);
    List<WasteCategory> findByDescription(String description);
}
