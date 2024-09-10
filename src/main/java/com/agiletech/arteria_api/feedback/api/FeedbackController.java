package com.agiletech.arteria_api.feedback.api;

import com.agiletech.arteria_api.feedback.domain.service.FeedbackService;
import com.agiletech.arteria_api.feedback.mapping.FeedbackMapper;
import com.agiletech.arteria_api.feedback.resource.CreateFeedbackResource;
import com.agiletech.arteria_api.feedback.resource.FeedbackResource;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Feedback")
@RestController
@RequestMapping("api/v1/feedbacks")
@CrossOrigin()
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Operation(summary = "Get All Feedbacks", description = "Get All Feedbacks")
    @GetMapping()
    public List<FeedbackResource> getAll(){
        return feedbackMapper.toResource(feedbackService.getAll());
    }

    @Operation(summary = "Create New Patient", description = "Create New Patient")
    @PostMapping("doctor/{doctorId}")
    public FeedbackResource createPatient(@RequestBody CreateFeedbackResource model, @PathVariable Long doctorId){
        return feedbackMapper.toResource(feedbackService.create(feedbackMapper.toModel(model), doctorId));
    }
}
