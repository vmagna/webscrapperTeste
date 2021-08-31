package com.webscrapperTeste.webscrapperdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginacaoDTO {

    private int pageCurrent = 1;

    private int pageSize = 0;

    private int totalPages = 0;

    private int totalItens = 0;

    private int fieldOrder = 0;

    private int typeOrder = 0;

    private Iterable<?> data = new ArrayList<>();

    @JsonIgnore
    public String getOrderBy() {
        return this.typeOrder == 1? "DESC" : "ASC";
    }
}
