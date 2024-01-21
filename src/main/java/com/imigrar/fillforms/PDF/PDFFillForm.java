package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFFillForm {
//    private static String NOME_FORMULARIO = "imm1295e.pdf";
    private static String NOME_FORMULARIO = "testFileReader.pdf";

    public static void fillForm(DadosVistoTrabalho dados) throws IOException {
		System.out.println("** Gravando Dados para o formulario => " + NOME_FORMULARIO);
        File file = new File(NOME_FORMULARIO);

        // Carregar o formulario - Criando uma copia
        try(PDDocument pdfDocument = PDDocument.load(file)){
            if(pdfDocument.isEncrypted()){
//            pdfDocument.setAllSecurityToBeRemoved(true);
                System.out.println("Arquivo está encripitado!!!!");
                // pdfDocument.decrypt("");
                AccessPermission ap = new AccessPermission();
                ap.setCanExtractContent(true);
                ap.setCanFillInForm(true);
                ap.setCanAssembleDocument(true);
                ap.setCanModify(true);

                StandardProtectionPolicy spp = new StandardProtectionPolicy("", "", ap);
                spp.setEncryptionKeyLength(128);

                spp.setPermissions(ap);
                pdfDocument.protect(spp);

//                pdfDocument.setAllSecurityToBeRemoved(true);
                // save a copy of the file
//                pdfDocument.save(
//                        String.format("%s - %s - IMM1295e - Complete.pdf", dados.getFullname().getFamilyName(), dados.getFullname().getGivenName())
//                );
//
//                return;
            }

            final PDDocumentCatalog documentCatalog = pdfDocument.getDocumentCatalog();
            PDAcroForm acroForm = documentCatalog.getAcroForm();

            final List<PDField> fields = acroForm.getFields();
            for(PDField field : fields) {
                System.out.println("Name => " + field.getFullyQualifiedName());
                final List<PDAnnotationWidget> widgets = field.getWidgets();
                for(PDAnnotationWidget child : widgets) {
                    System.out.println("Child => " + child.getContents());
                }
            }

            // Salvar com um novo NOME, e fechar
            pdfDocument.save(
                    String.format("%s - %s - IMM1295e - Complete.pdf", dados.getFullname().getFamilyName(), dados.getFullname().getGivenName())
            );
        }
    }

//    private static void listarCamposRecursivamente(PDField field, String indent) throws IOException
//    {
//        System.out.println(indent + "Nome do Campo: " + field.getFullyQualifiedName());
//
//        // Se o campo tiver filhos (campos aninhados), chame a função recursivamente para cada filho
//        if (field.getWidgets() != null) {
//            for (PDField child : field.getWidgets()) {
//                listarCamposRecursivamente(child, indent + "  ");
//            }
//        }
//    }
}
