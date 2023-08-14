package com.developer.distribusi.repository;

import com.developer.distribusi.entity.DistribusiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribusiRepository extends JpaRepository<DistribusiEntity, Long> {
}
