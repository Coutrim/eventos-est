package com.example.eventos_rest.service;

import com.example.eventos_rest.dao.EventoDAO;
import com.example.eventos_rest.dao.ParticipanteDAO;
import com.example.eventos_rest.dto.EventoDTO;
import com.example.eventos_rest.dto.ParticipanteDTO;
import com.example.eventos_rest.entity.Atividade;
import com.example.eventos_rest.entity.Evento;
import com.example.eventos_rest.entity.Participante;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventoService {

    @Autowired
    EventoDAO eventoDAO;

    @Autowired
    ParticipanteDAO participanteDAO;

    @Transactional
    public Evento inserirEvento(EventoDTO eventoDTO) {
        Evento evento = new Evento();
        evento.setNome(eventoDTO.getNome());
        evento.setDescricao(eventoDTO.getDescricao());
        evento.setData(eventoDTO.getData());

        // Associe as atividades ao evento
        if (eventoDTO.getAtividades() != null) {
            for (Atividade atividade : eventoDTO.getAtividades()) {
                atividade.setEvento(evento);
            }
            evento.setAtividades(eventoDTO.getAtividades());
        }

        eventoDAO.save(evento);
        return evento;
    }


    @Transactional
    public Participante inserirParticipante(Long idEvento, ParticipanteDTO participanteDTO) {
        if (idEvento != null) {
            Optional<Evento> eventoOptional = eventoDAO.findById(idEvento);

            if (eventoOptional.isPresent()) {
                Evento evento = eventoOptional.get();

                Participante participante = new Participante();
                participante.setNome(participanteDTO.getNome());
                participante.setEmail(participanteDTO.getEmail());

                // Atualiza a relação bidirecional
                participante.getEventos().add(evento);
                evento.getParticipantes().add(participante);

                participante = participanteDAO.save(participante);
                eventoDAO.save(evento);

                return participante;
            }
        }
        return null;
    }

    @Transactional
    public List<EventoDTO> listarEventos() {
        List<EventoDTO> listaEventosDTO = new ArrayList<>();
        for (Evento evento : eventoDAO.listarEventos()) {
            EventoDTO eventoDTO = new EventoDTO();
            eventoDTO.setId(evento.getId());
            eventoDTO.setNome(evento.getNome());
            eventoDTO.setDescricao(evento.getDescricao());
            eventoDTO.setData(evento.getData());
            eventoDTO.setAtividades(evento.getAtividades());
            eventoDTO.setParticipantes(evento.getParticipantes());

            listaEventosDTO.add(eventoDTO);
        }
        return listaEventosDTO;
    }

    public Map<String, Long> contarAtividadesPorTipo() {
        List<Object[]> resultados = eventoDAO.countAtividadesByTipo();
        Map<String, Long> contagem = new HashMap<>();
        for (Object[] resultado : resultados) {
            String tipoAtividade = (String) resultado[0];
            Long count = (Long) resultado[1];
            contagem.put(tipoAtividade, count);
        }
        return contagem;
    }

}
