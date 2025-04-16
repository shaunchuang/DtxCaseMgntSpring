package itri.org.spring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);
}