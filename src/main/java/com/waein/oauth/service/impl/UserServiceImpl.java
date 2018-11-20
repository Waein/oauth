package com.waein.oauth.service.impl;

import com.waein.oauth.model.dto.CustomUserDetails;
import com.waein.oauth.model.entity.User;
import com.waein.oauth.repository.UserRepository;
import com.waein.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: Application, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 12:12
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.selectUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find the user '" + username + "'");
        }

        // Not involve authorities, so pass null to authorities
        return new CustomUserDetails(user, true, true, true, true, null);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userRepository.selectUserById(id));
    }

    @Override
    public boolean saveUser(User user) {
        return userRepository.insertUser(user) > 0;
    }

    @Override
    public boolean modifyUserOnPasswordById(User user) {
        return userRepository.updateUserOnPasswordById(user) > 0;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id) > 0;
    }

}
