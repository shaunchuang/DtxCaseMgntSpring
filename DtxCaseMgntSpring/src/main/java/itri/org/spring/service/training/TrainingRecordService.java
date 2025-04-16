package itri.org.spring.service.training;

import itri.org.spring.model.Patient;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.TrainingPlan;
import itri.org.spring.model.training.PlanLessonMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingRecordService {
    /**
     * 儲存或更新訓練記錄
     * @param trainingRecord 要儲存的訓練記錄
     * @return 儲存後的訓練記錄
     */
    TrainingRecord saveTrainingRecord(TrainingRecord trainingRecord);
    
    /**
     * 依據ID查找訓練記錄
     * @param id 訓練記錄ID
     * @return 包含訓練記錄的Optional物件，若未找到則為空
     */
    Optional<TrainingRecord> findById(Long id);
    
    /**
     * 依據訓練計畫查找訓練記錄
     * @param trainingPlan 訓練計畫物件
     * @return 該訓練計畫的所有訓練記錄列表
     */
    List<TrainingRecord> findByTrainingPlan(TrainingPlan trainingPlan);
    
    /**
     * 依據病患查找訓練記錄
     * @param patient 病患物件
     * @return 該病患的所有訓練記錄列表
     */
    List<TrainingRecord> findByPatient(Patient patient);
    
    /**
     * 依據課程映射查找訓練記錄
     * @param planLessonMapping 課程映射物件
     * @return 該課程映射的所有訓練記錄列表
     */
    List<TrainingRecord> findByPlanLessonMapping(PlanLessonMapping planLessonMapping);
    
    /**
     * 依據訓練開始時間範圍查找訓練記錄
     * @param start 開始時間
     * @param end 結束時間
     * @return 該時間範圍內的所有訓練記錄列表
     */
    List<TrainingRecord> findByTrainingStartTimeBetween(Date start, Date end);
    
    /**
     * 依據病患和訓練開始時間範圍查找訓練記錄
     * @param patient 病患物件
     * @param start 開始時間
     * @param end 結束時間
     * @return 符合條件的訓練記錄列表
     */
    List<TrainingRecord> findByPatientAndTrainingStartTimeBetween(Patient patient, Date start, Date end);
    
    /**
     * 依據成功率查找訓練記錄
     * @param successRate 成功率閾值
     * @return 成功率大於指定值的訓練記錄列表
     */
    List<TrainingRecord> findBySuccessRateGreaterThan(Double successRate);
    
    /**
     * 查找所有訓練記錄
     * @return 所有訓練記錄列表
     */
    List<TrainingRecord> findAllTrainingRecords();
    
    /**
     * 依據ID刪除訓練記錄
     * @param id 訓練記錄ID
     */
    void deleteTrainingRecord(Long id);
}