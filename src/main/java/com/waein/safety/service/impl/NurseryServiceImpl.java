package com.waein.safety.service.impl;

import com.waein.safety.model.entity.Nursery;
import com.waein.safety.model.entity.NurseryWithAssociation;
import com.waein.safety.repository.NurseryRepository;
import com.waein.safety.service.NurseryService;
import com.waein.safety.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: NurseryServiceImpl, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 12:12
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Service
public class NurseryServiceImpl implements NurseryService {

    private final NurseryRepository nurseryRepository;

    @Autowired
    public NurseryServiceImpl(NurseryRepository nurseryRepository) {
        this.nurseryRepository = nurseryRepository;
    }

    @Override
    public Optional<Nursery> getNurseryById(Long id) {
        return Optional.ofNullable(nurseryRepository.selectNurseryById(id));
    }

    @Override
    public List<Nursery> getNurserysByLeader(String leader) {
        return nurseryRepository.selectNurseryByLeader(leader);
    }

    @Override
    public List<Nursery> getNurserysByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return nurseryRepository.selectNurserysByPage(offset, perPage);
    }

    @Override
    public List<String> getAllNurseryNames() {
        return nurseryRepository
                .selectAllNurserys()
                .stream()
                .map(Nursery::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NurseryWithAssociation> getNurseryWithAssociationById(Long id) {
        return Optional.ofNullable(nurseryRepository.selectNurseryWithAssociationById(id));
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(nurseryRepository.selectCount(), perPage);
    }

    @Override
    @Transactional
    public boolean saveNursery(Nursery nursery) {
        return nurseryRepository.insertNursery(nursery) > 0;
    }

    @Override
    @Transactional
    public boolean modifyNurseryOnNameById(Nursery nursery) {
        return nurseryRepository.updateNurseryOnNameById(nursery) > 0;
    }

    @Override
    @Transactional
    public boolean deleteNurseryById(Long id) {
        return nurseryRepository.deleteNurseryById(id) > 0;
    }
}
