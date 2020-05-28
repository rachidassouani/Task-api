package io.rachidassouani.task_api.service;

import io.rachidassouani.task_api.dao.RoleRepository;
import io.rachidassouani.task_api.dao.UserRepository;
import io.rachidassouani.task_api.entity.AppRole;
import io.rachidassouani.task_api.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser appUser) {
        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        return userRepository.save(appUser);
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        return roleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        // get user by his username
        AppUser user = userRepository.findByUsername(username);
        // get role by roleName
        AppRole role = roleRepository.findByRoleName(roleName);
        // set role to the existing user
        user.getRoles().add(role);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        AppUser user = userRepository.findByUsername(username);
        return user;
    }
}
