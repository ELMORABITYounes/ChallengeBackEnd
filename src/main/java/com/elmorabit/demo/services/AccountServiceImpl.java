package com.elmorabit.demo.services;

import com.elmorabit.demo.dao.RoleRepository;
import com.elmorabit.demo.dao.UserRepository;
import com.elmorabit.demo.entities.AppRole;
import com.elmorabit.demo.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public AppUser saveUser(AppUser user) {
        String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role=roleRepository.findByRoleName(roleName);
        if(role==null) {
            role = new AppRole(null, roleName);
            roleRepository.save(role);
        }
        AppUser user=userRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public AppUser findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
