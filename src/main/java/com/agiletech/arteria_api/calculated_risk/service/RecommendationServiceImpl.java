package com.agiletech.arteria_api.calculated_risk.service;

import com.agiletech.arteria_api.calculated_risk.domain.model.entity.CalculatedRisk;
import com.agiletech.arteria_api.calculated_risk.domain.model.entity.Recommendation;
import com.agiletech.arteria_api.calculated_risk.domain.persistence.CalculatedRiskRepository;
import com.agiletech.arteria_api.calculated_risk.domain.persistence.RecommendationRepository;
import com.agiletech.arteria_api.calculated_risk.domain.service.RecommendationService;
import com.agiletech.arteria_api.form.domain.model.entity.Form;
import com.agiletech.arteria_api.shared.exception.ResourceNotFoundException;
import com.agiletech.arteria_api.shared.exception.ResourceValidationException;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final static String ENTITY = "Recommendations";

    private final static String ENTITY2 = "Calculated Risks";

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private CalculatedRiskRepository calculatedRiskRepository;

    /*@Autowired
    private ChatgptService chatgptService;*/

    @Override
    public List<Recommendation> getAll() {
        return recommendationRepository.findAll();
    }

    @Override
    public Recommendation getById(Long recommendationId) {
        return recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, recommendationId));
    }

    @Override
    public Recommendation getByCalculatedRisk(Long calculatedRiskId) {
        return recommendationRepository.findByCalculatedRiskId(calculatedRiskId);
    }

    @Override
    public Recommendation create(Recommendation request, Long calculatedRiskId) {

        val length = request.getDescription().length();
        if (length >= 5000){
            throw new ResourceValidationException(ENTITY, "The recommendations cannot exceed 5000 characters.");
        }

        CalculatedRisk calculatedRisk = calculatedRiskRepository.findById(calculatedRiskId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, calculatedRiskId));
        request.setCalculatedRisk(calculatedRisk);

        return recommendationRepository.save(request);
    }

    @Override
    public Recommendation update(Long recommendationId, Recommendation request) {
        try {
            val length = request.getDescription().length();
            if (length >= 5000){
                throw new ResourceValidationException(ENTITY, "The recommendations cannot exceed 5000 characters.");
            }

            Recommendation recommendation = recommendationRepository.findById(recommendationId)
                    .orElseThrow(() -> new ResourceNotFoundException(ENTITY, recommendationId));
            recommendation.setDescription(request.getDescription());
            return recommendationRepository.save(recommendation);
        }
        catch (Exception e){
            throw new ResourceValidationException(e.getMessage());
        }
    }

    /*@Override
    public Recommendation createWithGpt(Long calculatedRiskId) {
        Recommendation request = new Recommendation();

        CalculatedRisk calculatedRisk = calculatedRiskRepository.findById(calculatedRiskId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, calculatedRiskId));
        request.setCalculatedRisk(calculatedRisk);

        ChatRequest chatRequest = getChatRequest(calculatedRisk);
        ChatResponse response = chatgptService.sendChatRequest(chatRequest);

        request.setDescription(response.toString());
        return recommendationRepository.save(request);
    }*/

    /*private static ChatRequest getChatRequest(CalculatedRisk calculatedRisk) {
        Integer maxTokens = 300;
        String model = "text-davinci-003";
        Double temperature = 0.5;
        Double topP = 1.0;

        Float eacProbability = calculatedRisk.getPrediction_probability();
        boolean eacPredictionClass = (calculatedRisk.getPredicted_class() != 0.0);

        Form form = calculatedRisk.getForm();

        String message = String.format(
                "Actúa como un asistente de un cardiólogo. Con los siguientes datos porcentuales de probabilidad de que un paciente específico tenga Enfermedad Arterial Coronaria (EAC), proporciona una lista de recomendaciones que debe tomar el paciente para cuidar su salud. " +
                        "La probabilidad de EAC es de %.2f%% y la predicción de clase de EAC es %s. " +
                        "Los datos del paciente son: " +
                        "Edad: %d años, Peso: %d kg, Talla: %d cm, Sexo: %s, IMC: %.2f, Diabetes: %s, Hipertensión: %s, Fumador actual: %s, Ex fumador: %s, Historia familiar: %s, Obesidad: %s, Enfermedad cerebrovascular: %s, Enfermedad tiroidea: %s, " +
                        "Presión arterial: %d mmHg, Frecuencia cardíaca: %d bpm, Pulso periférico débil: %s, Onda Q: %s, Elevación ST: %s, Depresión ST: %s, Inversión T: %s, Hipertrofia ventricular izquierda: %s, Progresión pobre R: %s, " +
                        "Triglicéridos: %d mg/dL, LDL: %d mg/dL, HDL: %.2f mg/dL, Hemoglobina: %.2f g/dL.",
                eacProbability * 100,
                eacPredictionClass ? "positiva" : "negativa",
                form.getAge(),
                form.getWeight(),
                form.getLength(),
                form.getSex(),
                form.getBmi(),
                form.getDm() != 0 ? "Sí" : "No",
                form.getHtn() != 0 ? "Sí" : "No",
                form.getCurrent_Smoker() != 0 ? "Sí" : "No",
                form.getEx_Smoker() != 0 ? "Sí" : "No",
                form.getFh() != 0 ? "Sí" : "No",
                form.getObesity() != 0 ? "Sí" : "No",
                form.getCva() != 0 ? "Sí" : "No",
                form.getThyroid_Disease() != 0 ? "Sí" : "No",
                form.getBp(),
                form.getPr(),
                form.getWeak_Peripheral_Pulse() != 0 ? "Sí" : "No",
                form.getQ_Wave() != 0 ? "Sí" : "No",
                form.getSt_Elevation() != 0 ? "Sí" : "No",
                form.getSt_Depression() != 0 ? "Sí" : "No",
                form.getTInversion() != 0 ? "Sí" : "No",
                form.getLvh() != 0 ? "Sí" : "No",
                form.getPoor_R_Progression() != 0 ? "Sí" : "No",
                form.getTg(),
                form.getLdl(),
                form.getHdl(),
                form.getHb()
        );
        ChatRequest chatRequest = new ChatRequest(model, message, maxTokens, temperature, topP);
        return chatRequest;
    }*/
}
