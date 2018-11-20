package com.waein.safety.service;

import com.waein.safety.model.entity.Nursery;
import com.waein.safety.model.entity.NurseryWithAssociation;

import java.util.List;
import java.util.Optional;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: NurseryService, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 12:06
 * @GitHub https://github.com/Waein
 * ===================================
 */
public interface NurseryService {

    Optional<Nursery> getNurseryById(Long id);

    List<Nursery> getNurserysByLeader(String leader);

    List<Nursery> getNurserysByPage(Integer page, Integer perPage);

    List<String> getAllNurseryNames();

    Optional<NurseryWithAssociation> getNurseryWithAssociationById(Long id);

    Integer getTotalPage(Integer perPage);

    boolean saveNursery(Nursery nursery);

    boolean modifyNurseryOnNameById(Nursery nursery);

    boolean deleteNurseryById(Long id);

}
