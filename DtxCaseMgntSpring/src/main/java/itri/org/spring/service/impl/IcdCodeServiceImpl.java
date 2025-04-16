package itri.org.spring.service.impl;

import itri.org.spring.model.IcdCode;
import itri.org.spring.repository.IcdCodeRepository;
import itri.org.spring.service.IcdCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class IcdCodeServiceImpl implements IcdCodeService {

    private final IcdCodeRepository icdCodeRepository;

    @Autowired
    public IcdCodeServiceImpl(IcdCodeRepository icdCodeRepository) {
        this.icdCodeRepository = icdCodeRepository;
    }

    @Override
    public IcdCode saveIcdCode(IcdCode icdCode) {
        return icdCodeRepository.save(icdCode);
    }

    @Override
    public Optional<IcdCode> findById(Long id) {
        return icdCodeRepository.findById(id);
    }

    @Override
    public List<IcdCode> findByCode(String code) {
        return icdCodeRepository.findByCode(code);
    }

    @Override
    public List<IcdCode> findByPureCode(String pureCode) {
        return icdCodeRepository.findByPureCode(pureCode);
    }

    @Override
    public List<IcdCode> findByName(String name) {
        return icdCodeRepository.findByName(name);
    }

    @Override
    public List<IcdCode> findByEnName(String enName) {
        return icdCodeRepository.findByEnName(enName);
    }

    @Override
    public List<IcdCode> findByKeyword(String keyword) {
        // 搜尋名稱或代碼包含關鍵字的ICD代碼
        List<IcdCode> byCode = icdCodeRepository.findByCodeContaining(keyword);
        List<IcdCode> byName = icdCodeRepository.findByNameContaining(keyword);
        List<IcdCode> byEnName = icdCodeRepository.findByEnNameContaining(keyword);
        
        // 合併並去重
        return byCode.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<IcdCode> findAllActiveIcdCodes() {
        return icdCodeRepository.findByIsDeleted(false);
    }

    @Override
    public List<IcdCode> findAllIcdCodes() {
        return icdCodeRepository.findAll();
    }

    @Override
    public void markIcdCodeAsDeleted(Long id, Long modifierId) {
        Optional<IcdCode> optionalIcdCode = icdCodeRepository.findById(id);
        if (optionalIcdCode.isPresent()) {
            IcdCode icdCode = optionalIcdCode.get();
            icdCode.setIsDeleted(true);
            icdCode.setModifierId(modifierId);
            icdCode.setModifyTime(new Date());
            icdCodeRepository.save(icdCode);
        }
    }
}