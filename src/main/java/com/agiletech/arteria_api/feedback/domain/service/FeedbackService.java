package com.agiletech.arteria_api.feedback.domain.service;

import com.agiletech.arteria_api.feedback.domain.model.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAll();
    Feedback create(Feedback request, Long doctorId);

}
