package com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.service;

import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model.DisposalGuideline;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model.RecyclingTip;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.model.WasteCategory;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.repository.DisposalGuidelineRepository; // Import DisposalGuidelineRepository

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteManagementService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    @Autowired // Autowire DisposalGuidelineRepository
    private DisposalGuidelineRepository disposalGuidelineRepository;

    // Waste Category methods
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    public WasteCategory saveWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }

    // Recycling Tip methods
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    public Optional<RecyclingTip> getRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id);
    }

    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip);
    }

    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }

    // Disposal Guideline methods
    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }

    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline saveDisposalGuideline(DisposalGuideline disposalGuideline) {
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public Optional<DisposalGuideline> getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id);
    }
}
