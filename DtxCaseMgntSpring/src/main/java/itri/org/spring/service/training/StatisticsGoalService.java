package itri.org.spring.service.training;

import itri.org.spring.model.training.StatisticsGoal;

import java.util.List;
import java.util.Optional;

public interface StatisticsGoalService {
    /**
     * 儲存或更新統計目標
     * @param statisticsGoal 要儲存的統計目標
     * @return 儲存後的統計目標
     */
    StatisticsGoal saveStatisticsGoal(StatisticsGoal statisticsGoal);
    
    /**
     * 依據ID查找統計目標
     * @param id 統計目標ID
     * @return 包含統計目標的Optional物件，若未找到則為空
     */
    Optional<StatisticsGoal> findById(Long id);
    
    /**
     * 依據映射ID查找統計目標
     * @param mappingId 映射ID
     * @return 該映射ID的所有統計目標列表
     */
    List<StatisticsGoal> findByMappingId(Long mappingId);
    
    /**
     * 依據API名稱查找統計目標
     * @param apiName API名稱關鍵字
     * @return API名稱包含關鍵字的統計目標列表
     */
    List<StatisticsGoal> findByApiNameContaining(String apiName);
    
    /**
     * 依據目標值查找統計目標
     * @param valueGoal 目標值關鍵字
     * @return 目標值包含關鍵字的統計目標列表
     */
    List<StatisticsGoal> findByValueGoalContaining(String valueGoal);
    
    /**
     * 查找所有統計目標
     * @return 所有統計目標列表
     */
    List<StatisticsGoal> findAllStatisticsGoals();
    
    /**
     * 依據ID刪除統計目標
     * @param id 統計目標ID
     */
    void deleteStatisticsGoal(Long id);
}