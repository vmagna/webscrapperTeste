package com.webscrapperTeste.webscrapperdemo.repository;

import com.webscrapperTeste.webscrapperdemo.dto.PaginacaoDTO;
import com.webscrapperTeste.webscrapperdemo.dto.SearchDTO;
import com.webscrapperTeste.webscrapperdemo.orm.HistoricoApiNfe;
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

        if(searchDTO.getAutorizador() != null) {
            query = query.concat(condicao + " H.autorizador = ?").replace("?", searchDTO.getAutorizador().toString());
            condicao = " and ";
        }
        if(searchDTO.getDtInicio() != null && searchDTO.getDtFim() != null) {
            query = query.concat(condicao +
                    " cast(H.horaAtualizacao as LocalDateTime) BETWEEN '?1' AND '?2' ")
                    .replace("?1", searchDTO.getDtInicio().toString())
                    .replace("?2", searchDTO.getDtFim().toString());
            condicao = " and ";
        }

        System.out.println(String.format("%s", query));

        var hist = em.createQuery(query, HistoricoApiNfe.class);

        return new PaginacaoDTO(
                0, 0, 0,
                0, //ct.getMaxResults(),
                0, 0,
                hist.getResultList()
        );
    }

    public List<HistoricoApiNfe> maiorIndisponibilidade(SearchDTO searchDTO) {
        String query = "select H from HistoricoApiNfe as H ";
        String condicao = "where";

        if(searchDTO.getDtInicio() != null && searchDTO.getDtFim() != null) {
            query = query.concat(condicao +
                    " H.horaAtualizacao BETWEEN '?1' AND '?2' ")
                    .replace("?1", searchDTO.getDtInicio().toString())
                    .replace("?2", searchDTO.getDtFim().toString());
            condicao = " and ";
        }

        System.out.println(String.format("%s", query));

        var hist = em.createQuery(query, HistoricoApiNfe.class);

        return hist.getResultList();
    }

    // BUSCAR COM PARAMETRO AUTORIZADOR
    // LIMIT DE 24 HRS // 60/5=12*24=288 )
//    List<HistoricoApiNfe> buscarPorIdAutorizador(int idAutorizador) {
//        String query = "select H from HistoricoApiNfe as H " +
//                "where H.autorizador = :autorizador LIMIT 288";
//
//        var hist = em.createQuery(query, HistoricoApiNfe.class)
//                .setParameter("autorizador", idAutorizador);
//
//        return hist.getResultList();
//    }

}
