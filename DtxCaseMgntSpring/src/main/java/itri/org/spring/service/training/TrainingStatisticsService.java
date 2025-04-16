package itri.org.spring.service.training;

import itri.org.spring.model.training.TrainingStatistics;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.StatisticsGoal;

import java.util.List;
import java.util.Optional;

public interface TrainingStatisticsService {
    /**
     * 儲存或更新訓練統計
     * @param trainingStatistics 要儲存的訓練統計
     * @return 儲存後的訓練統計
     */
    TrainingStatistics saveTrainingStatistics(TrainingStatistics trainingStatistics);
    
    /**
     * 依據ID查找訓練統計
     * @param id 訓練統計ID
     * @return 包含訓練統計的Optional物件，若未找到則為空
     */
    Optional<TrainingStatistics> findById(Long id);
    
    /**
     * 依據訓練記錄查找訓練統計
     * @param trainingRecord 訓練記錄物件
     * @return 該訓練記錄的所有訓練統計列表
     */
    List<TrainingStatistics> findByTrainingRecord(TrainingRecord trainingRecord);
    
    /**
     * 依據統計目標查找訓練統計
     * @param statisticsGoal 統計目標物件
     * @return 該統計目標的所有訓練統計列表
     */
    List<TrainingStatistics> findByStatisticsGoal(StatisticsGoal statisticsGoal);
    
    /**
     * 依據統計值查找訓練統計
     * @param statValue 統計值閾值
     * @return 統計值大於指定值的訓練統計列表
     */
    List<TrainingStatistics> findByStatValueGreaterThan(Double statValue);
    
    /**
     * 依據訓練記錄和統計目標查找訓練統計
     * @param trainingRecord 訓練記錄物件
     * @param statisticsGoal 統計目標物件
     * @return 符合條件的訓練統計列表
     */
    List<TrainingStatistics> findByTrainingRecordAndStatisticsGoal(TrainingRecord trainingRecord, StatisticsGoal statisticsGoal);
    
    /**
     * 查找所有訓練統計
     * @return 所有訓練統計列表
     */
    List<TrainingStatistics> findAllTrainingStatistics();
    
    /**
     * 依據ID刪除訓練統計
     * @param id 訓練統計ID
     */
    void deleteTrainingStatistics(Long id);
}