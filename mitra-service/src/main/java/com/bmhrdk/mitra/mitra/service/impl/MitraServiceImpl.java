package com.bmhrdk.mitra.mitra.service.impl;

import com.bmhrdk.mitra.mitra.model.MitraEntity;
import com.bmhrdk.mitra.mitra.repository.MitraRepo;
import com.bmhrdk.mitra.mitra.service.MitraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MitraServiceImpl implements MitraService {

    private final MitraRepo mitraRepo;

    public MitraServiceImpl(MitraRepo mitraRepo) {
        this.mitraRepo = mitraRepo;
    }

    @Override
    public List<MitraEntity> findAllMitra() {
        return mitraRepo.findAll();
    }

    @Override
    public Optional<MitraEntity> findById(Long id) {
        return mitraRepo.findById(id);
    }

    @Override
    public MitraEntity saveMitra(MitraEntity mitraEntity) {
        return mitraRepo.save(mitraEntity);
    }

    @Override
    public MitraEntity updateMitra(MitraEntity mitraEntity) {
        return mitraRepo.save(mitraEntity);
    }

    @Override
    public void deleteMitra(Long id) {
        mitraRepo.deleteById(id);

    }
}
