package itri.org.spring.service.impl;

import itri.org.spring.model.UserRole;
import itri.org.spring.model.User;
import itri.org.spring.model.Role;
import itri.org.spring.repository.UserRoleRepository;
import itri.org.spring.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public Optional<UserRole> findById(Long id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public List<UserRole> findByUser(User user) {
        return userRoleRepository.findByUser(user);
    }

    @Override
    public List<UserRole> findByRole(Role role) {
        return userRoleRepository.findByRole(role);
    }

    @Override
    public List<UserRole> findAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public void deleteByUser(User user) {
        userRoleRepository.deleteByUser(user);
    }

    @Override
    public void deleteByRole(Role role) {
        userRoleRepository.deleteByRole(role);
    }
}