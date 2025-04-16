package itri.org.spring.service.training;

import itri.org.spring.model.training.TrainingAchievement;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.AchievementGoal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingAchievementService {
    /**
     * 儲存或更新訓練成就
     * @param trainingAchievement 要儲存的訓練成就
     * @return 儲存後的訓練成就
     */
    TrainingAchievement saveTrainingAchievement(TrainingAchievement trainingAchievement);
    
    /**
     * 依據ID查找訓練成就
     * @param id 訓練成就ID
     * @return 包含訓練成就的Optional物件，若未找到則為空
     */
    Optional<TrainingAchievement> findById(Long id);
    
    /**
     * 依據訓練記錄查找訓練成就
     * @param trainingRecord 訓練記錄物件
     * @return 該訓練記錄的所有訓練成就列表
     */
    List<TrainingAchievement> findByTrainingRecord(TrainingRecord trainingRecord);
    
    /**
     * 依據成就目標查找訓練成就
     * @param achievementGoal 成就目標物件
     * @return 該成就目標的所有訓練成就列表
     */
    List<TrainingAchievement> findByAchievementGoal(AchievementGoal achievementGoal);
    
    /**
     * 依據解鎖狀態查找訓練成就
     * @param isUnlocked 解鎖狀態
     * @return 符合解鎖狀態的訓練成就列表
     */
    List<TrainingAchievement> findByIsUnlocked(boolean isUnlocked);
    
    /**
     * 依據解鎖時間範圍查找訓練成就
     * @param start 開始時間
     * @param end 結束時間
     * @return 該時間範圍內解鎖的訓練成就列表
     */
    List<TrainingAchievement> findByUnlockTimeBetween(Date start, Date end);
    
    /**
     * 依據訓練記錄和成就目標查找訓練成就
     * @param trainingRecord 訓練記錄物件
     * @param achievementGoal 成就目標物件
     * @return 符合條件的訓練成就列表
     */
    List<TrainingAchievement> findByTrainingRecordAndAchievementGoal(TrainingRecord trainingRecord, AchievementGoal achievementGoal);
    
    /**
     * 查找所有訓練成就
     * @return 所有訓練成就列表
     */
    List<TrainingAchievement> findAllTrainingAchievements();
    
    /**
     * 依據ID刪除訓練成就
     * @param id 訓練成就ID
     */
    void deleteTrainingAchievement(Long id);
}