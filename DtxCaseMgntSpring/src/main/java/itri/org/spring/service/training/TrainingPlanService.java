package itri.org.spring.service.training;

import itri.org.spring.model.Patient;
import itri.org.spring.model.training.TrainingPlan;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingPlanService {
    /**
     * 儲存或更新訓練計畫
     * @param trainingPlan 要儲存的訓練計畫
     * @return 儲存後的訓練計畫
     */
    TrainingPlan saveTrainingPlan(TrainingPlan trainingPlan);
    
    /**
     * 依據ID查找訓練計畫
     * @param id 訓練計畫ID
     * @return 包含訓練計畫的Optional物件，若未找到則為空
     */
    Optional<TrainingPlan> findById(Long id);
    
    /**
     * 依據病患查找訓練計畫
     * @param patient 病患物件
     * @return 該病患的所有訓練計畫列表
     */
    List<TrainingPlan> findByPatient(Patient patient);
    
    /**
     * 依據治療師ID查找訓練計畫
     * @param therapistId 治療師ID
     * @return 該治療師的所有訓練計畫列表
     */
    List<TrainingPlan> findByTherapistId(Long therapistId);
    
    /**
     * 依據日期範圍查找訓練計畫
     * @param after 開始日期
     * @param before 結束日期
     * @return 該日期範圍內的所有訓練計畫列表
     */
    List<TrainingPlan> findByStartDateAfterAndEndDateBefore(Date after, Date before);
    
    /**
     * 依據病患和開始日期查找訓練計畫
     * @param patient 病患物件
     * @param date 開始日期
     * @return 符合條件的訓練計畫列表
     */
    List<TrainingPlan> findByPatientAndStartDateAfter(Patient patient, Date date);
    
    /**
     * 依據標題查找訓練計畫
     * @param title 標題關鍵字
     * @return 標題包含關鍵字的訓練計畫列表
     */
    List<TrainingPlan> findByTitleContaining(String title);
    
    /**
     * 查找所有訓練計畫
     * @return 所有訓練計畫列表
     */
    List<TrainingPlan> findAllTrainingPlans();
    
    /**
     * 依據ID刪除訓練計畫
     * @param id 訓練計畫ID
     */
    void deleteTrainingPlan(Long id);
}