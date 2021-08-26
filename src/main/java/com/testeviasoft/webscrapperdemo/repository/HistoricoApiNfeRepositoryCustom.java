package com.testeviasoft.webscrapperdemo.repository;


import com.testeviasoft.webscrapperdemo.dto.PaginacaoDTO;
import com.testeviasoft.webscrapperdemo.dto.SearchDTO;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoApiNfeRepositoryCustom extends JpaRepository<HistoricoApiNfe, Long> {

    public void addPersonByName(String name);

    List<HistoricoApiNfe> buscarPorIdAutorizador(int idAutorizador);

    PaginacaoDTO search(SearchDTO searchDTO);

}
