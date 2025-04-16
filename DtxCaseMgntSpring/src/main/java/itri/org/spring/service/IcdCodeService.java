package itri.org.spring.service;

import itri.org.spring.model.IcdCode;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IcdCodeService {
    /**
     * 保存ICD代碼
     * @param icdCode ICD代碼
     * @return 保存後的ICD代碼
     */
    IcdCode saveIcdCode(IcdCode icdCode);
    
    /**
     * 根據ID查找ICD代碼
     * @param id ICD代碼ID
     * @return 包含ICD代碼的Optional物件，若未找到則為空
     */
    Optional<IcdCode> findById(Long id);
    
    /**
     * 根據代碼查找ICD代碼
     * @param code 代碼
     * @return ICD代碼列表
     */
    List<IcdCode> findByCode(String code);
    
    /**
     * 根據純代碼查找ICD代碼
     * @param pureCode 純代碼
     * @return ICD代碼列表
     */
    List<IcdCode> findByPureCode(String pureCode);
    
    /**
     * 根據中文名稱查找ICD代碼
     * @param name 中文名稱
     * @return ICD代碼列表
     */
    List<IcdCode> findByName(String name);
    
    /**
     * 根據英文名稱查找ICD代碼
     * @param enName 英文名稱
     * @return ICD代碼列表
     */
    List<IcdCode> findByEnName(String enName);
    
    /**
     * 根據名稱或代碼包含關鍵字查找ICD代碼
     * @param keyword 關鍵字
     * @return ICD代碼列表
     */
    List<IcdCode> findByKeyword(String keyword);
    
    /**
     * 獲取所有未刪除的ICD代碼
     * @return 所有未刪除的ICD代碼列表
     */
    List<IcdCode> findAllActiveIcdCodes();
    
    /**
     * 獲取所有ICD代碼
     * @return 所有ICD代碼的列表
     */
    List<IcdCode> findAllIcdCodes();
    
    /**
     * 標記ICD代碼為已刪除
     * @param id ICD代碼ID
     * @param modifierId 修改者ID
     */
    void markIcdCodeAsDeleted(Long id, Long modifierId);

    List<IcdCode> findByNameKeyword(String nameKeyword);
    List<IcdCode> findByEnNameKeyword(String enNameKeyword);
    IcdCode deleteIcdCode(Long id, Long modifierId);
    void deleteIcdCode(Long id);

}