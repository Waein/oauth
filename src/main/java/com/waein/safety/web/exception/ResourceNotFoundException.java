package com.waein.safety.web.exception;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: ResourceNotFoundException, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 14:30
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Accessors(chain = true)
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2565431806475335331L;

    private String resourceName;

    private Long id;

    @Override
    public String getMessage() {
        return StringUtils.capitalize(resourceName) + " with id: " + id + " is not found.";
    }

}
