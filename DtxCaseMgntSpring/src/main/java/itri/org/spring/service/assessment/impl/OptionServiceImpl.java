package itri.org.spring.service.assessment.impl;

import itri.org.spring.model.assessment.Option;
import itri.org.spring.model.assessment.SubCategory;
import itri.org.spring.repository.assessment.OptionRepository;
import itri.org.spring.service.assessment.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Option saveOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public Optional<Option> findById(String optionId) {
        return optionRepository.findById(optionId);
    }

    @Override
    public List<Option> findBySubCategory(SubCategory subCategory) {
        return optionRepository.findBySubCategory(subCategory);
    }

    @Override
    public List<Option> findByOptionType(String optionType) {
        return optionRepository.findByOptionType(optionType);
    }

    @Override
    public List<Option> findByOptionScore(Integer optionScore) {
        return optionRepository.findByOptionScore(optionScore);
    }

    @Override
    public List<Option> findByOptionTextContaining(String optionText) {
        return optionRepository.findByOptionTextContaining(optionText);
    }

    @Override
    public List<Option> findAllOptions() {
        return optionRepository.findAll();
    }

    @Override
    public void deleteOption(String optionId) {
        optionRepository.deleteById(optionId);
    }
}