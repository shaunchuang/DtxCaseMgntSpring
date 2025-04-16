package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.IcdCode;

import java.util.Optional;
import java.util.List;

public interface IcdCodeRepository extends JpaRepository<IcdCode, Long> {
    Optional<IcdCode> findByCode(String code);
    Optional<IcdCode> findByPureCode(String pureCode);
    List<IcdCode> findByDeleteMarkFalse();
    List<IcdCode> findByNameContaining(String name);
}