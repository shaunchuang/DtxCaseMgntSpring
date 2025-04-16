package itri.org.spring.service.training;

import itri.org.spring.model.training.PlanLessonMapping;
import itri.org.spring.model.training.TrainingPlan;

import java.util.List;
import java.util.Optional;

public interface PlanLessonMappingService {
    /**
     * 儲存或更新計畫課程映射
     * @param planLessonMapping 要儲存的計畫課程映射
     * @return 儲存後的計畫課程映射
     */
    PlanLessonMapping savePlanLessonMapping(PlanLessonMapping planLessonMapping);
    
    /**
     * 依據ID查找計畫課程映射
     * @param id 計畫課程映射ID
     * @return 包含計畫課程映射的Optional物件，若未找到則為空
     */
    Optional<PlanLessonMapping> findById(Long id);
    
    /**
     * 依據訓練計畫查找計畫課程映射
     * @param trainingPlan 訓練計畫物件
     * @return 該訓練計畫的所有計畫課程映射列表
     */
    List<PlanLessonMapping> findByTrainingPlan(TrainingPlan trainingPlan);
    
    /**
     * 依據課程ID查找計畫課程映射
     * @param lessonId 課程ID
     * @return 該課程ID的所有計畫課程映射列表
     */
    List<PlanLessonMapping> findByLessonId(Long lessonId);
    
    /**
     * 依據順序索引查找計畫課程映射
     * @param orderIndex 順序索引
     * @return 該順序索引的所有計畫課程映射列表
     */
    List<PlanLessonMapping> findByOrderIndex(Integer orderIndex);
    
    /**
     * 依據狀態查找計畫課程映射
     * @param status 狀態
     * @return 該狀態的所有計畫課程映射列表
     */
    List<PlanLessonMapping> findByStatus(String status);
    
    /**
     * 依據訓練計畫和順序索引查找計畫課程映射
     * @param trainingPlan 訓練計畫物件
     * @param orderIndex 順序索引
     * @return 該訓練計畫和順序索引的所有計畫課程映射列表
     */
    List<PlanLessonMapping> findByTrainingPlanAndOrderIndexGreaterThanEqual(TrainingPlan trainingPlan, Integer orderIndex);
    
    /**
     * 查找所有計畫課程映射
     * @return 所有計畫課程映射列表
     */
    List<PlanLessonMapping> findAllPlanLessonMappings();
    
    /**
     * 依據ID刪除計畫課程映射
     * @param id 計畫課程映射ID
     */
    void deletePlanLessonMapping(Long id);
}