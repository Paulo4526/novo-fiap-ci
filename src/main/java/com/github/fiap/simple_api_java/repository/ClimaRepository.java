package com.github.fiap.simple_api_java.repository;

import com.github.fiap.simple_api_java.model.Clima;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClimaRepository extends JpaRepository<Clima, Long> {
    public Optional<Clima> findById(Long id);
    //public Optional<Clima> findByData(LocalDate data);
}
