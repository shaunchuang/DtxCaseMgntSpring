package itri.org.spring.repository.assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import itri.org.spring.model.assessment.SubCategory;
import itri.org.spring.model.assessment.Question;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String> {
    Optional<SubCategory> findBySubCategoryId(String subCategoryId);
    List<SubCategory> findByQuestion(Question question);
    List<SubCategory> findBySubCategoryNameContaining(String subCategoryName);
}