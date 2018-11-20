package com.waein.oauth.repository;

import com.waein.oauth.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: UserRepository, v 0.1 用户仓库(dao)
 * @CreateDate 2018/11/19
 * @CreateTime 11:30
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Mapper
public interface UserRepository {

    User selectUserById(Long id);

    User selectUserByUsername(String username);

    List<User> selectAllUsers();

    Integer insertUser(User user);

    Integer updateUserOnPasswordById(User user);

    Integer deleteUserById(Long id);

}
