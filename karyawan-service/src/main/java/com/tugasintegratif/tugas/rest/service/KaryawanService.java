package com.tugasintegratif.tugas.rest.service;

import com.tugasintegratif.tugas.rest.models.KaryawanEntity;

import java.util.List;
import java.util.Optional;

public interface KaryawanService {
    List<KaryawanEntity> findAllKaryawan();
    Optional<KaryawanEntity> findById(Long id);
    KaryawanEntity saveKaryawan (KaryawanEntity karyawanEntity);
    KaryawanEntity updateKaryawan(KaryawanEntity karyawanEntity);
    void deleteKaryawan(Long id);

}
