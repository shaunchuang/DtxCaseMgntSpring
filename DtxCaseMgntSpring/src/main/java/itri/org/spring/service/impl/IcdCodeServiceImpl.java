package itri.org.spring.service.impl;

import itri.org.spring.model.IcdCode;
import itri.org.spring.repository.IcdCodeRepository;
import itri.org.spring.service.IcdCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        Optional<IcdCode> icdCode = icdCodeRepository.findByCode(code);
        List<IcdCode> result = new ArrayList<>();
        icdCode.ifPresent(result::add);
        return result;
    }

    @Override
    public List<IcdCode> findByPureCode(String pureCode) {
        Optional<IcdCode> icdCode = icdCodeRepository.findByPureCode(pureCode);
        List<IcdCode> result = new ArrayList<>();
        icdCode.ifPresent(result::add);
        return result;
    }

    @Override
    public List<IcdCode> findByName(String name) {
        // 使用包含搜尋來模擬精確匹配
        return icdCodeRepository.findByNameContaining(name).stream()
                .filter(code -> code.getName() != null && code.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<IcdCode> findByEnName(String enName) {
        // 由於沒有現成方法，使用流式過濾
        return icdCodeRepository.findAll().stream()
                .filter(code -> code.getEnName() != null && code.getEnName().equals(enName))
                .collect(Collectors.toList());
    }

    @Override
    public List<IcdCode> findByKeyword(String keyword) {
        if (keyword.matches("^[A-Za-z0-9.]+$")) {
            return icdCodeRepository.findAll().stream()
                    .filter(code -> code.getCode() != null && code.getCode().contains(keyword))
                    .collect(Collectors.toList());
        } else {
            return icdCodeRepository.findByNameContaining(keyword);
        }
    }

    @Override
    public List<IcdCode> findByNameKeyword(String nameKeyword) {
        return icdCodeRepository.findByNameContaining(nameKeyword);
    }

    @Override
    public List<IcdCode> findByEnNameKeyword(String enNameKeyword) {
        return icdCodeRepository.findAll().stream()
                .filter(code -> code.getEnName() != null && code.getEnName().contains(enNameKeyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<IcdCode> findAllIcdCodes() {
        return icdCodeRepository.findAll();
    }

    @Override
    public List<IcdCode> findAllActiveIcdCodes() {
        return icdCodeRepository.findByDeleteMarkFalse();
    }

    @Override
    public IcdCode deleteIcdCode(Long id, Long modifierId) {
        Optional<IcdCode> optIcdCode = icdCodeRepository.findById(id);
        if (optIcdCode.isPresent()) {
            IcdCode icdCode = optIcdCode.get();
            icdCode.setDeleteMark(true);
            icdCode.setModifier(modifierId);
            icdCode.setModifyTime(new Date());
            return icdCodeRepository.save(icdCode);
        }
        return null;
    }

    @Override
    public void deleteIcdCode(Long id) {
        icdCodeRepository.deleteById(id);
    }

    @Override
    public void markIcdCodeAsDeleted(Long id, Long modifierId){
        Optional<IcdCode> icdCodeOptional = icdCodeRepository.findById(id);
        if (icdCodeOptional.isPresent()) {
            IcdCode icdCode = icdCodeOptional.get();
            icdCode.setDeleteMark(true);
            icdCode.setModifier(modifierId);
            icdCode.setModifyTime(new Date());
            icdCodeRepository.save(icdCode);
        }
    }
}