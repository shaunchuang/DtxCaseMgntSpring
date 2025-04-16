package itri.org.spring.service.healthinsurance;

import itri.org.spring.model.Patient;
import itri.org.spring.model.healthinsurance.HealthInsuranceRecord;

import java.util.List;
import java.util.Optional;

public interface HealthInsuranceRecordService {
    /**
     * 儲存或更新健康保險記錄
     * @param healthInsuranceRecord 要儲存的健康保險記錄
     * @return 儲存後的健康保險記錄
     */
    HealthInsuranceRecord saveHealthInsuranceRecord(HealthInsuranceRecord healthInsuranceRecord);
    
    /**
     * 依據ID查找健康保險記錄
     * @param id 健康保險記錄ID
     * @return 包含健康保險記錄的Optional物件，若未找到則為空
     */
    Optional<HealthInsuranceRecord> findById(Long id);
    
    /**
     * 依據病患查找健康保險記錄
     * @param patient 病患物件
     * @return 該病患的所有健康保險記錄列表
     */
    List<HealthInsuranceRecord> findByPatient(Patient patient);
    
    /**
     * 依據序列號查找健康保險記錄
     * @param serialNum 序列號
     * @return 符合序列號的健康保險記錄
     */
    HealthInsuranceRecord findBySerialNum(String serialNum);
    
    /**
     * 查找所有健康保險記錄
     * @return 所有健康保險記錄列表
     */
    List<HealthInsuranceRecord> findAllHealthInsuranceRecords();
    
    /**
     * 依據ID刪除健康保險記錄
     * @param id 健康保險記錄ID
     */
    void deleteHealthInsuranceRecord(Long id);
}