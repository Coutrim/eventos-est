package com.example.eventos_rest.dto;

import com.example.eventos_rest.entity.Evento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AtividadeDTO {

    private Long id;
    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Descrição não pode ser nula")
    @NotBlank(message = "Descrição não pode ser vazia")
    private String descricao;

    @NotNull(message = "Hora inicial não pode ser nula")
    private LocalDateTime horaInicial;

    @NotNull(message = "Hora final não pode ser nula")
    private LocalDateTime horaFinal;

}
