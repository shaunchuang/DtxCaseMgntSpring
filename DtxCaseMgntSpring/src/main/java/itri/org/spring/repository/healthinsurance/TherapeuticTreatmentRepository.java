package itri.org.spring.repository.healthinsurance;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import itri.org.spring.model.healthinsurance.TherapeuticTreatment;
import itri.org.spring.model.healthinsurance.HealthInsuranceRecord;

@Repository
public interface TherapeuticTreatmentRepository extends JpaRepository<TherapeuticTreatment, Long> {
    
    // 根據健康保險記錄查找所有治療
    List<TherapeuticTreatment> findByHiRecord(HealthInsuranceRecord hiRecord);
    
    // 根據治療代碼查找治療
    List<TherapeuticTreatment> findByTreatmentCode(String treatmentCode);
    
    // 根據執行者ID查找治療
    List<TherapeuticTreatment> findByExecutiveId(Long executiveId);
    
    // 根據點數查找治療
    List<TherapeuticTreatment> findByPoint(int point);
    
    // 根據時間範圍查找治療
    List<TherapeuticTreatment> findByStartTimeBetween(Date startTime, Date endTime);
    
    // 查找特定執行者在某時間段的治療
    List<TherapeuticTreatment> findByExecutiveIdAndStartTimeBetween(Long executiveId, Date startTime, Date endTime);
    
    // 查找特定健康保險記錄中點數最高的治療
    @Query("SELECT tt FROM TherapeuticTreatment tt WHERE tt.hiRecord.id = :recordId ORDER BY tt.point DESC")
    List<TherapeuticTreatment> findTopPointTreatmentsByRecordId(Long recordId);
}