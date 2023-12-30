package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDFReaderTest {

    @Test
    void readFile() throws IOException {
        String filename = "testFileReader.pdf";
//        String filename = "imm1295e.pdf";
        final DadosVistoTrabalho dadosVistoTrabalho = PDFReader.readFile(filename);
    }
}