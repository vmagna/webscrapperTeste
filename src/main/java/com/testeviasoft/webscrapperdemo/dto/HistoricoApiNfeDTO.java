package com.testeviasoft.webscrapperdemo.dto;

import com.testeviasoft.webscrapperdemo.enumeration.AutorizadorEnum;
import com.testeviasoft.webscrapperdemo.enumeration.TipoSituacaoEnum;
import java.time.LocalDateTime;

public class HistoricoApiNfeDTO {
    private Long id;
    private AutorizadorEnum autorizador;
    private LocalDateTime horaAtualizacao;
    private TipoSituacaoEnum autorizacao4;
    private TipoSituacaoEnum retornoAutorizacao4;
    private TipoSituacaoEnum inutilizacao4;
    private TipoSituacaoEnum consultaProtocolo4;
    private TipoSituacaoEnum statusServico4;
    private TipoSituacaoEnum tempoMedio;
    private TipoSituacaoEnum consultaCadastro4;
    private TipoSituacaoEnum recepcaoEventos4;

    public HistoricoApiNfeDTO(Long id, AutorizadorEnum autorizador, LocalDateTime horaAtualizacao,
                              TipoSituacaoEnum autorizacao4, TipoSituacaoEnum retornoAutorizacao4,
                              TipoSituacaoEnum inutilizacao4, TipoSituacaoEnum consultaProtocolo4,
                              TipoSituacaoEnum statusServico4, TipoSituacaoEnum tempoMedio,
                              TipoSituacaoEnum consultaCadastro4,
                              TipoSituacaoEnum recepcaoEventos4) {
        this.id = id;
        this.autorizador = autorizador;
        this.horaAtualizacao = horaAtualizacao;
        this.autorizacao4 = autorizacao4;
        this.retornoAutorizacao4 = retornoAutorizacao4;
        this.inutilizacao4 = inutilizacao4;
        this.consultaProtocolo4 = consultaProtocolo4;
        this.statusServico4 = statusServico4;
        this.tempoMedio = tempoMedio;
        this.consultaCadastro4 = consultaCadastro4;
        this.recepcaoEventos4 = recepcaoEventos4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AutorizadorEnum getAutorizador() {
        return autorizador;
    }

    public void setAutorizador(AutorizadorEnum autorizador) {
        this.autorizador = autorizador;
    }

    public LocalDateTime getHoraAtualizacao() {
        return horaAtualizacao;
    }

    public void setHoraAtualizacao(LocalDateTime horaAtualizacao) {
        this.horaAtualizacao = horaAtualizacao;
    }

    public TipoSituacaoEnum getAutorizacao4() {
        return autorizacao4;
    }

    public void setAutorizacao4(TipoSituacaoEnum autorizacao4) {
        this.autorizacao4 = autorizacao4;
    }

    public TipoSituacaoEnum getRetornoAutorizacao4() {
        return retornoAutorizacao4;
    }

    public void setRetornoAutorizacao4(TipoSituacaoEnum retornoAutorizacao4) {
        this.retornoAutorizacao4 = retornoAutorizacao4;
    }

    public TipoSituacaoEnum getInutilizacao4() {
        return inutilizacao4;
    }

    public void setInutilizacao4(TipoSituacaoEnum inutilizacao4) {
        this.inutilizacao4 = inutilizacao4;
    }

    public TipoSituacaoEnum getConsultaProtocolo4() {
        return consultaProtocolo4;
    }

    public void setConsultaProtocolo4(TipoSituacaoEnum consultaProtocolo4) {
        this.consultaProtocolo4 = consultaProtocolo4;
    }

    public TipoSituacaoEnum getStatusServico4() {
        return statusServico4;
    }

    public void setStatusServico4(TipoSituacaoEnum statusServico4) {
        this.statusServico4 = statusServico4;
    }

    public TipoSituacaoEnum getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(TipoSituacaoEnum tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public TipoSituacaoEnum getConsultaCadastro4() {
        return consultaCadastro4;
    }

    public void setConsultaCadastro4(TipoSituacaoEnum consultaCadastro4) {
        this.consultaCadastro4 = consultaCadastro4;
    }

    public TipoSituacaoEnum getRecepcaoEventos4() {
        return recepcaoEventos4;
    }

    public void setRecepcaoEventos4(TipoSituacaoEnum recepcaoEventos4) {
        this.recepcaoEventos4 = recepcaoEventos4;
    }
}
