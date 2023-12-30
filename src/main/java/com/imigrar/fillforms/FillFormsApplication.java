package com.imigrar.fillforms;

import com.imigrar.fillforms.PDF.PDFFillForm;
import com.imigrar.fillforms.PDF.PDFReader;
import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;

import java.io.IOException;

public class FillFormsApplication {

	public static void main(String... args) throws IOException {
		System.out.println("#######################################################");
		System.out.println("############## PROCESSANDO FORMULÁRIO ##############");
		System.out.println("** Processando o Arquivo => " + args[0]);

		DadosVistoTrabalho dados = PDFReader.readFile(args[0]);


		PDFFillForm.fillForm(dados);

	}
}
