package itri.org.spring.repository.training;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import itri.org.spring.model.Patient;
import itri.org.spring.model.training.TrainingPlan;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {
    
    // 根據治療師ID查找所有訓練計畫
    List<TrainingPlan> findByTherapistId(Long therapistId);
    
    // 根據患者查找所有訓練計畫
    List<TrainingPlan> findByPatient(Patient patient);
    
    // 根據患者ID查找所有訓練計畫
    List<TrainingPlan> findByPatientId(Long patientId);
    
    // 根據計畫標題模糊查詢
    List<TrainingPlan> findByTitleContaining(String titleKeyword);
    
    // 根據日期範圍查找有效的訓練計畫
    List<TrainingPlan> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date endDate, Date startDate);
    
    // 查找在指定日期區間內的訓練計畫
    @Query("SELECT tp FROM TrainingPlan tp WHERE tp.startDate <= :endDate AND tp.endDate >= :startDate")
    List<TrainingPlan> findOverlappingPlans(Date startDate, Date endDate);
    
    // 查找特定患者的活躍訓練計畫（當前日期在開始和結束日期之間）
    @Query("SELECT tp FROM TrainingPlan tp WHERE tp.patient.id = :patientId AND tp.startDate <= CURRENT_DATE AND tp.endDate >= CURRENT_DATE")
    List<TrainingPlan> findActiveTrainingPlansByPatientId(Long patientId);

    // 根據日期範圍查找訓練計畫
    List<TrainingPlan> findByStartDateAfterAndEndDateBefore(Date after, Date before);

    // 根據患者和日期查找訓練計畫
    List<TrainingPlan> findByPatientAndStartDateAfter(Patient patient, Date date);
}