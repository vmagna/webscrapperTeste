package com.testeviasoft.webscrapperdemo.repository;

import com.testeviasoft.webscrapperdemo.dto.PaginacaoDTO;
import com.testeviasoft.webscrapperdemo.dto.SearchDTO;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoApiNfeRepository extends JpaRepository<HistoricoApiNfe, Long> {

    /***
     * Implementações nativas do SPRING DATA JPA
     * @return
     */
    List<HistoricoApiNfe> findByTop100ByAutorizadorOrOrderByIdAsc(int autorizador);
    List<HistoricoApiNfe> findTop288ByAutorizadorOrderByIdAsc(int autorizador);
    HistoricoApiNfe findByAutorizador(int autorizador);

    PaginacaoDTO searchParams(SearchDTO searchDTO);

    // BUSCAR POR AUTORIZADOR
    @Query(value = "SELECT P FROM HistoricoApiNfe P WHERE  P.autorizador = ?1")
    List<HistoricoApiNfe> buscarPorIdAutorizador();

//    @Query(nativeQuery = true)
//    HistoricoApiNfe findNativeQuery()

}
