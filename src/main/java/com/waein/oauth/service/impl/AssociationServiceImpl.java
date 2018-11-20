package com.waein.oauth.service.impl;

import com.waein.oauth.model.entity.Association;
import com.waein.oauth.model.entity.AssociationWithNurserys;
import com.waein.oauth.repository.AssociationRepository;
import com.waein.oauth.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: AssociationServiceImpl, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 12:12
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Service
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepository;

    @Autowired
    public AssociationServiceImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public Optional<Association> getAssociationById(Long id) {
        return Optional.ofNullable(associationRepository.selectAssociationById(id));
    }

    @Override
    public List<String> getAllAssociationNames() {
        return associationRepository
                .selectAllAssociations()
                .stream()
                .map(Association::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AssociationWithNurserys> getAssociationWithNurserysById(Long id) {
        return Optional.ofNullable(associationRepository.selectAssociationWithNurserysById(id));
    }
}
