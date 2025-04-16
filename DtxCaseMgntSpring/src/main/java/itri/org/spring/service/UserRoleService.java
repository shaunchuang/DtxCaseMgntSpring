package itri.org.spring.service;

import itri.org.spring.model.UserRole;
import itri.org.spring.model.User;
import itri.org.spring.model.Role;
import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    /**
     * 保存用戶角色關聯
     * @param userRole 用戶角色關聯
     * @return 保存後的用戶角色關聯
     */
    UserRole saveUserRole(UserRole userRole);
    
    /**
     * 根據ID查找用戶角色關聯
     * @param id 用戶角色關聯ID
     * @return 包含用戶角色關聯的Optional物件，若未找到則為空
     */
    Optional<UserRole> findById(Long id);
    
    /**
     * 根據用戶查找用戶角色關聯
     * @param user 用戶
     * @return 用戶角色關聯列表
     */
    List<UserRole> findByUser(User user);
    
    /**
     * 根據角色查找用戶角色關聯
     * @param role 角色
     * @return 用戶角色關聯列表
     */
    List<UserRole> findByRole(Role role);
    
    /**
     * 獲取所有用戶角色關聯
     * @return 所有用戶角色關聯的列表
     */
    List<UserRole> findAllUserRoles();
    
    /**
     * 刪除用戶角色關聯
     * @param id 用戶角色關聯ID
     */
    void deleteUserRole(Long id);
    
    /**
     * 根據用戶刪除所有相關的用戶角色關聯
     * @param user 用戶
     */
    void deleteByUser(User user);
    
    /**
     * 根據角色刪除所有相關的用戶角色關聯
     * @param role 角色
     */
    void deleteByRole(Role role);
}