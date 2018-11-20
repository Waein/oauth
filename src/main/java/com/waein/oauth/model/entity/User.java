package com.waein.oauth.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: User, v 0.1 用户类
 * @CreateDate 2018/11/19
 * @CreateTime 09:16
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 7698862379923111158L;

    private Long id;

    private String username;

    private String password;
}
