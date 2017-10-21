package br.com.semanalixozero.app.schedule;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableList;

/**
 * @author Filipe Bezerra
 */
class MockScheduleDataset {

    private MockScheduleDataset() {}

    private static final List<Schedule> SCHEDULES;

    static {
        SCHEDULES = unmodifiableList(asList(
                // SEX 20/10
                new Schedule(1508464800000L, unmodifiableList(asList(
                        new Event(
                                "ABERTURA SEMANA LIXO ZERO 2017",
                                "Auditório do SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1508493600000L,
                                1508508000000L,
                                "Cerimônia de ABERTURA da SLZ 2017-Goiânia com presença do Setor Público, Privado e terceiro Setor.",
                                "Coffee Break"),
                        new Event(
                                "CICLO de DIÁLOGOS em 3 eixos",
                                "Auditório do SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1508502600000L,
                                1508508000000L,
                                "Compostagem, Coleta Seletiva e Reciclagem e Inovação Tecnológica",
                                ""),
                        new Event(
                                "Exposição de Arte com Materiais Recicláveis",
                                "SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1508502600000L,
                                1508508000000L,
                                "",
                                ""),
                        new Event(
                                "Lançamento da CAMPANHA 240 HORAS RESÍDUO ZERO",
                                "Auditório do SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1508493600000L,
                                0L,
                                "#semanalixozerogoiania\n#240residuozero\n",
                                "Leve seu COPO para o Coffee BREAK"),
                        new Event(
                                "Palestra: Gestão Ambiental, Empreendedorismo Social e Sustentabilidade",
                                "Faculdade Noroeste",
                                "Av. Mangalô QD 216, 2385 - St. Morada do Sol, Goiânia - GO, 74475-115",
                                1508535000000L,
                                1508544000000L,
                                "Palestrantes: Madson Marllo dos Santos Pingarilho - graduado em Agronegócios pela Universo - Universidade Salgado de Oliveira. Engenheiro Ambiental, Pós Graduado em Pericia Ambiental com Habilitação em Engenharia Ambiental.\n" +
                                        "Marcos Antonio da Silva - Coordenador do Projeto Crisálida. Graduando em Ciências Econômicas pela Universidade Federal de Goiás.\n",
                                "")
                ))),
                // SAB 21/10
                new Schedule(1508551200000L, unmodifiableList(asList(
                        new Event(
                                "Projeto Catação – Caminhada e coleta voluntária de lixo",
                                "Parque Flamboyant na ponta de madeira",
                                "Parque Flamboyant, Goiânia - GO, 74860-210",
                                1508583600000L,
                                1508590800000L,
                                "Distribuição de mudas e sementes. Ação voluntária de limpeza do Parque",
                                ""),
                        new Event(
                                "Feira “GO VEGAN” – Lanches, jardinagem e artesanato",
                                "Praça do Moreirinha",
                                "Praça do Moreirinha, AV-T1, S. Bueno",
                                1508608800000L,
                                1508630400000L,
                                "Feira Vegan, tradicional, lanches, artesanatos e feiras de trocas",
                                ""),
                        new Event(
                                "PEDAL DO AVIÃO",
                                "Praça do Avião, em frente ao ITAÚ",
                                "Retorno Praça Santos Dumont - St. Aeroporto, Goiânia - GO, 74030-100",
                                1508607000000L,
                                0L,
                                "Pedal Urbano, Iniciante/Moderado",
                                "")
                ))),
                // DOM 22/10
                new Schedule(1508637600000L, unmodifiableList(singletonList(
                        new Event(
                                "Excursão para Pirinópolis: visita ao poço encantado e vivência em novas práticas de ecoturismo",
                                "Praça Universitária",
                                "Praça Universitária - Setor Leste Universitário, Goiânia - GO",
                                1508666400000L,
                                0L,
                                "02 pernoite em pousada ou camping. Inscrição online",
                                "Saída: 08:00 da praça universitária")
                ))),
                // SEG 23/10
                new Schedule(1508724000000L, unmodifiableList(singletonList(
                        new Event(
                                "CAMPANHA HASHTAG",
                                "Internet",
                                "",
                                1508752800000L,
                                1508810340000L,
                                "Fomento da Campanha #semanalixozerogoiania. Praticar e disseminar as práticas Resíduo Zero",
                                "100% redes sociais")
                ))),
                // TER 24/10
                new Schedule(1508810400000L, unmodifiableList(asList(
                        new Event(
                                "CAMPANHA HASHTAG",
                                "Internet",
                                "",
                                1508839200000L,
                                1508896740000L,
                                "Impulsionar a hashtag #ILZB #SLZG #SRZ #240RESIDUOZERO",
                                ""),
                        new Event(
                                "Aniversário de Goiânia – 84 anos",
                                "Antigo aeroporto de Goiânia",
                                "Alameda 4, s/n - Santa Genoveva, Goiânia - GO, 74672-410",
                                1508839200000L,
                                1508875200000L,
                                "Desfile Cívico Militar, show aéreo e atividades ao ar livre. Um dia dedicado a belíssima cidade de Goiânia, capital das praças e das flores. Serão mais de 50 atrações, acesse: www.goiania.gov.br",
                                "")
                ))),
                // QUA 25/10
                new Schedule(1508896800000L, unmodifiableList(asList(
                        new Event(
                                "Visita Técnica – Usina de compostagem CEASA",
                                "Usina de compostagem CEASA",
                                "Rodovia BR-153, s/n - Jardim Guanabara, Goiânia - GO, 74675-090",
                                1508925600000L,
                                1508940000000L,
                                "Ponto de encontro será no auditório do CEASA",
                                ""),
                        new Event(
                                "DOC ART convida MOOD – filmes do FICA 2017",
                                "MOOD Club",
                                "R. 1145, 39 - St. Marista, Goiânia - GO, 74180-220",
                                1508965200000L,
                                1508976000000L,
                                "1º filme – 19h00 – Ninguém Nasce no Paraíso – Alan Schvarseberg – Dur. 25 min.\n2º filme – Histories de la plaine – Christine Seghezzi – Dur. 72 min.",
                                "Após exibição, debate com:\n" +
                                        "* Mestre. Esp. Gestão de Resíduos Sólidos Diógenes Aires – SEPLANH/GO\n" +
                                        "* Químico Antônio Afonso Bolognani – Gerente de Eventos Sociedade Resíduo Zero\n" +
                                        "*PIPOCA FREE")
                ))),
                // QUI 26/10
                new Schedule(1508983200000L, unmodifiableList(asList(
                        new Event(
                                "MINICURSO – SUSTENTABILIDADE EM CONDOMÍNIOS – Parte 1",
                                "SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1509051600000L,
                                1509062400000L,
                                "Minicurso de Gestão de Resíduos e boas práticas ambientais em condomínios. Inscrição no site do SECOVI.",
                                ""),
                        new Event(
                                "DOC ART convida MOOD – filmes do FICA 2017",
                                "MOOD Club",
                                "R. 1145, 39 - St. Marista, Goiânia - GO, 74180-220",
                                1509051600000L,
                                1509062400000L,
                                "1º filme – Caminho do Mar – Bebeto Abrantes – 86 min.\n2º filme – Minhocas – Sabrina Bogato e Matias Palma – 15 min.",
                                "Após exibição, debate com:\n" +
                                        "* Gerente de Resíduos da AMMA – Biólogo Geovani Tolledo.\n" +
                                        "* Eng. Ambiental Madson - Representante da ONG ÉCOMAMOR\n" +
                                        "*PIPOCA FREE")
                ))),
                // SEX 27/10
                new Schedule(1509069600000L, unmodifiableList(asList(
                        new Event(
                                "Ciclo de palestras técnicas- Semana de Ciências e Tecnologia",
                                "Auditório da Faculdade Araguaia",
                                "Av. T-10, 1047 - St. Bueno, Goiânia - GO, 74175-120",
                                1509138000000L,
                                1509145200000L,
                                "1ª palestra: Me. Camila Abssal – Capitalismo Sustentável\n" +
                                        "2ª palestra: Eng. Ambiental perito Madson M.S. – Gestão de Resíduos Sólidos na Construção Civil\n" +
                                        "3ª palestra: ÉCOMAMOR – Hortas Urbanas",
                                "40 min. cada palestra"),
                        new Event(
                                "MINCURSO – Sustentabilidade em condomínios – Parte 2 – continuação",
                                "SECOVI",
                                "Av. Fued José Sebba, 1122-1558 - Jardim Goiás, Goiânia - GO",
                                1509138000000L,
                                1509148800000L,
                                "MINICURSO de Gestão de Resíduos e boas práticas ambientais em condomínios.",
                                "Inscrição no site SECOVI.")
                ))),
                // SAB 28/10
                new Schedule(1509156000000L, unmodifiableList(asList(
                        new Event(
                                "Projeto DESAPEGA RESÍDUO ZERO",
                                "Rua 215, nº 643, Bairro Vila Nova",
                                "Rua 215, nº 643, Bairro Vila Nova, Goiânia - GO, 74645-140",
                                1509188400000L,
                                1509195600000L,
                                "Venda, troca coletiva ou doação de itens de uso comum",
                                ""),
                        new Event(
                                "DOC ART convida MOOD – filmes do FICA 2017",
                                "MOOD Club",
                                "R. 1145, 39 - St. Marista, Goiânia - GO, 74180-220",
                                1509224400000L,
                                1509235200000L,
                                "1º filme – Ninguém Nasce no Paraíso – Alan Schvarsberg – 25 min.\n" +
                                        "2º filme – KOKOTA: The Islet of Hope – Craig Norris – 29 min",
                                "Após exibição, debate com:\n" +
                                        "* Gerente de Resíduos da AMMA – Geovani Tolledo\n" +
                                        "* Eng Ambiental Esp. Gestão de Resíduos Sólidos e Técnica da FUNASE Camila Batista do Carmo\n" +
                                        "* Representante da ONG ÉCOMAMOR – Rodrigo\n" +
                                        "* Pipoca FREE")
                ))),
                // DOM 29/10
                new Schedule(1509242400000L, unmodifiableList(singletonList(
                        new Event(
                                "Cerimônia de Encerramento da Semana Lixo Zero Goiânia 2017. Pedal Lixo Zero",
                                "Parque Areião em frente a Polícia Federal",
                                "Av. Areião, s/n - St. Pedro Ludovico, Goiânia - GO, 74820-370",
                                1509274800000L,
                                1509280200000L,
                                "Pedal com saída do Parque Areião e chegada no Parque Macambira",
                                "Haverá ato de catação no Parque na saída e chegada.\n" +
                                        "* Café da manhã + água\n" +
                                        "* Pedal Lixo Zero 2017 – 10 K\n" +
                                        "CHEGADA DO PEDAL LIXO ZERO e encerramento da SLZ 2017 Goiânia.")
                )))
        ));
    }

    static List<Schedule> getSchedules() {
        return unmodifiableList(SCHEDULES);
    }
}
