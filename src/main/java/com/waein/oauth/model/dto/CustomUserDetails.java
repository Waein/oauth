package com.waein.oauth.model.dto;

import com.waein.oauth.model.entity.User;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: CustomUserDetails, v 0.1 登陆用户信息
 * @CreateDate 2018/11/19
 * @CreateTime 09:13
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Getter
@ToString
public class CustomUserDetails extends User implements UserDetails {

    private static final long serialVersionUID = 1702923242319850756L;

    private final boolean enabled; //是否启用

    private final boolean accountNonExpired; //账户是否过期

    private final boolean credentialsNonExpired; //授权是否过期

    private final boolean accountNonLocked; //账户是否锁定

    private final Set<GrantedAuthority> authorities; //授权角色

    public CustomUserDetails(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        //登陆用户需要验证的名字密码非空则开始授权认证
        if (user != null && StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword())) {
            setUsername(user.getUsername());
            setPassword(user.getPassword());
            this.enabled = enabled;
            this.accountNonExpired = accountNonExpired;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = Collections.unmodifiableSet(new HashSet<>(CollectionUtils.emptyIfNull(authorities)));
        } else {
            throw new IllegalArgumentException("Cannot pass because of null or empty values to constructor");
        }
    }
}
