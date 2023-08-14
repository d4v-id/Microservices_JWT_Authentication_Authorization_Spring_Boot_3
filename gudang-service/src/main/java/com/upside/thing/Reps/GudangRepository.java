package com.upside.thing.Reps;

import com.upside.thing.Entity.GudangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GudangRepository extends JpaRepository<GudangEntity, Long> {

}
