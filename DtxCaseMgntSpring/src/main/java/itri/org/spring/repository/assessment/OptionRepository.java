package itri.org.spring.repository.assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.assessment.Option;
import itri.org.spring.model.assessment.SubCategory;

import java.util.List;
import java.util.Optional;

public interface OptionRepository extends JpaRepository<Option, String> {
    Optional<Option> findByOptionId(String optionId);
    List<Option> findBySubCategory(SubCategory subCategory);
    List<Option> findByOptionType(String optionType);
    List<Option> findByOptionScore(Integer optionScore);
    List<Option> findByOptionTextContaining(String optionText);
}