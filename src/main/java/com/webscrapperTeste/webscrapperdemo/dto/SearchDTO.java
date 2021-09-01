package com.webscrapperTeste.webscrapperdemo.dto;

import java.time.LocalDateTime;

public class SearchDTO {

    LocalDateTime dtInicio;

    LocalDateTime dtFim;

    Integer autorizador;

    public LocalDateTime getDtInicio() {
        return dtInicio;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public Integer getAutorizador() {
        return autorizador;
    }

}
