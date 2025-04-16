package itri.org.spring.repository.healthinsurance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itri.org.spring.model.Patient;
import itri.org.spring.model.healthinsurance.HealthInsuranceRecord;

@Repository
public interface HealthInsuranceRecordRepository extends JpaRepository<HealthInsuranceRecord, Long> {
    
    // 根據患者查找所有健康保險記錄
    List<HealthInsuranceRecord> findByPatient(Patient patient);
    
    // 根據序列號查找記錄
    HealthInsuranceRecord findBySerialNum(String serialNum);
}