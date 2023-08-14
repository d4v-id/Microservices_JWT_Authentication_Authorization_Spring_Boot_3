package com.tugas_integra.uas.repository;

import java.util.Optional;

import com.tugas_integra.uas.model.ERole;
import com.tugas_integra.uas.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

