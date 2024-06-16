package com.example.eventos_rest.dao;

import com.example.eventos_rest.entity.Atividade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AtividadeDAO extends JpaRepository<Atividade, Long> {

}
