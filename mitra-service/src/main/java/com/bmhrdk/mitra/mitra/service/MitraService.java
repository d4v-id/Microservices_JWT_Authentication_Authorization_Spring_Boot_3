package com.bmhrdk.mitra.mitra.service;

import com.bmhrdk.mitra.mitra.model.MitraEntity;

import java.util.List;
import java.util.Optional;

public interface MitraService {
    List<MitraEntity> findAllMitra();
    Optional<MitraEntity> findById(Long id);
    MitraEntity saveMitra(MitraEntity mitraEntity);
    MitraEntity updateMitra(MitraEntity mitraEntity);

    void deleteMitra(Long id);
}
