package com.bmhrdk.mitra.mitra.repository;

import com.bmhrdk.mitra.mitra.model.MitraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MitraRepo extends JpaRepository<MitraEntity, Long> {
}
