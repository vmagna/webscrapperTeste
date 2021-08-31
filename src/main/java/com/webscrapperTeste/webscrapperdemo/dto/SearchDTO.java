package com.webscrapperTeste.webscrapperdemo.dto;

import java.time.LocalDateTime;

public class SearchDTO {

    LocalDateTime dtInicio;

    LocalDateTime dtFim;

    Integer autorizador;

    Integer campoOrder;

    Integer typeOrder;

    public LocalDateTime getDtInicio() {
        return dtInicio;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public Integer getAutorizador() {
        return autorizador;
    }

    public Integer getCampoOrder() {
        return campoOrder;
    }

    public Integer getTypeOrder() {
        return typeOrder;
    }

}
