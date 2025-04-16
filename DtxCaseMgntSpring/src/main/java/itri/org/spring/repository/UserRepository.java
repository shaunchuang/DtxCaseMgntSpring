package itri.org.spring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccount(String account);
    boolean existsByAccount(String account);
    boolean existsByEmail(String email);
    boolean existsByTelCell(String telCell);
}