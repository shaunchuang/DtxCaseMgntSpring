package itri.org.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import itri.org.spring.model.User;
import itri.org.spring.model.UserRole;
import itri.org.spring.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 在我們的系統中，使用account作為登錄名
        User user = userRepository.findByAccount(username)
                .orElseThrow(() -> new UsernameNotFoundException("用戶不存在: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getAccount(), 
                user.getPassword(),
                user.getStatus() == User.UserStatus.APPROVED, // 只有通過審核的用戶可以登錄
                true, // 賬號未過期
                true, // 憑證未過期
                true, // 賬號未鎖定
                getAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        // 從用戶角色中獲取權限
        if (user.getUserRoles() != null) {
            for (UserRole userRole : user.getUserRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRole().getRoleName()));
            }
        }
        
        return authorities;
    }
}