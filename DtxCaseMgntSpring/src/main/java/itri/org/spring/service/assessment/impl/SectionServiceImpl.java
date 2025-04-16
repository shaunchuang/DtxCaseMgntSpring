package itri.org.spring.service.assessment.impl;

import itri.org.spring.model.assessment.Section;
import itri.org.spring.model.assessment.Assessment;
import itri.org.spring.repository.assessment.SectionRepository;
import itri.org.spring.service.assessment.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Optional<Section> findById(String sectionId) {
        return sectionRepository.findById(sectionId);
    }

    @Override
    public List<Section> findBySectionNameContaining(String sectionName) {
        return sectionRepository.findBySectionNameContaining(sectionName);
    }

    @Override
    public List<Section> findByAssessment(Assessment assessment) {
        return sectionRepository.findByAssessment(assessment);
    }

    @Override
    public List<Section> findAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public void deleteSection(String sectionId) {
        sectionRepository.deleteById(sectionId);
    }
}