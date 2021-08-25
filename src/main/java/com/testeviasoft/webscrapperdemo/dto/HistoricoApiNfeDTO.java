package com.testeviasoft.webscrapperdemo.dto;

import com.testeviasoft.webscrapperdemo.enumeration.AutorizadorEnum;

import java.util.Date;

public class HistoricoApiNfeDTO {

    private Long id;
    private AutorizadorEnum autorizador;
    private Date horaAtualizacao;
    private Integer autorizacao4;
    private Integer retornoAutorizacao4;
    private Integer inutilizacao4;
    private Integer consultaProtocolo4;
    private Integer statusServico4;
    private Integer tempoMedio;
    private Integer consultaCadastro4;
    private Integer recepcaoEventos4;

}
