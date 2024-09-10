package com.agiletech.arteria_api.feedback.service;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.doctor.domain.persistence.DoctorRepository;
import com.agiletech.arteria_api.feedback.domain.model.entity.Feedback;
import com.agiletech.arteria_api.feedback.domain.persistence.FeedbackRepository;
import com.agiletech.arteria_api.feedback.domain.service.FeedbackService;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final static String ENTITY = "Doctor";

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;


    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback create(Feedback request, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, doctorId));

        request.setDoctor(doctor);

        return feedbackRepository.save(request);
    }
}
