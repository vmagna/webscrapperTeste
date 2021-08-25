package com.testeviasoft.webscrapperdemo.enumeration;

public enum TipoSituacaoEnum {
    VAZIO,
    VERDE,
    AMARELO,
    VERMELHO;
//    SPAN,
//    TD;

    public static TipoSituacaoEnum getTipoSituacaoEnum(String ref) {
        return switch (ref) {
            case "<td><img src=\"imagens/bola_verde_P.png\"></td>" -> TipoSituacaoEnum.VERDE;
            case "<td><img src=\"imagens/bola_amarela_P.png\"></td>" -> TipoSituacaoEnum.AMARELO;
            case "<td><img src=\"imagens/bola_vermelha_P.png\"></td>" -> TipoSituacaoEnum.VERMELHO;
//            case "<td><span></span></td>" -> TipoSituacaoEnum.SPAN;
//            case "<td>-</td>" -> TipoSituacaoEnum.TD;
            default -> TipoSituacaoEnum.VAZIO;
        };
    }

}
