package com.example.eventos_rest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;

    @OneToMany(mappedBy = "evento", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_evento_participantes",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participantes = new HashSet<>();

}
