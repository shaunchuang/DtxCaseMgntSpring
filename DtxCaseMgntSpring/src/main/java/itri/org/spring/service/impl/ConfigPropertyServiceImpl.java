package itri.org.spring.service.impl;

import itri.org.spring.model.ConfigProperty;
import itri.org.spring.repository.ConfigPropertyRepository;
import itri.org.spring.service.ConfigPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConfigPropertyServiceImpl implements ConfigPropertyService {

    private final ConfigPropertyRepository configPropertyRepository;

    @Autowired
    public ConfigPropertyServiceImpl(ConfigPropertyRepository configPropertyRepository) {
        this.configPropertyRepository = configPropertyRepository;
    }

    @Override
    public ConfigProperty saveConfigProperty(ConfigProperty configProperty) {
        return configPropertyRepository.save(configProperty);
    }

    @Override
    public Optional<ConfigProperty> findById(String id) {
        return configPropertyRepository.findById(id);
    }

    @Override
    public List<ConfigProperty> findAllConfigProperties() {
        return configPropertyRepository.findAll();
    }

    @Override
    public ConfigProperty updateGlobalValue(String id, String globalValue) {
        Optional<ConfigProperty> optionalConfigProperty = configPropertyRepository.findById(id);
        if (optionalConfigProperty.isPresent()) {
            ConfigProperty configProperty = optionalConfigProperty.get();
            configProperty.setGlobalValue(globalValue);
            return configPropertyRepository.save(configProperty);
        }
        return null;
    }

    @Override
    public void deleteConfigProperty(String id) {
        configPropertyRepository.deleteById(id);
    }
}