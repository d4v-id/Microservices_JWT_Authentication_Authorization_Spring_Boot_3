package com.developer.distribusi.service;

import com.developer.distribusi.DTO.ResponseDTO;
import com.developer.distribusi.entity.DistribusiEntity;

import java.util.List;
import java.util.Optional;

public interface DistribusiService {
    List<DistribusiEntity> findAllDistribusi();
    ResponseDTO findById(Long id); // Interface DTO
    DistribusiEntity saveDistribusi(DistribusiEntity distribusiEntity);
    DistribusiEntity updateDistribusi(DistribusiEntity distribusiEntity);
    void deleteDistribusi(Long id);
}
