package itri.org.spring.service.training.impl;

import itri.org.spring.model.training.TrainingStatistics;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.StatisticsGoal;
import itri.org.spring.repository.training.TrainingStatisticsRepository;
import itri.org.spring.service.training.TrainingStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainingStatisticsServiceImpl implements TrainingStatisticsService {

    private final TrainingStatisticsRepository trainingStatisticsRepository;

    @Autowired
    public TrainingStatisticsServiceImpl(TrainingStatisticsRepository trainingStatisticsRepository) {
        this.trainingStatisticsRepository = trainingStatisticsRepository;
    }

    @Override
    public TrainingStatistics saveTrainingStatistics(TrainingStatistics trainingStatistics) {
        return trainingStatisticsRepository.save(trainingStatistics);
    }

    @Override
    public Optional<TrainingStatistics> findById(Long id) {
        return trainingStatisticsRepository.findById(id);
    }

    @Override
    public List<TrainingStatistics> findByTrainingRecord(TrainingRecord trainingRecord) {
        return trainingStatisticsRepository.findByTrainingRecord(trainingRecord);
    }

    @Override
    public List<TrainingStatistics> findByStatisticsGoal(StatisticsGoal statisticsGoal) {
        return trainingStatisticsRepository.findByStatisticsGoal(statisticsGoal);
    }

    @Override
    public List<TrainingStatistics> findByStatValueGreaterThan(Double statValue) {
        return trainingStatisticsRepository.findByStatValueGreaterThan(statValue);
    }

    @Override
    public List<TrainingStatistics> findByTrainingRecordAndStatisticsGoal(TrainingRecord trainingRecord, StatisticsGoal statisticsGoal) {
        return trainingStatisticsRepository.findByTrainingRecordAndStatisticsGoal(trainingRecord, statisticsGoal);
    }

    @Override
    public List<TrainingStatistics> findAllTrainingStatistics() {
        return trainingStatisticsRepository.findAll();
    }

    @Override
    public void deleteTrainingStatistics(Long id) {
        trainingStatisticsRepository.deleteById(id);
    }
}