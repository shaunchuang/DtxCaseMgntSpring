package itri.org.spring.service.assessment.impl;

import itri.org.spring.model.assessment.SubCategory;
import itri.org.spring.model.assessment.Question;
import itri.org.spring.repository.assessment.SubCategoryRepository;
import itri.org.spring.service.assessment.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public Optional<SubCategory> findById(String subCategoryId) {
        return subCategoryRepository.findById(subCategoryId);
    }

    @Override
    public List<SubCategory> findByQuestion(Question question) {
        return subCategoryRepository.findByQuestion(question);
    }

    @Override
    public List<SubCategory> findBySubCategoryNameContaining(String subCategoryName) {
        return subCategoryRepository.findBySubCategoryNameContaining(subCategoryName);
    }

    @Override
    public List<SubCategory> findAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public void deleteSubCategory(String subCategoryId) {
        subCategoryRepository.deleteById(subCategoryId);
    }
}