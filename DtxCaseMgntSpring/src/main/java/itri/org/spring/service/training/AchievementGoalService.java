package itri.org.spring.service.training;

import itri.org.spring.model.training.AchievementGoal;

import java.util.List;
import java.util.Optional;

public interface AchievementGoalService {
    /**
     * 儲存或更新成就目標
     * @param achievementGoal 要儲存的成就目標
     * @return 儲存後的成就目標
     */
    AchievementGoal saveAchievementGoal(AchievementGoal achievementGoal);
    
    /**
     * 依據ID查找成就目標
     * @param id 成就目標ID
     * @return 包含成就目標的Optional物件，若未找到則為空
     */
    Optional<AchievementGoal> findById(Long id);
    
    /**
     * 依據映射ID查找成就目標
     * @param mappingId 映射ID
     * @return 該映射ID的所有成就目標列表
     */
    List<AchievementGoal> findByMappingId(Long mappingId);
    
    /**
     * 依據API名稱查找成就目標
     * @param apiName API名稱關鍵字
     * @return API名稱包含關鍵字的成就目標列表
     */
    List<AchievementGoal> findByApiNameContaining(String apiName);
    
    /**
     * 查找所有成就目標
     * @return 所有成就目標列表
     */
    List<AchievementGoal> findAllAchievementGoals();
    
    /**
     * 依據ID刪除成就目標
     * @param id 成就目標ID
     */
    void deleteAchievementGoal(Long id);
}