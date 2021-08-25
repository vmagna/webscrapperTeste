package com.testeviasoft.webscrapperdemo.enumeration;

public enum AutorizadorEnum {
    SEM_MARCACAO("Desconhecido"),
    AM("AM"),
    BA("BA"),
    CE("CE"),
    GO("GO"),
    MG("MG"),
    MS("MS"),
    MT("MT"),
    PE("PE"),
    PR("PR"),
    RS("RS"),
    SP("SP"),
    SVAN("SVAN"),
    SVRS("SVRS"),
    SVCAN("SVC-AN"),
    SVCRS("SVC-RS");

    String name;

    AutorizadorEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
