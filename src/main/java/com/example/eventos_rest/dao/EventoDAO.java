package com.example.eventos_rest.dao;

import com.example.eventos_rest.entity.Evento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EventoDAO extends JpaRepository<Evento, Long> {

    @Query("SELECT DISTINCT e FROM Evento e " +
            "LEFT JOIN e.atividades a " +
            "LEFT JOIN e.participantes p " +
            "WHERE e.id = :id")
    Evento buscarEventoPorId(@Param("id") Long id);

    @Query("SELECT DISTINCT e FROM Evento e " +
            "LEFT JOIN e.atividades a " +
            "LEFT JOIN e.participantes p")
    List<Evento> listarEventos();



    @Query("SELECT a.tipoAtividade, COUNT(a) FROM Atividade a GROUP BY a.tipoAtividade")
    List<Object[]> countAtividadesByTipo();

}
