package com.agiletech.arteria_api.feedback.domain.persistence;

import com.agiletech.arteria_api.feedback.domain.model.entity.Feedback;
import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
