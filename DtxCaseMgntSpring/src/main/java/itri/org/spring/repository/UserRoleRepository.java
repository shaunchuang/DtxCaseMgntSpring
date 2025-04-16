package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.UserRole;
import itri.org.spring.model.User;
import itri.org.spring.model.Role;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser(User user);
    List<UserRole> findByRole(Role role);
    void deleteByUser(User user);
    void deleteByRole(Role role);
}