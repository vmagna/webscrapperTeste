package com.testeviasoft.webscrapperdemo.repository;

import com.testeviasoft.webscrapperdemo.dto.PaginacaoDTO;
import com.testeviasoft.webscrapperdemo.dto.SearchDTO;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class HistoricoApiNfeRepositoryCustomImpl {

    private final EntityManager em;

    public HistoricoApiNfeRepositoryCustomImpl(EntityManager em) {
        this.em = em;
    }

    public void addPersonByName(String name) {
        Query q = em.createQuery("SELECT H FROM HistoricoApiNfe AS H FROM H.autorizador = !1");
        List<HistoricoApiNfe> list = q.getResultList();

        for(HistoricoApiNfe h: list) {
            System.out.println(" AUT -> "+ h.getAutorizador() );
        }
    }

    public PaginacaoDTO search(SearchDTO searchDTO) {

        String query = "select H from HistoricoApiNfe as H ";
        String condicao = "where";

        if(searchDTO.getAutorizador() != null) {
            query += condicao + " H.autorizador = :autorizador";
            condicao = " and ";
        }
        if(searchDTO.getDtInicio() != null) {
            query += condicao + " H.horaAtualizacao > :dtInicio";
            condicao = " and ";
        }
        if(searchDTO.getDtFim() != null) {
            query += condicao + " H.horaAtualizacao < :dtFim";
        }

        var hist = em.createQuery(query, HistoricoApiNfe.class);

        if (searchDTO.getAutorizador() != null) {
            hist.setParameter("autorizador", searchDTO.getAutorizador());
        }
        if (searchDTO.getDtInicio() != null) {
            hist.setParameter("dtInicio", searchDTO.getDtInicio());
        }
        if (searchDTO.getDtFim() != null) {
            hist.setParameter("dtFim", searchDTO.getDtInicio());
        }

        return new PaginacaoDTO(
                1,
                0,
                0,
                0,
                0,
                0,
                hist.getResultList()
        );

    }

    // BUSCAR COM PARAMETRO AUTORIZADOR
    // LIMIT DE 24 HRS // 60/5=12*24=288 )
    List<HistoricoApiNfe> buscarPorIdAutorizador(int idAutorizador)
    {
        String query = "select H from HistoricoApiNfe as H " +
                "where H.autorizador = :autorizador";

        var hist = em.createQuery(query, HistoricoApiNfe.class)
                .setParameter("autorizador", idAutorizador);

        return hist.getResultList();
    }

}
