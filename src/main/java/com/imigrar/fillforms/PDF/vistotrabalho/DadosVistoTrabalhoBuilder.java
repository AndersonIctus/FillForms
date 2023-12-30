package com.imigrar.fillforms.PDF.vistotrabalho;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.FullName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DadosVistoTrabalhoBuilder {
    public static final List<String> LISTA_PERGUNTAS = Arrays.asList(
            "Sobrenome completo:\r\n",
            "Primeiro Nome (incluindo nomes compostos):\r\n",
            "Se já usou outro nome, por favor informe aqui (nome de solteiro(a), mudança de nome etc), caso contrário\r\ndeixe em branco.:\r\n",
            "Sexo/Gênero:\r\n",
            "Data de Aniversário:\r\n",
            "Cidade de Nascimento e País:\r\n",
            "Qual seu país de residência? E qual seu status nesse país?:\r\n",
            "Durante os últimos 5 anos, você viveu mais de 6 meses em outro país que não seja o seu país de cidadania\r\nou residência? Se sim, diga qual país, seu status e de que dia até que dia você ficou nesse país.:\r\n",
            "Se não está aplicando do seu território de residência habitual, diga qual país está aplicando, seu status\r\nnesse país e de quando até quando está nesse país. Caso contrário deixe em branco.:\r\n",
            "Qual seu status civil?:\r\n",
            "Se é casado(a) ou em união estável, diga desde quando (dia, mês e ano que casou ou entrou em uma união\r\nestável):\r\n",
            "Nome do Cônjuge (se for solteiro(a), deixe em branco):\r\n",
            "Quais as línguas oficias do Canadá você consegue se comunicar?:\r\n",
            "Você fez um teste de inglês ou francês para poder entrar no College/Universiade? Se sim, diga qual, caso\r\ncontrário responda: não.:\r\n",
            "Qual o número do seu passaporte? (Duas letras seguidas de 6 números):\r\n",
            "Em qual país o passaporte foi emitido?:\r\n",
            "Data de Emissão do passaporte:\r\n",
            "Data de Vencimento do passaporte:\r\n",
            "Coloque abaixo as informações ou do seu RG ou da sua Carteira Nacional de Habilitação: Número do\r\nDocumento, País emissor, Data de Emissão e Data de Vencimento (para RG deixe em branco):\r\n",
            "Você tem o Green Card Americano?:\r\n",
            "Endereço completo (Rua, Número, Cidade, Bairro e CEP):\r\n",
            "Número do Telefone (diga se é residencial ou celular):\r\n",
            "Você tem um emprego certo no Canadá (com LMIA ou LMIA-exempt)? Se sim dê as seguintes informações:-\r\nNome do Empregador/ Endereço Completo do Empregador / Cargo Pretendido.Se está indo como cônjuge de\r\num estudante, deixe em branco.:\r\n",
            "Você tem algum curso pós-secundário? (Tecnólogo, bacharel, pós-graduação, mestrado ou doutorado? Se\r\nsim dê as seguintes informações:- Área de estudo/ Cidade / Nome da instituição/ Mês e Ano do começo e\r\nMês e Ano do final do curso.:\r\n",
            "Forneça todos os empregos que você teve nos últimos 10 anos, começando pelo mais recente para o menos\r\nrecente. Dando as seguintes informações para cada profissão: Nome do Cargo/ Cidade/ Nome da Empresa\r\nou Empregador/ Mês e Ano do começo e Mês e Ano do final do emprego.:\r\n",
            "Nos últimos 2 anos, você ou alguém das sua família teve tuberculose?:\r\n",
            "Você tem alguma condição menta ou física que precisa de algum tipo de tratamento no Canadá que não seja\r\napenas medicação?:\r\n",
            "Alguma vez você ficou além da validade do seu status, estudou sem visto de estudo ou trabalhou sem visto\r\nde trabalho no Canadá?:\r\n",
            "Alguma vez você teve um visto negado para o Canadá ou para algum outro país?:\r\n",
            "Você já aplicou para um visto canadense no passado ou já veio para o Canadá no passado?:\r\n",
            "Você já foi preso, acusado de algum crime em qualquer país do mundo?:\r\n",
            "Você já serviu ao exército, Marinha, aeronautica defesa civil ou força policial no passado? Caso positivo, no\r\nquadro abaixo coloque as datas (mês e ano que começou até mês e ano que terminou), localização\r\n(regimento, centro etc) e a cidade e país.:\r\n",
            "Se respondeu sim para alguma das 7 perguntas acima, dê detalhes abaixo. Caso contrário digite N/A.:\r\n",
            "Liste todas as viagens internacionais que você já fez. Começe pela a mais recente e liste o ano e o motivo\r\n(turismo, estudo, negócios etc). Se não fez nenhuma, escreva que não fez.:\r\n",
            "Se esteve no Canadá escreva a data de entrada e saída do país. Se por acaso tiver um visto canadense\r\nválido ou ETA dar detalhes abaixo.:\r\n",
            "Nome completo da sua mãe:\r\n",
            "Nome completo de SOLTEIRA da sua mãe:\r\n",
            "Status Civil da sua mãe:\r\n",
            "Data de nascimento da sua mãe:\r\n",
            "Local de nascimento da sua mãe (Cidade, estado e País):\r\n",
            "Atual profissão da sua mãe:\r\n",
            "Atual endereço da sua mãe:\r\n",
            "Se sua mãe for falecida, escreva a data do óbito e a cidade aonde faleceu, caso contrário escreva nada a\r\ndeclarar.:\r\n",
            "Nome completo do seu pai:\r\n",
            "Status Civil do seu pai:\r\n",
            "Data de nascimento do seu pai:\r\n",
            "Local de nascimento do seu pai (Cidade, estado e País):\r\n",
            "Atual profissão do seu pai:\r\n",
            "Atual endereço do seu pai:\r\n",
            "Se sua pai for falecido, escreva a data do óbito e a cidade aonde faleceu, caso contrário escreva nada a\r\ndeclarar.:\r\n",
            "Se tiver filhos que irão com você para o Canadá. Escrever o nome, data de nascimento, país de nascimento,\r\nnome da escola que ele(a) estuda e a série (se for uma criança que não está em idade escolar, escreva: \"não\r\nestuda ainda\"). Se for enteado(a), favor especificar.Se não tiver filhos, digite: Nada a declarar.:\r\n",
            "Se tiver filhos que não irão com você para o Canadá (ou filhos de outras relações). Escrever o nome, data de\r\nnascimento, país de nascimento, endereço atual e profissão atual.:\r\n",

            "Se tiver irmãos ou meio-irmãos escrever PARA CADA UM DOS IRMÃOS o nome, data de nascimento, país de\r\nnascimento, endereço atual, status civil (se casado no civil, união estável, solteiro, viúvo ou divorciado) e\r\nprofissão atual. Se não tiver, coloque Nada a declarar.:\r\n",
            "Time:" // Fim de busca ...
    );

    public static List<String> getListaPerguntas() {
        return LISTA_PERGUNTAS;
    }

    public static DadosVistoTrabalho criarDados(Map<String, String> perguntas) {
        DadosVistoTrabalho dados = new DadosVistoTrabalho();

        int index = 0;

        // Personal Details
        dados.setFullname(new FullName(getResponse(0, perguntas), getResponse(1, perguntas)));

        return dados;
    }

    private static String getResponse(int questao, Map<String, String> perguntasERespostas) {
        String resposta = perguntasERespostas.get(LISTA_PERGUNTAS.get(questao));
        return resposta == null
                ? ""
                : resposta;
    }
}
