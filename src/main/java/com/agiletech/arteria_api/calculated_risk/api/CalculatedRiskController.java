package com.agiletech.arteria_api.calculated_risk.api;

import com.agiletech.arteria_api.calculated_risk.domain.service.CalculatedRiskService;
import com.agiletech.arteria_api.calculated_risk.mapping.CalculatedRiskMapper;
import com.agiletech.arteria_api.calculated_risk.resource.CalculatedRiskResource;
import com.agiletech.arteria_api.calculated_risk.resource.CreateCalculatedRiskResource;
import com.agiletech.arteria_api.calculated_risk.resource.UpdateCalculatedRiskResource;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Calculated Risk")
@RestController
@RequestMapping("api/v1/calculatedRisks")
@CrossOrigin
public class CalculatedRiskController {
    @Autowired
    private CalculatedRiskService calculatedRiskService;

    @Autowired
    private CalculatedRiskMapper calculatedRiskMapper;

    @Operation(summary = "Get All Calculated Risks", description = "Get All Calculated Risks")
    @GetMapping()
    public List<CalculatedRiskResource> getAll(){
        return calculatedRiskMapper.toResource(calculatedRiskService.getAll());
    }

    @Operation(summary = "Get Calculated Risk by Id", description = "Get Calculated Risk by Id")
    @GetMapping("{calculatedRiskId}")
    public CalculatedRiskResource getCalculatedRiskById(@PathVariable Long calculatedRiskId){
        return calculatedRiskMapper.toResource(calculatedRiskService.getById(calculatedRiskId));
    }

    @Operation(summary = "Create New Calculated Risk", description = "Create New Calculated Risk")
    @PostMapping("")
    public CalculatedRiskResource createCalculatedRisk(@RequestBody CreateCalculatedRiskResource model){
        return calculatedRiskMapper.toResource(calculatedRiskService.create(calculatedRiskMapper.toModel(model)));
    }

    @Operation(summary = "Update Calculated Risk", description = "Update Calculated Risk")
    @PutMapping("{calculatedRiskId}")
    public CalculatedRiskResource updateCalculatedRisk(@PathVariable Long calculatedRiskId, @RequestBody UpdateCalculatedRiskResource model){
        return calculatedRiskMapper.toResource(calculatedRiskService.update(calculatedRiskId, calculatedRiskMapper.toModel(model)));
    }
}
