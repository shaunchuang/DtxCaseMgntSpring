package itri.org.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.ConfigProperty;

import java.util.Optional;

public interface ConfigPropertyRepository extends JpaRepository<ConfigProperty, String> {
    Optional<ConfigProperty> findById(String id);
}