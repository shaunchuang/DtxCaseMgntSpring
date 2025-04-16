package itri.org.spring.service.training.impl;

import itri.org.spring.model.Patient;
import itri.org.spring.model.training.TrainingPlan;
import itri.org.spring.repository.training.TrainingPlanRepository;
import itri.org.spring.service.training.TrainingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainingPlanServiceImpl implements TrainingPlanService {

    private final TrainingPlanRepository trainingPlanRepository;

    @Autowired
    public TrainingPlanServiceImpl(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    @Override
    public TrainingPlan saveTrainingPlan(TrainingPlan trainingPlan) {
        return trainingPlanRepository.save(trainingPlan);
    }

    @Override
    public Optional<TrainingPlan> findById(Long id) {
        return trainingPlanRepository.findById(id);
    }

    @Override
    public List<TrainingPlan> findByPatient(Patient patient) {
        return trainingPlanRepository.findByPatient(patient);
    }

    @Override
    public List<TrainingPlan> findByTherapistId(Long therapistId) {
        return trainingPlanRepository.findByTherapistId(therapistId);
    }

    @Override
    public List<TrainingPlan> findByStartDateAfterAndEndDateBefore(Date after, Date before) {
        return trainingPlanRepository.findByStartDateAfterAndEndDateBefore(after, before);
    }

    @Override
    public List<TrainingPlan> findByPatientAndStartDateAfter(Patient patient, Date date) {
        return trainingPlanRepository.findByPatientAndStartDateAfter(patient, date);
    }

    @Override
    public List<TrainingPlan> findByTitleContaining(String title) {
        return trainingPlanRepository.findByTitleContaining(title);
    }

    @Override
    public List<TrainingPlan> findAllTrainingPlans() {
        return trainingPlanRepository.findAll();
    }

    @Override
    public void deleteTrainingPlan(Long id) {
        trainingPlanRepository.deleteById(id);
    }
}