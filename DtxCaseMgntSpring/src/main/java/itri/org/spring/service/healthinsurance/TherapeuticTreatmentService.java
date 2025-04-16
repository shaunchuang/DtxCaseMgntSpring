package itri.org.spring.service.healthinsurance;

import itri.org.spring.model.healthinsurance.TherapeuticTreatment;
import itri.org.spring.model.healthinsurance.HealthInsuranceRecord;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TherapeuticTreatmentService {
    /**
     * 儲存或更新治療記錄
     * @param therapeuticTreatment 要儲存的治療記錄
     * @return 儲存後的治療記錄
     */
    TherapeuticTreatment saveTherapeuticTreatment(TherapeuticTreatment therapeuticTreatment);
    
    /**
     * 依據ID查找治療記錄
     * @param id 治療記錄ID
     * @return 包含治療記錄的Optional物件，若未找到則為空
     */
    Optional<TherapeuticTreatment> findById(Long id);
    
    /**
     * 依據健康保險記錄查找治療記錄
     * @param hiRecord 健康保險記錄物件
     * @return 該健康保險記錄的所有治療記錄列表
     */
    List<TherapeuticTreatment> findByHiRecord(HealthInsuranceRecord hiRecord);
    
    /**
     * 依據治療代碼查找治療記錄
     * @param treatmentCode 治療代碼
     * @return 該治療代碼的所有治療記錄列表
     */
    List<TherapeuticTreatment> findByTreatmentCode(String treatmentCode);
    
    /**
     * 依據執行者ID查找治療記錄
     * @param executiveId 執行者ID
     * @return 該執行者的所有治療記錄列表
     */
    List<TherapeuticTreatment> findByExecutiveId(Long executiveId);
    
    /**
     * 依據點數查找治療記錄
     * @param point 點數
     * @return 符合點數的所有治療記錄列表
     */
    List<TherapeuticTreatment> findByPoint(int point);
    
    /**
     * 依據時間範圍查找治療記錄
     * @param startTime 開始時間
     * @param endTime 結束時間
     * @return 該時間範圍內的所有治療記錄列表
     */
    List<TherapeuticTreatment> findByStartTimeBetween(Date startTime, Date endTime);
    
    /**
     * 查找所有治療記錄
     * @return 所有治療記錄列表
     */
    List<TherapeuticTreatment> findAllTherapeuticTreatments();
    
    /**
     * 依據ID刪除治療記錄
     * @param id 治療記錄ID
     */
    void deleteTherapeuticTreatment(Long id);
}