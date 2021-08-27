package com.testeviasoft.webscrapperdemo.controller;

import com.testeviasoft.webscrapperdemo.dto.PaginacaoDTO;
import com.testeviasoft.webscrapperdemo.dto.SearchDTO;
import com.testeviasoft.webscrapperdemo.enumeration.TipoSituacaoEnum;
import com.testeviasoft.webscrapperdemo.repository.HistoricoApiNfeCustomRepository;
import com.testeviasoft.webscrapperdemo.repository.HistoricoApiNfeRepository;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    public String maiorIndisponibilidade(SearchDTO searchDTO) {
        var result = this.historicoApiNfeCustomRepository.maiorIndisponibilidade(searchDTO);

        int[] verde = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] amarelo = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] vermelho = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] verde1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] amarelo1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] vermelho1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] verde2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] amarelo2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] vermelho2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] verde3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] amarelo3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] vermelho3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] verde4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] amarelo4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] vermelho4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] verde5 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] amarelo5 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] vermelho5 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int[] verde6 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] amarelo6 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] vermelho6 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int qtdElem = result.size();
        System.out.println(qtdElem);
        for (int i = 0; i < qtdElem; i++) {
            if (result.get(i).getAutorizacao4() == TipoSituacaoEnum.VERDE) {
                int or = result.get(i).getAutorizador().ordinal();
                verde[or]++;
            }
            if (result.get(i).getAutorizacao4() == TipoSituacaoEnum.AMARELO) {
                int or = result.get(i).getAutorizador().ordinal();
                amarelo[or]++;
            }
            if (result.get(i).getAutorizacao4() == TipoSituacaoEnum.VERMELHO) {
                int or = result.get(i).getAutorizador().ordinal();
                vermelho[or]++;
            }

            if (result.get(i).getRetornoAutorizacao4() == TipoSituacaoEnum.VERDE) {
                int or = result.get(i).getAutorizador().ordinal();
                verde1[or]++;
            }
            if (result.get(i).getRetornoAutorizacao4() == TipoSituacaoEnum.AMARELO) {
                int or = result.get(i).getAutorizador().ordinal();
                amarelo1[or]++;
            }
            if (result.get(i).getRetornoAutorizacao4() == TipoSituacaoEnum.VERMELHO) {
                int or = result.get(i).getAutorizador().ordinal();
                vermelho1[or]++;
            }

            if (result.get(i).getInutilizacao4() == TipoSituacaoEnum.VERDE) {
                int or = result.get(i).getAutorizador().ordinal();
                verde2[or]++;
            }
            if (result.get(i).getInutilizacao4() == TipoSituacaoEnum.AMARELO) {
                int or = result.get(i).getAutorizador().ordinal();
                amarelo2[or]++;
            }
            if (result.get(i).getInutilizacao4() == TipoSituacaoEnum.VERMELHO) {
                int or = result.get(i).getAutorizador().ordinal();
                vermelho2[or]++;
            }

            if (result.get(i).getConsultaProtocolo4() == TipoSituacaoEnum.VERDE) {
                int or = result.get(i).getAutorizador().ordinal();
                verde3[or]++;
            }
            if (result.get(i).getConsultaProtocolo4() == TipoSituacaoEnum.AMARELO) {
                int or = result.get(i).getAutorizador().ordinal();
                amarelo3[or]++;
            }
            if (result.get(i).getConsultaProtocolo4() == TipoSituacaoEnum.VERMELHO) {
                int or = result.get(i).getAutorizador().ordinal();
                vermelho3[or]++;
            }

            if (result.get(i).getStatusServico4() == TipoSituacaoEnum.VERDE) {
                int or = result.get(i).getAutorizador().ordinal();
                verde4[or]++;
            }
            if (result.get(i).getStatusServico4() == TipoSituacaoEnum.AMARELO) {
                int or = result.get(i).getAutorizador().ordinal();
                amarelo4[or]++;
            }
            if (result.get(i).getStatusServico4() == TipoSituacaoEnum.VERMELHO) {
                int or = result.get(i).getAutorizador().ordinal();
                vermelho4[or]++;
            }

            if (result.get(i).getConsultaCadastro4() == TipoSituacaoEnum.VERDE) {
                int or = result.get(i).getAutorizador().ordinal();
                verde5[or]++;
            }
            if (result.get(i).getConsultaCadastro4() == TipoSituacaoEnum.AMARELO) {
                int or = result.get(i).getAutorizador().ordinal();
                amarelo5[or]++;
            }
            if (result.get(i).getConsultaCadastro4() == TipoSituacaoEnum.VERMELHO) {
                int or = result.get(i).getAutorizador().ordinal();
                vermelho5[or]++;
            }

            if (result.get(i).getRecepcaoEventos4() == TipoSituacaoEnum.VERDE) {
                int or = result.get(i).getAutorizador().ordinal();
                verde6[or]++;
            }
            if (result.get(i).getRecepcaoEventos4() == TipoSituacaoEnum.AMARELO) {
                int or = result.get(i).getAutorizador().ordinal();
                amarelo6[or]++;
            }
            if (result.get(i).getRecepcaoEventos4() == TipoSituacaoEnum.VERMELHO) {
                int or = result.get(i).getAutorizador().ordinal();
                vermelho6[or]++;
            }
        }

        int index = 0;
        for(int v : verde) {
            System.out.println(String.format("%s  =>  %s", index, v));
            index++;
        }

        int index2 = 0;
        for(int v2 : verde2) {
            System.out.println(String.format("%s  =>  %s", index2, v2));
            index2++;
        }

        int index3 = 0;
        for(int v3 : verde3) {
            System.out.println(String.format("%s  =>  %s", index3, v3));
            index3++;
        }


        return "";
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