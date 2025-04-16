package itri.org.spring.service;

import itri.org.spring.model.ConfigProperty;
import java.util.List;
import java.util.Optional;

public interface ConfigPropertyService {
    /**
     * 保存配置屬性
     * @param configProperty 配置屬性
     * @return 保存後的配置屬性
     */
    ConfigProperty saveConfigProperty(ConfigProperty configProperty);
    
    /**
     * 根據ID查找配置屬性
     * @param id 配置屬性ID
     * @return 包含配置屬性的Optional物件，若未找到則為空
     */
    Optional<ConfigProperty> findById(String id);
    
    /**
     * 獲取所有配置屬性
     * @return 所有配置屬性的列表
     */
    List<ConfigProperty> findAllConfigProperties();
    
    /**
     * 更新配置屬性的全域值
     * @param id 配置屬性ID
     * @param globalValue 全域值
     * @return 更新後的配置屬性
     */
    ConfigProperty updateGlobalValue(String id, String globalValue);
    
    /**
     * 刪除配置屬性
     * @param id 配置屬性ID
     */
    void deleteConfigProperty(String id);
}