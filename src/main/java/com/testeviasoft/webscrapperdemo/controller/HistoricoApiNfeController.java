package com.testeviasoft.webscrapperdemo.controller;

import com.testeviasoft.webscrapperdemo.dto.PaginacaoDTO;
import com.testeviasoft.webscrapperdemo.dto.SearchDTO;
import com.testeviasoft.webscrapperdemo.repository.HistoricoApiNfeCustomRepository;
import com.testeviasoft.webscrapperdemo.repository.HistoricoApiNfeRepository;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historico-api")
public class HistoricoApiNfeController {

    @Autowired
    private final HistoricoApiNfeRepository historicoApiNfeRepository;
    private final HistoricoApiNfeCustomRepository historicoApiNfeCustomRepository;

    public HistoricoApiNfeController(HistoricoApiNfeRepository historicoApiNfeRepository,
                                     HistoricoApiNfeCustomRepository historicoApiNfeCustomRepository) {
        this.historicoApiNfeRepository = historicoApiNfeRepository;
        this.historicoApiNfeCustomRepository = historicoApiNfeCustomRepository;
    }

    public List<HistoricoApiNfe> findAll() {
        return this.historicoApiNfeRepository.findAll();
    }

    public Optional<HistoricoApiNfe> findById(@PathVariable("id") Long id) {
        return this.historicoApiNfeRepository.findById(id);
    }

    public HistoricoApiNfe create(HistoricoApiNfe historicoApiNfe) {
        this.historicoApiNfeRepository.save(historicoApiNfe);
        return historicoApiNfe;
    }

    public PaginacaoDTO search(SearchDTO searchDTO) {
        return this.historicoApiNfeCustomRepository.search(searchDTO);
    }

//    @PutMapping("/{id}")
//    @ResponseStatus( code = HttpStatus.NO_CONTENT )
//    public void updateById(@PathVariable("id") Long id, @RequestBody HistoricoApiNfe historicoApiNfe) {
//        this.historicoApiNfeRepository.findById(id).map(record -> {
//            record.setAutorizador(historicoApiNfe.getAutorizador());
//            record.setAutorizacao4(historicoApiNfe.getAutorizacao4());
//            record.setRetornoAutorizacao4(historicoApiNfe.getRetornoAutorizacao4());
//            record.setInutilizacao4(historicoApiNfe.getInutilizacao4());
//            record.setConsultaProtocolo4(historicoApiNfe.getConsultaProtocolo4());
//            record.setStatusServico4(historicoApiNfe.getStatusServico4());
//            record.setTempoMedio(historicoApiNfe.getTempoMedio());
//            record.setConsultaCadastro4(historicoApiNfe.getConsultaCadastro4());
//            record.setRecepcaoEventos4(historicoApiNfe.getRecepcaoEventos4());
//            return this.historicoApiNfeRepository.save(record);// metodo save é usado para POST e também para PUT
//        });
//    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus( code = HttpStatus.NO_CONTENT )
//    public void removeById(@PathVariable("id") Long id) {
//        this.historicoApiNfeRepository.deleteById(id);
//    }

}