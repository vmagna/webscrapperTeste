package com.webscrapperTeste.webscrapperdemo.orm;

import com.webscrapperTeste.webscrapperdemo.enumeration.AutorizadorEnum;
import com.webscrapperTeste.webscrapperdemo.enumeration.TipoSituacaoEnum;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_api")
public class HistoricoApiNfe {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "hora_atualicazao", updatable = false)
    private LocalDateTime horaAtualizacao = LocalDateTime.now();

    @Column(name = "autorizador")
    @Enumerated(value = EnumType.ORDINAL)
    private AutorizadorEnum autorizador;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum autorizacao4;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum retornoAutorizacao4;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum inutilizacao4;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum consultaProtocolo4;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum statusServico4;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum tempoMedio;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum consultaCadastro4;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private TipoSituacaoEnum recepcaoEventos4;

    public HistoricoApiNfe() {}

    public HistoricoApiNfe(AutorizadorEnum autorizador,
                           TipoSituacaoEnum autorizacao4,
                           TipoSituacaoEnum retornoAutorizacao4,
                           TipoSituacaoEnum inutilizacao4,
                           TipoSituacaoEnum consultaProtocolo4,
                           TipoSituacaoEnum statusServico4,
                           TipoSituacaoEnum tempoMedio,
                           TipoSituacaoEnum consultaCadastro4,
                           TipoSituacaoEnum recepcaoEventos4,
                           LocalDateTime horaAtualizacao) {
        this.autorizador = autorizador;
        this.autorizacao4 = autorizacao4;
        this.retornoAutorizacao4 = retornoAutorizacao4;
        this.inutilizacao4 = inutilizacao4;
        this.consultaProtocolo4 = consultaProtocolo4;
        this.statusServico4 = statusServico4;
        this.tempoMedio = tempoMedio;
        this.consultaCadastro4 = consultaCadastro4;
        this.recepcaoEventos4 = recepcaoEventos4;
        this.horaAtualizacao = horaAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraAtualizacao() {
        return horaAtualizacao;
    }

    public void setHoraAtualizacao(LocalDateTime horaAtualizacao) {
        this.horaAtualizacao = horaAtualizacao;
    }

    public AutorizadorEnum getAutorizador() {
        return autorizador;
    }

    public void setAutorizador(AutorizadorEnum autorizador) {
        this.autorizador = autorizador;
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
