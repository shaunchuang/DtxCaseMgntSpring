package itri.org.spring.service;

import itri.org.spring.model.HistoryDisease;
import java.util.List;
import java.util.Optional;

public interface HistoryDiseaseService {
    /**
     * 保存病史記錄
     * @param historyDisease 病史記錄
     * @return 保存後的病史記錄
     */
    HistoryDisease saveHistoryDisease(HistoryDisease historyDisease);
    
    /**
     * 根據ID查找病史記錄
     * @param id 病史記錄ID
     * @return 包含病史記錄的Optional物件，若未找到則為空
     */
    Optional<HistoryDisease> findById(Long id);
    
    /**
     * 根據疾病名稱查找病史記錄
     * @param name 疾病名稱
     * @return 病史記錄列表
     */
    List<HistoryDisease> findByName(String name);
    
    /**
     * 根據疾病名稱包含特定文字查找病史記錄
     * @param keyword 關鍵字
     * @return 病史記錄列表
     */
    List<HistoryDisease> findByNameContaining(String keyword);
    
    /**
     * 獲取所有病史記錄
     * @return 所有病史記錄的列表
     */
    List<HistoryDisease> findAllHistoryDiseases();
    
    /**
     * 刪除病史記錄
     * @param id 病史記錄ID
     */
    void deleteHistoryDisease(Long id);
}