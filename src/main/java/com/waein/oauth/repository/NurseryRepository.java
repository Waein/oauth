package com.waein.oauth.repository;

import com.waein.oauth.model.entity.Nursery;
import com.waein.oauth.model.entity.NurseryWithAssociation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: NurseryRepository, v 0.1 培训机构仓库(dao)
 * @CreateDate 2018/11/19
 * @CreateTime 11:30
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Mapper
public interface NurseryRepository {

    Integer insertNursery(Nursery nursery);

    Integer updateNurseryOnNameById(Nursery nursery);

    Integer deleteNurseryById(Long id);

    Nursery selectNurseryById(Long id);

    List<Nursery> selectNurseryByLeader(String leader);

    List<Nursery> selectAllNurserys();

    List<Nursery> selectNurserysByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    NurseryWithAssociation selectNurseryWithAssociationById(Long id);

    Integer selectCount();

}
