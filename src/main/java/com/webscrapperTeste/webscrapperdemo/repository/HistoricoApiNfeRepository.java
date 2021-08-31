package com.webscrapperTeste.webscrapperdemo.repository;

import com.webscrapperTeste.webscrapperdemo.orm.HistoricoApiNfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoricoApiNfeRepository extends JpaRepository<HistoricoApiNfe, Long> {

    List<HistoricoApiNfe> findTop288ByAutorizadorOrderByIdAsc(int autorizador);
    HistoricoApiNfe findByAutorizador(int autorizador);

    // BUSCAR POR AUTORIZADOR
    @Query(value = "SELECT P FROM HistoricoApiNfe P WHERE  P.autorizador = ?1")
    List<HistoricoApiNfe> buscarPorIdAutorizador();

    @Query(value = "SELECT P FROM HistoricoApiNfe P" +
            " WHERE P.autorizador = ?1 AND P.horaAtualizacao > ?2 AND P.horaAtualizacao > ?3")
    List<HistoricoApiNfe> searchParams(int autorizador, LocalDateTime dtInicio, LocalDateTime dtFim);

    @Query(value = "SELECT P FROM HistoricoApiNfe P" +
            " WHERE P.horaAtualizacao > ?1 AND P.horaAtualizacao > ?2")
    List<HistoricoApiNfe> searchDateBetween(LocalDateTime dtInicio, LocalDateTime dtFim);

//    @Query(nativeQuery = true)
//    HistoricoApiNfe findNativeQuery()

}
