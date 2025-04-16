package itri.org.spring.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import itri.org.spring.model.Role;
import itri.org.spring.model.User;
import itri.org.spring.model.User.UserStatus;
import itri.org.spring.model.UserRole;
import itri.org.spring.repository.RoleRepository;
import itri.org.spring.repository.UserRepository;
import itri.org.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final String DEFAULT_ROLE = "USER";
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User register(String username, String account, String email, String telCell, String password) {
        // 檢查帳號是否已存在
        if (userRepository.existsByAccount(account)) {
            throw new RuntimeException("帳號已存在");
        }
        // 檢查電子郵件是否已存在
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("電子郵件已被使用");
        }
        // 檢查手機號碼是否已存在
        if (userRepository.existsByTelCell(telCell)) {
            throw new RuntimeException("手機號碼已被使用");
        }
        
        // 創建用戶
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setAccount(account);
        newUser.setEmail(email);
        newUser.setTelCell(telCell);
        newUser.setPassword(passwordEncoder.encode(password));  // 加密密碼
        newUser.setStatus(UserStatus.WAIT_FOR_COMPLETED);  // 設置狀態為等待完成
        
        // 保存用戶
        User savedUser = userRepository.save(newUser);
        
        // 為用戶分配默認角色
        assignDefaultRole(savedUser);
        
        return savedUser;
    }
    
    @Transactional
    private void assignDefaultRole(User user) {
        // 獲取或創建默認角色
        Role role = roleRepository.findByRoleName(DEFAULT_ROLE)
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setRoleName(DEFAULT_ROLE);
                    return roleRepository.save(newRole);
                });
        
        // 創建用戶角色關聯
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        
        // 設置用戶角色集合
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRole);
        user.setUserRoles(roles);
        
        // 更新用戶
        userRepository.save(user);
    }

    @Override
    public User findByAccount(String account) {
        return userRepository.findByAccount(account)
                .orElseThrow(() -> new RuntimeException("用戶不存在"));
    }

    @Override
    public boolean verifyLogin(String account, String password) {
        Optional<User> user = userRepository.findByAccount(account);
        if (user.isPresent()) {
            return passwordEncoder.matches(password, user.get().getPassword());
        }
        return false;
    }

    @Override
    public boolean validateCaptcha(String userInput, String sessionCaptcha) {
        return userInput != null && sessionCaptcha != null && 
               userInput.equalsIgnoreCase(sessionCaptcha);
    }

    @Override
    public Map<String, Object> generateUserInfo(User user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", user.getId());
        userInfo.put("username", user.getUsername());
        userInfo.put("account", user.getAccount());
        userInfo.put("email", user.getEmail());
        userInfo.put("status", user.getStatus().toString());
        
        // 更新最後登入時間
        user.setLastLoginDate(new Date());
        userRepository.save(user);
        
        return userInfo;
    }
}