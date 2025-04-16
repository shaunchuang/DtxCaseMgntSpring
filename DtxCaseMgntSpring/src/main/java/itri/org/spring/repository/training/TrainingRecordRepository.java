package itri.org.spring.repository.training;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import itri.org.spring.model.Patient;
import itri.org.spring.model.training.TrainingRecord;
import itri.org.spring.model.training.TrainingPlan;
import itri.org.spring.model.training.PlanLessonMapping;

@Repository
public interface TrainingRecordRepository extends JpaRepository<TrainingRecord, Long> {
    
    // 根據訓練計畫查找所有訓練記錄
    List<TrainingRecord> findByTrainingPlan(TrainingPlan trainingPlan);
    
    // 根據訓練計畫ID查找所有訓練記錄
    List<TrainingRecord> findByTrainingPlanId(Long trainingPlanId);
    
    // 根據患者查找所有訓練記錄
    List<TrainingRecord> findByPatient(Patient patient);
    
    // 根據患者ID查找所有訓練記錄
    List<TrainingRecord> findByPatientId(Long patientId);
    
    // 根據課程映射查找所有訓練記錄
    List<TrainingRecord> findByPlanLessonMapping(PlanLessonMapping planLessonMapping);
    
    // 根據課程映射ID查找所有訓練記錄
    List<TrainingRecord> findByPlanLessonMappingId(Long planLessonMappingId);
    
    // 根據訓練開始時間範圍查找
    List<TrainingRecord> findByTrainingStartTimeBetween(Date startDate, Date endDate);
    
    // 根據成功率範圍查找
    List<TrainingRecord> findBySuccessRateBetween(Double minRate, Double maxRate);
    
    // 查找特定患者在指定時間範圍內的訓練記錄
    List<TrainingRecord> findByPatientIdAndTrainingStartTimeBetween(Long patientId, Date startDate, Date endDate);
    
    // 查找特定計畫中成功率最高的記錄
    @Query("SELECT tr FROM TrainingRecord tr WHERE tr.trainingPlan.id = :planId ORDER BY tr.successRate DESC")
    List<TrainingRecord> findTopRecordsByPlanId(Long planId);
    
    // 查找最近的訓練記錄
    @Query("SELECT tr FROM TrainingRecord tr ORDER BY tr.createdAt DESC")
    List<TrainingRecord> findRecentRecords();
    
    // 根據成功率查找所有訓練記錄
    List<TrainingRecord> findBySuccessRateGreaterThan(Double successRate);
    
    // 查找特定患者在指定時間範圍內的訓練記錄
    List<TrainingRecord> findByPatientAndTrainingStartTimeBetween(Patient patient, Date start, Date end);
}