package com.testeviasoft.webscrapperdemo.util;

import com.testeviasoft.webscrapperdemo.controller.HistoricoApiNfeController;
import com.testeviasoft.webscrapperdemo.orm.HistoricoApiNfe;
import com.testeviasoft.webscrapperdemo.enumeration.AutorizadorEnum;
import com.testeviasoft.webscrapperdemo.enumeration.TipoSituacaoEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@EnableScheduling
public class ScrampperService {
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 2;// TEMPO EM MILLISEGUNDOS

    private final HistoricoApiNfeController historicoApiNfeController;

    public ScrampperService(HistoricoApiNfeController historicoApiNfeController) {
        this.historicoApiNfeController = historicoApiNfeController;
    }

    @Scheduled(fixedRate = HORA)
    public void verificaPorHora() throws IOException {
        String url = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";

        // Conectar o Jsoup na url
        Document doc = Jsoup.connect(url).get();

        // Usando seletor da table para capturar dados
        Elements tableDados = doc.select(".tabelaListagemDados > tbody tr");

        int cont = 0;
        for (Element headline : tableDados) {

            System.out.println(String.format("%s => %s", cont, headline.select("td:eq(0)")));

            String tdValor = headline.select("td:eq(0)").text().replace(" ", "").replace("-", "");

            if ( cont > 0 ){
                this.historicoApiNfeController.create(
                        new HistoricoApiNfe(
                                AutorizadorEnum.valueOf(tdValor),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(1)"))),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(2)"))),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(3)"))),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(4)"))),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(5)"))),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(6)"))),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(7)"))),
                                TipoSituacaoEnum.getTipoSituacaoEnum(String.format("%s",headline.select("td:eq(8)"))),
                                LocalDateTime.now()
                        ));
            }
            cont++;

        }

    }

}
