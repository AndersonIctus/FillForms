package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalhoBuilder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PDFReader {
    public static DadosVistoTrabalho readFile(String filePath) throws IOException {
        File file = new File(filePath);

        try(PDDocument document = PDDocument.load(file)){
            if(document.isEncrypted()){
                System.out.println("Documento Encriptado!!!");
            }

            PDFTextStripper text = new PDFTextStripper();
            String textDoc = text.getText(document);

            DadosVistoTrabalho questoes = transformaDadosDoQuestionario(textDoc);

            System.out.println(questoes);
            return questoes;
        }
    }

    private static DadosVistoTrabalho transformaDadosDoQuestionario(String textDoc) {
        Map<String, String> respostas = new HashMap<>();
        List<String> listaPerguntas = DadosVistoTrabalhoBuilder.getListaPerguntas();
        for(int i = 0; i < listaPerguntas.size() - 1; i++){
            String perguntaAtual = listaPerguntas.get(i);
            String proximaPergunta = listaPerguntas.get(i+1);

            String resposta = scratchTexto(textDoc, perguntaAtual, proximaPergunta);
            respostas.put(perguntaAtual, resposta);
        }

        DadosVistoTrabalho dadosQuestionario = DadosVistoTrabalhoBuilder.criarDados(respostas);

        return dadosQuestionario;
    }

    private static String scratchTexto(String texto, String atual, String proximo) {
        int inicio = texto.indexOf(atual) + atual.length();
        int fim = texto.indexOf(proximo);

        if(inicio == fim) return "";

        String resposta = texto.substring(inicio, fim-2);
        String[] fmtResposta = resposta.split("\r\n");

        if(fmtResposta.length == 1)
            return fmtResposta[0];

        StringBuilder buffer = new StringBuilder();
        for(String resp: fmtResposta) {
            if(resp.contains("E-mail de Site Imigrar")) continue;
            else if(resp.contains("https://mail.google.com")) continue;

            if(buffer.length() > 0) buffer.append("\r\n");
            buffer.append(resp);
        }

        return buffer.toString();
    }
}
