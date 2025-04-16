package itri.org.spring.service;

import itri.org.spring.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    /**
     * 保存角色
     * @param role 角色
     * @return 保存後的角色
     */
    Role saveRole(Role role);
    
    /**
     * 根據ID查找角色
     * @param id 角色ID
     * @return 包含角色的Optional物件，若未找到則為空
     */
    Optional<Role> findById(Long id);
    
    /**
     * 根據角色名稱查找角色
     * @param roleName 角色名稱
     * @return 包含角色的Optional物件，若未找到則為空
     */
    Optional<Role> findByRoleName(String roleName);
    
    /**
     * 獲取所有角色
     * @return 所有角色的列表
     */
    List<Role> findAllRoles();
    
    /**
     * 刪除角色
     * @param id 角色ID
     */
    void deleteRole(Long id);
}