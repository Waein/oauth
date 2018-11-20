package com.waein.oauth.repository;

import com.waein.oauth.model.entity.Association;
import com.waein.oauth.model.entity.AssociationWithNurserys;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: AssociationRepository, v 0.1 协会仓库(dao)
 * @CreateDate 2018/11/19
 * @CreateTime 11:30
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Mapper
public interface AssociationRepository {

    Association selectAssociationById(Long id);

    List<Association> selectAllAssociations();

    AssociationWithNurserys selectAssociationWithNurserysById(Long id);

}
