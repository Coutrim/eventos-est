package com.example.eventos_rest.dao;

import com.example.eventos_rest.entity.Evento;
import com.example.eventos_rest.entity.Participante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ParticipanteDAO extends JpaRepository<Participante, Long> {

}
