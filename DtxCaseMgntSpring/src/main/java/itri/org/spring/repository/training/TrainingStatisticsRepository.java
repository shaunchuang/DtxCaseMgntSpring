package itri.org.spring.repository.training;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itri.org.spring.model.training.TrainingStatistics;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.StatisticsGoal;

@Repository
public interface TrainingStatisticsRepository extends JpaRepository<TrainingStatistics, Long> {
    
    // 根據訓練記錄查找所有統計數據
    List<TrainingStatistics> findByTrainingRecord(TrainingRecord trainingRecord);
    
    // 根據訓練記錄ID查找所有統計數據
    List<TrainingStatistics> findByTrainingRecordId(Long trainingRecordId);
    
    // 根據統計目標查找所有統計數據
    List<TrainingStatistics> findByStatisticsGoal(StatisticsGoal statisticsGoal);
    
    // 根據統計目標ID查找所有統計數據
    List<TrainingStatistics> findByStatisticsGoalId(Long statisticsGoalId);
    
    // 根據統計值範圍查找
    List<TrainingStatistics> findByStatValueBetween(Double minValue, Double maxValue);

    // 根據統計值大於查找
    List<TrainingStatistics> findByStatValueGreaterThan(Double statValue);

    // 根據訓練記錄和統計目標查找
    List<TrainingStatistics> findByTrainingRecordAndStatisticsGoal(TrainingRecord trainingRecord, StatisticsGoal statisticsGoal);
}