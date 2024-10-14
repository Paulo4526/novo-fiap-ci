package com.github.fiap.simple_api_java.repository;
import com.github.fiap.simple_api_java.model.Danos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DanoRepository extends JpaRepository<Danos, Long> {

    //public Optional<Danos> findById_tornado (Long id);
    public Optional<Danos> findById (Long id);
}
