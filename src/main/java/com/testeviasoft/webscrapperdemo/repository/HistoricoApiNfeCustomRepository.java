package com.testeviasoft.webscrapperdemo.repository;

import com.testeviasoft.webscrapperdemo.dto.PaginacaoDTO;
import com.testeviasoft.webscrapperdemo.dto.SearchDTO;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HistoricoApiNfeCustomRepository {

    private final EntityManager em;

    public HistoricoApiNfeCustomRepository(EntityManager em) {
        this.em = em;
    }

    public PaginacaoDTO search(SearchDTO searchDTO) {

        String query = "select H from HistoricoApiNfe as H ";
        String condicao = "where";

        if(searchDTO.getAutorizador() > 0) {
            query += condicao + " H.autorizador = :autorizador";
            condicao = " and ";
        }
        if(searchDTO.getDtInicio() != null) {
            query += condicao + " H.horaAtualizacao = :horaAtualizacao";
            condicao = " and ";
        }

        var hist = em.createQuery(query, HistoricoApiNfe.class);

        if (searchDTO.getAutorizador() > 0) {
            hist.setParameter("autorizador", searchDTO.getAutorizador());
        }
        if (searchDTO.getDtInicio() != null) {
            hist.setParameter("horaAtualizacao", searchDTO.getDtInicio());
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


    // BUSCAR COM PARAMETRO AUTORIZADOR // LIMIT DE 24 HRS // 60/5=12*24=288 )
    List<HistoricoApiNfe> buscarPorIdAutorizador(int idAutorizador) {




        String query = "select H from HistoricoApiNfe as H " +
                "where H.autorizador = :autorizador LIMIT 288";




        var hist = em.createQuery(query, HistoricoApiNfe.class)
                .setParameter("autorizador", idAutorizador);


        return hist.getResultList();
    }

}
