package com.waein.oauth.service;

import com.waein.oauth.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: UserService, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 12:06
 * @GitHub https://github.com/Waein
 * ===================================
 */
public interface UserService extends UserDetailsService {

    Optional<User> getUserById(Long id);

    boolean saveUser(User user);

    boolean modifyUserOnPasswordById(User user);

    boolean deleteUserById(Long id);

}
