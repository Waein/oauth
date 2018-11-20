package com.waein.oauth.service;

import com.waein.oauth.model.entity.Association;
import com.waein.oauth.model.entity.AssociationWithNurserys;

import java.util.List;
import java.util.Optional;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: AssociationService, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 12:06
 * @GitHub https://github.com/Waein
 * ===================================
 */
public interface AssociationService {

    Optional<Association> getAssociationById(Long id);

    List<String> getAllAssociationNames();

    Optional<AssociationWithNurserys> getAssociationWithNurserysById(Long id);

}
