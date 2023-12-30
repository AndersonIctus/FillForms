package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.FullName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDFFillFormTest {

    @Test
    void fillForm() throws IOException {
        DadosVistoTrabalho dados = new DadosVistoTrabalho();
        dados.setFullname(new FullName("Teste Testando Silva"));

        PDFFillForm.fillForm(dados);
    }
}