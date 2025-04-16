package itri.org.spring.service.training.impl;

import itri.org.spring.model.Patient;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.TrainingPlan;
import itri.org.spring.model.training.PlanLessonMapping;
import itri.org.spring.repository.training.TrainingRecordRepository;
import itri.org.spring.service.training.TrainingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainingRecordServiceImpl implements TrainingRecordService {

    private final TrainingRecordRepository trainingRecordRepository;

    @Autowired
    public TrainingRecordServiceImpl(TrainingRecordRepository trainingRecordRepository) {
        this.trainingRecordRepository = trainingRecordRepository;
    }

    @Override
    public TrainingRecord saveTrainingRecord(TrainingRecord trainingRecord) {
        return trainingRecordRepository.save(trainingRecord);
    }

    @Override
    public Optional<TrainingRecord> findById(Long id) {
        return trainingRecordRepository.findById(id);
    }

    @Override
    public List<TrainingRecord> findByTrainingPlan(TrainingPlan trainingPlan) {
        return trainingRecordRepository.findByTrainingPlan(trainingPlan);
    }

    @Override
    public List<TrainingRecord> findByPatient(Patient patient) {
        return trainingRecordRepository.findByPatient(patient);
    }

    @Override
    public List<TrainingRecord> findByPlanLessonMapping(PlanLessonMapping planLessonMapping) {
        return trainingRecordRepository.findByPlanLessonMapping(planLessonMapping);
    }

    @Override
    public List<TrainingRecord> findByTrainingStartTimeBetween(Date start, Date end) {
        return trainingRecordRepository.findByTrainingStartTimeBetween(start, end);
    }

    @Override
    public List<TrainingRecord> findByPatientAndTrainingStartTimeBetween(Patient patient, Date start, Date end) {
        return trainingRecordRepository.findByPatientAndTrainingStartTimeBetween(patient, start, end);
    }

    @Override
    public List<TrainingRecord> findBySuccessRateGreaterThan(Double successRate) {
        return trainingRecordRepository.findBySuccessRateGreaterThan(successRate);
    }

    @Override
    public List<TrainingRecord> findAllTrainingRecords() {
        return trainingRecordRepository.findAll();
    }

    @Override
    public void deleteTrainingRecord(Long id) {
        trainingRecordRepository.deleteById(id);
    }
}