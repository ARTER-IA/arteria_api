package com.agiletech.arteria_api.form.service;

import com.agiletech.arteria_api.doctor.domain.model.entity.Doctor;
import com.agiletech.arteria_api.doctor.domain.persistence.DoctorRepository;
import com.agiletech.arteria_api.form.domain.model.entity.Form;
import com.agiletech.arteria_api.form.domain.persistence.FormRepository;
import com.agiletech.arteria_api.form.domain.service.FormService;
import com.agiletech.arteria_api.patient.domain.model.entity.Patient;
import com.agiletech.arteria_api.patient.domain.persistence.PatientRepository;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    private final static String ENTITY = "Form";

    private final FormRepository formRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public FormServiceImpl(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    public List<Form> getAll() {
        return formRepository.findAll();
    }

    @Override
    public Form getById(Long formId) {
        return formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, formId));
    }

    @Override
    public Form getByCalculatedRiskId(Long calculatedRiskId) {
        return formRepository.findByCalculatedRiskId(calculatedRiskId);
    }

    @Override
    public Form create(Form request, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with Id " + doctorId));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with Id " + patientId));
        request.setDoctor(doctor);
        request.setPatient(patient);
        return formRepository.save(request);
    }

    @Override
    public Form update(Long formId, Form request) {
        return formRepository.findById(formId).map(form ->
                formRepository.save(form
                        .withAge(request.getAge())
                        .withWeight(request.getWeight())
                        .withLength(request.getLength())
                        .withSex(request.getSex())
                        .withBmi(request.getBmi())
                        .withDm(request.getDm())
                        .withHtn(request.getHtn())
                        .withCurrent_Smoker(request.getCurrent_Smoker())
                        .withEx_Smoker(request.getEx_Smoker())
                        .withFh(request.getFh())
                        .withObesity(request.getObesity())
                        .withCva(request.getCva())
                        .withThyroid_Disease(request.getThyroid_Disease())
                        .withBp(request.getBp())
                        .withPr(request.getPr())
                        .withWeak_Peripheral_Pulse(request.getWeak_Peripheral_Pulse())
                        .withQ_Wave(request.getQ_Wave())
                        .withSt_Elevation(request.getSt_Elevation())
                        .withSt_Depression(request.getSt_Depression())
                        .withTInversion(request.getTInversion())
                        .withLvh(request.getLvh())
                        .withPoor_R_Progression(request.getPoor_R_Progression())
                        .withTg(request.getTg())
                        .withLdl(request.getLdl())
                        .withHdl(request.getHdl())
                        .withHb(request.getHb())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, formId));
    }

    @Override
    public List<Form> getByDoctorId(Long doctorId) {
        return formRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Form> getByPatientId(Long patientId) {
        return formRepository.findByPatientId(patientId);
    }

    @Override
    public List<Form> getByDoctorIdAndPatientId(Long doctorId, Long patientId) {
        return formRepository.findByDoctorIdAndPatientId(doctorId, patientId);
    }
}
