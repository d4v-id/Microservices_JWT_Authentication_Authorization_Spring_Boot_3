package com.tugasintegratif.tugas.rest.service.imp;

import com.tugasintegratif.tugas.rest.models.KaryawanEntity;
import com.tugasintegratif.tugas.rest.repository.KaryawanRepository;
import com.tugasintegratif.tugas.rest.service.KaryawanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KaryawanImplemen implements KaryawanService {

    private final KaryawanRepository karyawanRepository;

    public KaryawanImplemen(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    @Override
    public List<KaryawanEntity> findAllKaryawan() {
        return karyawanRepository.findAll();
    }

    @Override
    public Optional<KaryawanEntity> findById(Long id) {
        return karyawanRepository.findById(id);
    }

    @Override
    public KaryawanEntity saveKaryawan(KaryawanEntity karyawanEntity) {
        return karyawanRepository.save(karyawanEntity);
    }

    @Override
    public KaryawanEntity updateKaryawan(KaryawanEntity karyawanEntity) {
        return karyawanRepository.save(karyawanEntity);
    }

    @Override
    public void deleteKaryawan(Long id) {
        karyawanRepository.deleteById(id);

    }
}
