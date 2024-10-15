package com.github.fiap.projeto_tornado.repository;

import com.github.fiap.projeto_tornado.model.Clima;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClimaRepository extends JpaRepository<Clima, Long> {
    public Optional<Clima> findById(Long id);
    //public Optional<Clima> findByData(LocalDate data);
}
