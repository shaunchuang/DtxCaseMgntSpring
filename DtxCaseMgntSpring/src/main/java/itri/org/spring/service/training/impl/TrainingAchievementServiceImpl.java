package itri.org.spring.service.training.impl;

import itri.org.spring.model.training.TrainingAchievement;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.AchievementGoal;
import itri.org.spring.repository.training.TrainingAchievementRepository;
import itri.org.spring.service.training.TrainingAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainingAchievementServiceImpl implements TrainingAchievementService {

    private final TrainingAchievementRepository trainingAchievementRepository;

    @Autowired
    public TrainingAchievementServiceImpl(TrainingAchievementRepository trainingAchievementRepository) {
        this.trainingAchievementRepository = trainingAchievementRepository;
    }

    @Override
    public TrainingAchievement saveTrainingAchievement(TrainingAchievement trainingAchievement) {
        return trainingAchievementRepository.save(trainingAchievement);
    }

    @Override
    public Optional<TrainingAchievement> findById(Long id) {
        return trainingAchievementRepository.findById(id);
    }

    @Override
    public List<TrainingAchievement> findByTrainingRecord(TrainingRecord trainingRecord) {
        return trainingAchievementRepository.findByTrainingRecord(trainingRecord);
    }

    @Override
    public List<TrainingAchievement> findByAchievementGoal(AchievementGoal achievementGoal) {
        return trainingAchievementRepository.findByAchievementGoal(achievementGoal);
    }

    @Override
    public List<TrainingAchievement> findByIsUnlocked(boolean isUnlocked) {
        return trainingAchievementRepository.findByIsUnlocked(isUnlocked);
    }

    @Override
    public List<TrainingAchievement> findByUnlockTimeBetween(Date start, Date end) {
        return trainingAchievementRepository.findByUnlockTimeBetween(start, end);
    }

    @Override
    public List<TrainingAchievement> findByTrainingRecordAndAchievementGoal(TrainingRecord trainingRecord, AchievementGoal achievementGoal) {
        return trainingAchievementRepository.findByTrainingRecordAndAchievementGoal(trainingRecord, achievementGoal);
    }

    @Override
    public List<TrainingAchievement> findAllTrainingAchievements() {
        return trainingAchievementRepository.findAll();
    }

    @Override
    public void deleteTrainingAchievement(Long id) {
        trainingAchievementRepository.deleteById(id);
    }
}