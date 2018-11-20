package com.waein.safety.model.dto;

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
 * @version method: Error, v 0.1 错误类
 * @CreateDate 2018/11/19
 * @CreateTime 09:13
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Error implements Serializable {

    private static final long serialVersionUID = 7660756960387438399L;

    private int code; //Error code

    private String message; //Error message
}
