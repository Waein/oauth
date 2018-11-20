package com.waein.oauth.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: AssociationWithNurserys, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 09:15
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class AssociationWithNurserys extends Association {

    private static final long serialVersionUID = -740463675258248874L;

    private List<Nursery> nurseries;
}
