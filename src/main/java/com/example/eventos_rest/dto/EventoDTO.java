package com.example.eventos_rest.dto;

import com.example.eventos_rest.entity.Atividade;
import com.example.eventos_rest.entity.Participante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private List<Atividade> atividades;
    private Set<Participante> participantes;
}
