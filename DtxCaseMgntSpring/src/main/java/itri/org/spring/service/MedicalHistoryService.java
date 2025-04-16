package itri.org.spring.service;

import itri.org.spring.model.MedicalHistory;
import java.util.List;
import java.util.Optional;

public interface MedicalHistoryService {
    /**
     * 保存病歷記錄
     * @param medicalHistory 病歷記錄
     * @return 保存後的病歷記錄
     */
    MedicalHistory saveMedicalHistory(MedicalHistory medicalHistory);
    
    /**
     * 根據ID查找病歷記錄
     * @param id 病歷記錄ID
     * @return 包含病歷記錄的Optional物件，若未找到則為空
     */
    Optional<MedicalHistory> findById(Long id);
    
    /**
     * 根據名稱查找病歷記錄
     * @param name 病歷名稱
     * @return 病歷記錄列表
     */
    List<MedicalHistory> findByName(String name);
    
    /**
     * 根據名稱包含特定文字查找病歷記錄
     * @param keyword 關鍵字
     * @return 病歷記錄列表
     */
    List<MedicalHistory> findByNameContaining(String keyword);
    
    /**
     * 獲取所有病歷記錄
     * @return 所有病歷記錄的列表
     */
    List<MedicalHistory> findAllMedicalHistories();
    
    /**
     * 刪除病歷記錄
     * @param id 病歷記錄ID
     */
    void deleteMedicalHistory(Long id);
}