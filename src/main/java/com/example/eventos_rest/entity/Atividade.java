package com.example.eventos_rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_atividades")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime horaInicial;
    private LocalDateTime horaFinal;

    @Column(name = "hora_duracao")
    private Integer horaDuracao;

    @Column(name = "tipo_atividade")
    private String tipoAtividade;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    @JsonIgnore
    private Evento evento;
    
}
