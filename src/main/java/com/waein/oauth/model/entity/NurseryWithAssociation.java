package com.waein.oauth.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: NurseryWithAssociation, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 09:16
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class NurseryWithAssociation extends Nursery {

    private static final long serialVersionUID = -4858710159989616286L;

    private Association association;
}
