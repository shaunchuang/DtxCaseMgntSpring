package itri.org.spring.repository.training;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itri.org.spring.model.training.TrainingAchievement;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.AchievementGoal;

@Repository
public interface TrainingAchievementRepository extends JpaRepository<TrainingAchievement, Long> {
    
    // 根據訓練記錄查找所有成就
    List<TrainingAchievement> findByTrainingRecord(TrainingRecord trainingRecord);
    
    // 根據成就目標查找所有成就
    List<TrainingAchievement> findByAchievementGoal(AchievementGoal achievementGoal);
    
    // 根據解鎖狀態查找成就
    List<TrainingAchievement> findByIsUnlocked(boolean isUnlocked);
    
    // 根據解鎖時間範圍查找成就
    List<TrainingAchievement> findByUnlockTimeBetween(Date start, Date end);
    
    // 根據訓練記錄和成就目標查找成就
    List<TrainingAchievement> findByTrainingRecordAndAchievementGoal(TrainingRecord trainingRecord, AchievementGoal achievementGoal);
}