package itri.org.spring.service.healthinsurance;

import itri.org.spring.model.healthinsurance.MedicalServicePaymentItem;

import java.util.List;
import java.util.Optional;

public interface MedicalServicePaymentItemService {
    /**
     * 儲存或更新醫療服務給付項目
     * @param medicalServicePaymentItem 要儲存的醫療服務給付項目
     * @return 儲存後的醫療服務給付項目
     */
    MedicalServicePaymentItem saveMedicalServicePaymentItem(MedicalServicePaymentItem medicalServicePaymentItem);
    
    /**
     * 依據ID查找醫療服務給付項目
     * @param id 醫療服務給付項目ID
     * @return 包含醫療服務給付項目的Optional物件，若未找到則為空
     */
    Optional<MedicalServicePaymentItem> findById(Long id);
    
    /**
     * 依據代碼查找醫療服務給付項目
     * @param code 代碼
     * @return 包含醫療服務給付項目的Optional物件，若未找到則為空
     */
    Optional<MedicalServicePaymentItem> findByCode(String code);
    
    /**
     * 依據中文項目名稱搜尋醫療服務給付項目
     * @param zhItem 中文項目名稱關鍵字
     * @return 符合搜尋條件的醫療服務給付項目列表
     */
    List<MedicalServicePaymentItem> findByZhItemContaining(String zhItem);
    
    /**
     * 依據英文項目名稱搜尋醫療服務給付項目
     * @param enItem 英文項目名稱關鍵字
     * @return 符合搜尋條件的醫療服務給付項目列表
     */
    List<MedicalServicePaymentItem> findByEnItemContaining(String enItem);
    
    /**
     * 依據點數查找醫療服務給付項目
     * @param points 點數閾值
     * @return 點數大於等於指定值的醫療服務給付項目列表
     */
    List<MedicalServicePaymentItem> findByPointsGreaterThanEqual(int points);
    
    /**
     * 查找未被刪除的醫療服務給付項目
     * @return 未被刪除的醫療服務給付項目列表
     */
    List<MedicalServicePaymentItem> findByDeleteMarkFalse();
    
    /**
     * 查找所有醫療服務給付項目
     * @return 所有醫療服務給付項目列表
     */
    List<MedicalServicePaymentItem> findAllMedicalServicePaymentItems();
    
    /**
     * 依據ID刪除醫療服務給付項目
     * @param id 醫療服務給付項目ID
     */
    void deleteMedicalServicePaymentItem(Long id);
    
    /**
     * 標記醫療服務給付項目為已刪除
     * @param id 醫療服務給付項目ID
     * @return 更新後的醫療服務給付項目
     */
    MedicalServicePaymentItem markAsDeleted(Long id);
}