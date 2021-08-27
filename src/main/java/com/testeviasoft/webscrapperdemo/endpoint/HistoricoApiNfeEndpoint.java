package com.testeviasoft.webscrapperdemo.endpoint;

import com.testeviasoft.webscrapperdemo.controller.HistoricoApiNfeController;
import com.testeviasoft.webscrapperdemo.dto.PaginacaoDTO;
import com.testeviasoft.webscrapperdemo.dto.SearchDTO;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historico-api")
public class HistoricoApiNfeEndpoint {

    @Autowired
    private final HistoricoApiNfeController historicoApiNfeController;

    public HistoricoApiNfeEndpoint(HistoricoApiNfeController historicoApiNfeController) {
        this.historicoApiNfeController = historicoApiNfeController;
    }

    @GetMapping
    public List<HistoricoApiNfe> findAll() {
        return this.historicoApiNfeController.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<HistoricoApiNfe> findById(@PathVariable("id") Long id) {
        return this.historicoApiNfeController.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus( code = HttpStatus.CREATED )
    public HistoricoApiNfe create(@RequestBody HistoricoApiNfe historicoApiNfe) {
        return this.historicoApiNfeController.create(historicoApiNfe);
    }

    @PostMapping("/search")
    @ResponseBody
    @ResponseStatus( code = HttpStatus.OK )
    public PaginacaoDTO search(@RequestBody SearchDTO searchDTO) {
        return this.historicoApiNfeController.search(searchDTO);
    }

    @PostMapping("/maior-indisponibilidade")
    @ResponseBody
    @ResponseStatus( code = HttpStatus.OK )
    public String maiorIndisponibilidade(@RequestBody SearchDTO searchDTO) {
        return this.historicoApiNfeController.maiorIndisponibilidade(searchDTO);
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