package com.testeviasoft.webscrapperdemo.dto;

import java.time.LocalDateTime;

public class SearchDTO {

    LocalDateTime dtInicio;

    LocalDateTime dtFim;

    Integer autorizador;

    public LocalDateTime getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDateTime dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDateTime dtFim) {
        this.dtFim = dtFim;
    }

    public Integer getAutorizador() {
        return autorizador;
    }

    public void setAutorizador(Integer autorizador) {
        this.autorizador = autorizador;
    }
}
