package itri.org.spring.repository.training;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itri.org.spring.model.training.PlanLessonMapping;
import itri.org.spring.model.training.TrainingPlan;

@Repository
public interface PlanLessonMappingRepository extends JpaRepository<PlanLessonMapping, Long> {
    
    // 根據訓練計畫查找所有課程映射
    List<PlanLessonMapping> findByTrainingPlan(TrainingPlan trainingPlan);
    
    // 根據課程ID查找所有課程映射
    List<PlanLessonMapping> findByLessonId(Long lessonId);
    
    // 根據排序索引查找課程映射
    List<PlanLessonMapping> findByOrderIndex(Integer orderIndex);
    
    // 根據狀態查找課程映射
    List<PlanLessonMapping> findByStatus(String status);
    
    // 根據訓練計畫和排序索引查找課程映射
    List<PlanLessonMapping> findByTrainingPlanAndOrderIndexGreaterThanEqual(TrainingPlan trainingPlan, Integer orderIndex);
}