package br.com.semanalixozero.app.schedule;

import java.util.List;

import br.com.semanalixozero.app.event.Event;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Filipe Bezerra
 */
class MockScheduleDataset {

    private MockScheduleDataset() {
    }

    private static final List<Schedule> SCHEDULES;

    static {
        SCHEDULES = unmodifiableList(asList(
                // SEX 20/10
                new Schedule(1508464800000L, unmodifiableList(asList(
                        new Event(
                                "Abertura SEMANA LIXO ZERO GOIÂNIA 2017",
                                "Auditório do SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1508493600000L,
                                1508508000000L,
                                "<p>" +
                                        "Coffee Break" +
                                        "<br>" +
                                        "Cerimônia de ABERTURA da SLZ 2017-Goiânia com presença do Setor Público, Privado e terceiro Setor." +
                                        "</p>" +
                                        "<p>" +
                                        "* CICLO de DIÁLOGOS" +
                                        "<br>" +
                                        "1- Compostagem" +
                                        "<br>" +
                                        "2- Coleta Seletiva e Reciclagem" +
                                        "<br>" +
                                        "3- Inovação Tecnológica" +
                                        "<br>" +
                                        "* Exposição de Arte com Materiais Recicláveis" +
                                        "<br>" +
                                        "* Lançamento da CAMPANHA 240 HORAS RESÍDUO ZERO. #semanalixozerogoiania" +
                                        "<br>" +
                                        "#240residuozero" +
                                        "<br>" +
                                        "OBSERVAÇÃO:" +
                                        "<br>" +
                                        "Leve seu COPO para o Coffee BREAK." +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/abertura-slz-goiania-2017/"),
                        new Event(
                                "PALESTRA – Gestão Ambiental, Empreendedorismo Social e Sustentabilidade.",
                                "Faculdade Noroeste",
                                "Av. Mangalô QD 216, 2385 - St. Morada do Sol, Goiânia - GO, 74475-115",
                                1508535000000L,
                                1508544000000L,
                                "<p>" +
                                        "Palestrantes: Madson Marllo dos Santos Pingarilho – graduado em Agronegócios pela Universo – Universidade Salgado de Oliveira. Engenheiro Ambiental, Pós Graduado em Pericia Ambiental com Habilitação em Engenharia Ambiental." +
                                        "<br>" +
                                        "Marcos Antonio da Silva – Coordenador do Projeto Crisálida. Graduando em Ciências Econômicas pela Universidade Federal de Goiás." +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/palestra-gestao-ambiental-empreendedorismo-social-e-sustentabilidade/")
                ))),

                // SAB 21/10
                new Schedule(1508551200000L, unmodifiableList(asList(
                        new Event(
                                "Projeto Catação – Caminhada e coleta voluntária de lixo",
                                "Parque Flamboyant na ponta de madeira",
                                "Parque Flamboyant, Goiânia - GO, 74860-210",
                                1508583600000L,
                                1508590800000L,
                                "<p>Distribuição de mudas e sementes. Ação voluntária de limpeza do Parque</p>",
                                "http://semanalixozero.com.br/goiania/projeto-catacao-vai-ao-parque/"),
                        new Event(
                                "Feira “GO VEGAN” – Lanches, jardinagem e artesanato",
                                "Praça do Moreirinha",
                                "Praça do Moreirinha, AV-T1, S. Bueno",
                                1508608800000L,
                                1508630400000L,
                                "<p>Feira Vegan, tradicional, lanches, artesanatos e feiras de trocas</p>",
                                "http://semanalixozero.com.br/goiania/feira-go-vegan/"),
                        new Event(
                                "Pedal do AVIÃO",
                                "Praça do Avião, em frente ao ITAÚ",
                                "Retorno Praça Santos Dumont - St. Aeroporto, Goiânia - GO, 74030-100",
                                1508607000000L,
                                0L,
                                "Pedal Urbano, Iniciante/Moderado",
                                "http://semanalixozero.com.br/goiania/pedal-do-aviao/")
                ))),

                // DOM 22/10
                new Schedule(1508637600000L, unmodifiableList(emptyList(

                ))),

                // SEG 23/10
                new Schedule(1508724000000L, unmodifiableList(asList(
                        new Event(
                                "CAMPANHA HASHTAG #SLZ #ILZ #SRZ #semanaLIXOZERO",
                                "Internet",
                                "",
                                1508752800000L,
                                1508810340000L,
                                "<p>" +
                                        "Fomento da Campanha" +
                                        "<br>" +
                                        "#semanalixozerogoiania" +
                                        "<br>" +
                                        "Praticar e disseminar as práticas Resíduo Zero" +
                                        "<br>" +
                                        "100% redes sociais" +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/campanha-hashtag-slz-ilz-srz-semanalixozero/"),
                        new Event(
                                "CAMPANHA HASHTAG #240residuozero #sociedaderesiduozero",
                                "Internet",
                                "",
                                1508752800000L,
                                1508810340000L,
                                "<p>" +
                                        "Impulsionar a hashtag" +
                                        "<br>" +
                                        "#ILZB #SLZG #SRZ #240RESIDUOZERO" +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/campanha-hashtag-240residuozero-sociedaderesiduozero/")
                ))),

                // TER 24/10
                new Schedule(1508810400000L, unmodifiableList(singletonList(
                        new Event(
                                "Aniversário de Goiânia – 84 anos",
                                "Antigo aeroporto de Goiânia",
                                "Alameda 4, s/n - Santa Genoveva, Goiânia - GO, 74672-410",
                                1508839200000L,
                                1508875200000L,
                                "<p>" +
                                        "Desfile Cívico Militar, show aéreo e atividades ao ar livre. Um dia dedicado a belíssima cidade de Goiânia, capital das praças e das flores. Serão mais de 50 atrações, acesse: <a href=\"http://www.goiania.gov.br\" rel=\"noopener\" target=\"_blank\">ANIVERSARIO DE GOIANIA 84 anos.</a>" +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/aniversario-de-goiania-84-anos/")
                ))),

                // QUA 25/10
                new Schedule(1508896800000L, unmodifiableList(asList(
                        new Event(
                                "VISITA TÉCNICA – Usina de Compostagem CEASA-GO",
                                "Usina de compostagem CEASA",
                                "Rodovia BR-153, s/n - Jardim Guanabara, Goiânia - GO, 74675-090",
                                1508925600000L,
                                1508940000000L,
                                "<p>Ponto de encontro será no auditório do CEASA – perguntar na portaria do CEASA-GO</p>",
                                "http://semanalixozero.com.br/goiania/visita-tecnica-usina-de-compostagem-ceasa-go/"),
                        new Event(
                                "DOC ART convida MOOD – filmes do FICA 2017",
                                "MOOD Club",
                                "R. 1145, 39 - St. Marista, Goiânia - GO, 74180-220",
                                1508965200000L,
                                1508976000000L,
                                "<p>" +
                                        "1º filme – 19h00 – Ninguém Nasce no Paraíso – Alan Schvarseberg – Dur. 25 min." +
                                        "<br>" +
                                        "2º filme – Histories de la plaine – Christine Seghezzi – Dur. 72 min." +
                                        "<br>" +
                                        "Após exibição, debate com:" +
                                        "<br>" +
                                        "* Mestre. Esp. Gestão de Resíduos Sólidos Diógenes Aires – SEPLANH/GO" +
                                        "<br>" +
                                        "* Químico Antônio Afonso Bolognani – Gerente de Eventos Sociedade Resíduo Zero" +
                                        "<br>" +
                                        "*ENTRADA FRANCA" +
                                        "<br>" +
                                        "*PIPOCA FREE" +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/doc-art-convida-mood-para-exibir-os-filmes-do-fica-2017/")
                ))),

                // QUI 26/10
                new Schedule(1508983200000L, unmodifiableList(asList(
                        new Event(
                                "MINICURSO – SUSTENTABILIDADE EM CONDOMÍNIOS – Parte 1",
                                "SECOVI Goiânia",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1509051600000L,
                                1509062400000L,
                                "<p>Minicurso de Gestão de Resíduos e boas práticas ambientais em condomínios. Inscrição no site do SECOVI.</p>",
                                "http://semanalixozero.com.br/goiania/minicurso-sustentabilidade-em-condominios-parte-1/"),
                        new Event(
                                "DOC ART convida MOOD para exibir os filmes do FICA 2017",
                                "MOOD Club",
                                "R. 1145, 39 - St. Marista, Goiânia - GO, 74180-220",
                                1509051600000L,
                                1509062400000L,
                                "<p>" +
                                        "MOSTRA COMPETITIVA" +
                                        "<br>" +
                                        "<br>" +
                                        "Após exibição, debate com:" +
                                        "<br>" +
                                        "* Gerente de Resíduos da AMMA – Biólogo Geovani Tolledo." +
                                        "<br>" +
                                        "* Eng. Ambiental Madson – Representante da ONG ÉCOMAMOR" +
                                        "<br>" +
                                        "*PIPOCA FREE" +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/doc-art-convida-mood-para-exibir-os-filmes-do-fica-2017-2/")
                ))),

                // SEX 27/10
                new Schedule(1509069600000L, unmodifiableList(asList(
                        new Event(
                                "Ciclo de palestras técnicas – Semana de Ciências e Tecnologia",
                                "Auditório da Faculdade Araguaia",
                                "Av. T-10, 1047 - St. Bueno, Goiânia - GO, 74175-120",
                                1509138000000L,
                                1509145200000L,
                                "<p>" +
                                        "1ª palestra: Me. Camila Abssal – Capitalismo Sustentável" +
                                        "<br>" +
                                        "2ª palestra: Eng. Ambiental perito Madson M.S. – Gestão de Resíduos Sólidos na Construção Civil" +
                                        "<br>" +
                                        "3ª palestra: ÉCOMAMOR – Hortas Urbanas" +
                                        "<br>" +
                                        "40 min cada palestra" +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/ciclo-de-palestras-tecnicas-semana-de-ciencias-e-tecnologia/"),
                        new Event(
                                "MINCURSO – Sustentabilidade em condomínios – Parte 2 – continuação",
                                "SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1509138000000L,
                                1509148800000L,
                                "<p>MINICURSO de Gestão de Resíduos e boas práticas ambientais em condomínios. Inscrição no site SECOVI.</p>",
                                "http://semanalixozero.com.br/goiania/mincurso-sustentabilidade-em-condominios-parte-2-continuacao/")
                ))),

                // SAB 28/10
                new Schedule(1509156000000L, unmodifiableList(asList(
                        new Event(
                                "Projeto DESAPEGA RESÍDUO ZERO",
                                "Rua 215, nº 643, Bairro Vila Nova",
                                "Rua 215, nº 643, Bairro Vila Nova, Goiânia - GO, 74645-140",
                                1509188400000L,
                                1509195600000L,
                                "<p>" +
                                        "Venda, troca coletiva ou doação de itens de uso comum" +
                                        "<br>" +
                                        "Gratuito." +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/projeto-desapega-residuo-zero/"),
                        new Event(
                                "DOC ART convida MOOD – filmes do FICA 2017",
                                "MOOD Club",
                                "R. 1145, 39 - St. Marista, Goiânia - GO, 74180-220",
                                1509224400000L,
                                1509235200000L,
                                "<p>" +
                                        "MOSTRA COMPETITIVA" +
                                        "<br>" +
                                        "<br>" +
                                        "Após exibição, debate com:" +
                                        "<br>" +
                                        "* Gerente de Resíduos da AMMA – Geovani Tolledo" +
                                        "<br>" +
                                        "* Eng Ambiental Esp. Gestão de Resíduos Sólidos e Técnica da FUNASE Camila Batista do Carmo" +
                                        "<br>" +
                                        "* Representante da ONG ÉCOMAMOR – Rodrigo" +
                                        "<br>" +
                                        "* Pipoca FREE" +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/doc-art-convida-mood-para-exibir-filmes-do-fica-2017/")
                ))),

                // DOM 29/10
                new Schedule(1509242400000L, unmodifiableList(singletonList(
                        new Event(
                                "PEDAL LIXO ZERO – Cerimônia de Encerramento da Semana Lixo Zero Goiânia 2017",
                                "Parque Areião em frente a Polícia Federal",
                                "Av. Areião, s/n - St. Pedro Ludovico, Goiânia - GO, 74820-370",
                                1509274800000L,
                                1509280200000L,
                                "<p>" +
                                        "Haverá ato de catação no Parque na saída e chegada." +
                                        "<br>" +
                                        "* Café da manhã + água" +
                                        "<br>" +
                                        "* Pedal Lixo Zero 2017 – 10 K" +
                                        "<br>" +
                                        "CHEGADA DO PEDAL LIXO ZERO e encerramento da SLZ 2017 Goiânia." +
                                        "<br>" +
                                        "Pedal com saída do Parque Areião e chegada no Parque Macambira." +
                                        "</p>",
                                "http://semanalixozero.com.br/goiania/pedal-lixo-zero-cerimonia-de-encerramento-da-semana-lixo-zero-goiania-2017/")
                )))
        ));
    }

    static List<Schedule> getSchedules() {
        return unmodifiableList(SCHEDULES);
    }
}
