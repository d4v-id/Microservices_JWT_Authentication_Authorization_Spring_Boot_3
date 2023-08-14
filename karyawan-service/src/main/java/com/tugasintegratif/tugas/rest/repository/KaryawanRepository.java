package com.tugasintegratif.tugas.rest.repository;

import com.tugasintegratif.tugas.rest.models.KaryawanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends JpaRepository<KaryawanEntity,Long> {
}
