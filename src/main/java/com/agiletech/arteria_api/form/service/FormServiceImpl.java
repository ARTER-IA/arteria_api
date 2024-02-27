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
                        .withHeight(request.getHeight())
                        .withWeight(request.getWeight())
                        .withImc(request.getImc())
                        .withAge(request.getAge())
                        .withGender(request.getGender())
                        .withSmoking(request.getSmoking())
                        .withAlcoholism(request.getAlcoholism())
                        .withSedentaryLifestyle(request.getSedentaryLifestyle())
                        .withFamilyHistoryOfEcv(request.getFamilyHistoryOfEcv())
                        .withDiabetesMellitus(request.getDiabetesMellitus())
                        .withObesity(request.getObesity())
                        .withBloodPressure(request.getBloodPressure())
                        .withCoronaryCalcium(request.getCoronaryCalcium())
                        .withTriglycerides(request.getTriglycerides())
                        .withCholesterolTotal(request.getCholesterolTotal())
                        .withCLDL(request.getCLDL())
                        .withCHDL(request.getCHDL())
                        .withCReactiveProtein(request.getCReactiveProtein())
                        .withHeartRate(request.getHeartRate())
                        .withStSegment(request.getStSegment())
                        .withQtInterval(request.getQtInterval())
                        .withElectricShaft(request.getElectricShaft())
                        .withRrInterval(request.getRrInterval())
                        .withQrsComplex(request.getQrsComplex())
                        .withQrsComplex(request.getQrsComplex())
                        .withTWave(request.getTWave())
                        .withPrSegmentAnomalies(request.getPrSegmentAnomalies())
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
