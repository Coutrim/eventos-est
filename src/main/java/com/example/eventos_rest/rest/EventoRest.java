package com.example.eventos_rest.rest;

import com.example.eventos_rest.dto.EventoDTO;
import com.example.eventos_rest.dto.ParticipanteDTO;
import com.example.eventos_rest.entity.Evento;
import com.example.eventos_rest.entity.Participante;
import com.example.eventos_rest.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eventos")
public class EventoRest {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/{idEvento}/participantes")
    public ResponseEntity<Participante> inserirParticipante(@PathVariable Long idEvento, @RequestBody ParticipanteDTO participanteDTO) {
        Participante participante = eventoService.inserirParticipante(idEvento, participanteDTO);
        return ResponseEntity.ok(participante);
    }

    @PostMapping
    private ResponseEntity inserirEvento(@Valid @RequestBody EventoDTO eventoDTO){
       Evento evento =  eventoService.inserirEvento(eventoDTO);
        return ResponseEntity.ok(evento);
    }

    @GetMapping
    private ResponseEntity<List<EventoDTO>>  listarEventos(){
        List<EventoDTO> eventos =  eventoService.listarEventos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/atividades/contagem")
    public Map<String, Long> contarAtividadesPorTipo() {
        return eventoService.contarAtividadesPorTipo();
    }
}
