package com.waein.safety.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: Nursery, v 0.1 培训机构
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
public class Nursery implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private Long id;

    private String name;

    private String leader;

    private String acronym;

    private Date createTime;

    private Long associationId;
}
