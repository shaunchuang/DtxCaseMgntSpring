package itri.org.spring.service;

import itri.org.spring.model.Patient;
import itri.org.spring.model.HistoryDisease;
import itri.org.spring.model.MedicalHistory;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    /**
     * 保存個案資料
     * @param patient 個案
     * @return 保存後的個案資料
     */
    Patient savePatient(Patient patient);
    
    /**
     * 根據ID查找個案
     * @param id 個案ID
     * @return 包含個案的Optional物件，若未找到則為空
     */
    Optional<Patient> findById(Long id);
    
    /**
     * 根據身分證號碼查找個案
     * @param idno 身分證號碼
     * @return 包含個案的Optional物件，若未找到則為空
     */
    Optional<Patient> findByIdno(String idno);
    
    /**
     * 根據名稱查找個案
     * @param name 姓名
     * @return 個案列表
     */
    List<Patient> findByName(String name);
    
    /**
     * 根據名稱包含特定文字查找個案
     * @param keyword 關鍵字
     * @return 個案列表
     */
    List<Patient> findByNameContaining(String keyword);
    
    /**
     * 根據性別查找個案
     * @param gender 性別
     * @return 個案列表
     */
    List<Patient> findByGender(String gender);
    
    /**
     * 根據城市查找個案
     * @param city 城市
     * @return 個案列表
     */
    List<Patient> findByCity(String city);
    
    /**
     * 根據地區查找個案
     * @param district 地區
     * @return 個案列表
     */
    List<Patient> findByDistrict(String district);
    
    /**
     * 根據生日區間查找個案
     * @param start 開始日期
     * @param end 結束日期
     * @return 個案列表
     */
    List<Patient> findByBirthBetween(Date start, Date end);
    
    /**
     * 新增疾病史至個案
     * @param patientId 個案ID
     * @param diseaseId 疾病史ID
     * @return 更新後的個案資料
     */
    Patient addHistoryDisease(Long patientId, Long diseaseId);
    
    /**
     * 從個案移除疾病史
     * @param patientId 個案ID
     * @param diseaseId 疾病史ID
     * @return 更新後的個案資料
     */
    Patient removeHistoryDisease(Long patientId, Long diseaseId);
    
    /**
     * 獲取個案的所有疾病史
     * @param patientId 個案ID
     * @return 疾病史列表
     */
    List<HistoryDisease> getHistoryDiseases(Long patientId);
    
    /**
     * 新增病歷至個案
     * @param patientId 個案ID
     * @param medicalHistoryId 病歷ID
     * @return 更新後的個案資料
     */
    Patient addMedicalHistory(Long patientId, Long medicalHistoryId);
    
    /**
     * 從個案移除病歷
     * @param patientId 個案ID
     * @param medicalHistoryId 病歷ID
     * @return 更新後的個案資料
     */
    Patient removeMedicalHistory(Long patientId, Long medicalHistoryId);
    
    /**
     * 獲取個案的所有病歷
     * @param patientId 個案ID
     * @return 病歷列表
     */
    List<MedicalHistory> getMedicalHistories(Long patientId);
    
    /**
     * 獲取所有個案
     * @return 所有個案的列表
     */
    List<Patient> findAllPatients();
    
    /**
     * 刪除個案
     * @param id 個案ID
     */
    void deletePatient(Long id);
}