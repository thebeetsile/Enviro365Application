package com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.controller;

import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.service.WasteManagementService;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model.WasteCategory;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model.DisposalGuideline;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model.RecyclingTip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Validated
public class WasteManagementController {
    @Autowired
    private WasteManagementService wasteManagementService;

    // Waste Category Endpoints
    @GetMapping("/waste-categories")
    public List<WasteCategoryDTO> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteManagementService.getAllWasteCategories();
        return wasteCategories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/waste-categories/{id}")
    public ResponseEntity<WasteCategoryDTO> getWasteCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> wasteCategory = wasteManagementService.getWasteCategoryById(id);
        return wasteCategory.map(category -> ResponseEntity.ok(convertToDTO(category)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/waste-categories")
    public WasteCategory createWasteCategory(@Valid @RequestBody WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory wasteCategory = convertToEntity(wasteCategoryDTO);
        return wasteManagementService.saveWasteCategory(wasteCategory);
    }

    @DeleteMapping("/waste-categories/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteManagementService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // Disposal Guideline Endpoints
    @GetMapping("/disposal-guidelines")
    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        List<DisposalGuideline> disposalGuidelines = wasteManagementService.getAllDisposalGuidelines();
        return disposalGuidelines.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/disposal-guidelines/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getDisposalGuidelineById(@PathVariable Long id) {
        Optional<DisposalGuideline> disposalGuideline = wasteManagementService.getDisposalGuidelineById(id);
        return disposalGuideline.map(guideline -> ResponseEntity.ok(convertToDTO(guideline)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/disposal-guidelines")
    public DisposalGuideline createDisposalGuideline(@Valid @RequestBody DisposalGuidelineDTO disposalGuidelineDTO) {
        DisposalGuideline disposalGuideline = convertToEntity(disposalGuidelineDTO);
        return wasteManagementService.saveDisposalGuideline(disposalGuideline);
    }

    @DeleteMapping("/disposal-guidelines/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        wasteManagementService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }

    // Recycling Tip Endpoints
    @GetMapping("/recycling-tips")
    public List<RecyclingTipDTO> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = wasteManagementService.getAllRecyclingTips();
        return recyclingTips.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/recycling-tips/{id}")
    public ResponseEntity<RecyclingTipDTO> getRecyclingTipById(@PathVariable Long id) {
        Optional<RecyclingTip> recyclingTip = wasteManagementService.getRecyclingTipById(id);
        return recyclingTip.map(tip -> ResponseEntity.ok(convertToDTO(tip)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/recycling-tips")
    public RecyclingTip createRecyclingTip(@Valid @RequestBody RecyclingTipDTO recyclingTipDTO) {
        RecyclingTip recyclingTip = convertToEntity(recyclingTipDTO);
        return wasteManagementService.saveRecyclingTip(recyclingTip);
    }

    @DeleteMapping("/recycling-tips/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        wasteManagementService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }

    // Helper methods to convert between entity and DTO
    private WasteCategoryDTO convertToDTO(WasteCategory wasteCategory) {
        WasteCategoryDTO dto = new WasteCategoryDTO();
        dto.setName(wasteCategory.getName());
        dto.setDescription(wasteCategory.getDescription());
        return dto;
    }

    private DisposalGuidelineDTO convertToDTO(DisposalGuideline disposalGuideline) {
        DisposalGuidelineDTO dto = new DisposalGuidelineDTO();
        dto.setGuideline(disposalGuideline.getGuideline());
        return dto;
    }

    private RecyclingTipDTO convertToDTO(RecyclingTip recyclingTip) {
        RecyclingTipDTO dto = new RecyclingTipDTO();
        dto.setTip(recyclingTip.getTip());
        return dto;
    }

    private WasteCategory convertToEntity(WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName(wasteCategoryDTO.getName());
        wasteCategory.setDescription(wasteCategoryDTO.getDescription());
        return wasteCategory;
    }

    private DisposalGuideline convertToEntity(DisposalGuidelineDTO disposalGuidelineDTO) {
        DisposalGuideline disposalGuideline = new DisposalGuideline();
        disposalGuideline.setGuideline(disposalGuidelineDTO.getGuideline());
        return disposalGuideline;
    }

    private RecyclingTip convertToEntity(RecyclingTipDTO recyclingTipDTO) {
        RecyclingTip recyclingTip = new RecyclingTip();
        recyclingTip.setTip(recyclingTipDTO.getTip());
        return recyclingTip;
    }
}
