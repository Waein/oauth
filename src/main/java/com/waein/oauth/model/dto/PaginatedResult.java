package com.waein.oauth.model.dto;

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
 * @version method: PaginatedResult, v 0.1 分页类
 * @CreateDate 2018/11/19
 * @CreateTime 09:13
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Accessors(chain = true) //链式访问
@NoArgsConstructor //无参构造器
@Getter //get
@Setter //set
@ToString //toString
public class PaginatedResult implements Serializable {

    private static final long serialVersionUID = 6191745064790884707L;

    private int currentPage; //Current page number

    private int totalPage; //Number of total pages

    private Object data; //Paginated resources
}
