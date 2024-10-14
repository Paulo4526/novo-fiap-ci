package com.github.fiap.simple_api_java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "TB_MICRO_TORNADO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tornado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tornado")
    private Long id;

    @Column(name = "nome_tornado")
    private String nome;

    private String classificacao;

    @Column(name = "local_origem")
    private String local;

    @Column(name = "data_origem")
    private LocalDate data;
}
