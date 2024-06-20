package com.agiletech.arteria_api.calculated_risk.api;

import com.agiletech.arteria_api.calculated_risk.domain.service.RecommendationService;
import com.agiletech.arteria_api.calculated_risk.mapping.RecommendationMapper;
import com.agiletech.arteria_api.calculated_risk.resource.CreateRecommendationResource;
import com.agiletech.arteria_api.calculated_risk.resource.RecommendationResource;
import com.agiletech.arteria_api.calculated_risk.resource.UpdateRecommendationResource;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Recommendation")
@RestController
@RequestMapping("api/v1/recommendations")
@CrossOrigin
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RecommendationMapper recommendationMapper;

    @Operation(summary = "Get All Allergies", description = "Get All Allergies")
    @GetMapping()
    public List<RecommendationResource> getAll(){
        return recommendationMapper.toResource(recommendationService.getAll());
    }

    @Operation(summary = "Get Recommendation by Id", description = "Get Recommendation by Id")
    @GetMapping("{recommendationId}")
    public RecommendationResource getRecommendationById(@PathVariable Long recommendationId){
        return recommendationMapper.toResource(recommendationService.getById(recommendationId));
    }

    @Operation(summary = "Get Recommendation by CalculatedRisk", description = "Get Recommendations By CalculatedRisk Id")
    @GetMapping("calculatedRisk/{calculatedRiskId}")
    public RecommendationResource getRecommendationByCalculatedRiskId(@PathVariable Long calculatedRiskId){
        return recommendationMapper.toResource((recommendationService.getByCalculatedRisk(calculatedRiskId)));
    }

    @Operation(summary = "Create New Recommendation", description = "Create New Recommendation")
    @PostMapping("calculatedRisk/{calculatedRiskId}")
    public RecommendationResource createRecommendation(@RequestBody CreateRecommendationResource model, @PathVariable Long calculatedRiskId){
        return recommendationMapper.toResource(recommendationService.create(recommendationMapper.toModel(model), calculatedRiskId));
    }

    @Operation(summary = "Update Recommendation", description = "Update Recommendation")
    @PutMapping("{recommendationId}")
    public RecommendationResource updateRecommendation(@PathVariable Long recommendationId, @RequestBody UpdateRecommendationResource model){
        return recommendationMapper.toResource(recommendationService.update(recommendationId, recommendationMapper.toModel(model)));
    }
}
