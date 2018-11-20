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
 * @version method: Association, v 0.1 协会类
 * @CreateDate 2018/11/19
 * @CreateTime 09:15
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Association implements Serializable {

    private static final long serialVersionUID = 1183385713216587274L;

    private long id;

    private String name;

    private String address;
}
