package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.*;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.*;
import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

public class RobotFillFormTest {

    @Test
    void fillForm() throws AWTException {
        DadosVistoTrabalho dados = getDadosMocados();
        RobotFillForm.fillForm(dados);
    }

    private DadosVistoTrabalho getDadosMocados() {
        DadosVistoTrabalho dados = new DadosVistoTrabalho();

        //////////////////////// Personal Details
        includePersonalDetails(dados);

        //////////////////////// LANGUAGE
        dados.setLanguage(Language.Portuguese);
        dados.setCommunicateLanguage(CommunicateLanguage.Both);
        dados.setMostEaseCommunicateLanguage(CommunicateLanguageMostEase.English);
//        dados.setHaveTakenTestToProeficiency(true);

        //////////////////////// PASSPORT
        dados.setPassportNumber("IJF8172O");
        dados.setCountryIssue(CountryIssue.ISR_ISRAEL);
        dados.setIssueDate(new DateUtil("10/01/2009"));
        dados.setExpiryDate(new DateUtil("10/01/2035"));

        dados.setPassportUseNationalIsraeliPassport(true);

        //////////////////////// National Identity Document
        dados.setNationalIdentityDocument(new NationalIdentityDocument(
                "201988711827711GHT",
                CountryIssue.BRA_BRAZIL,
                new DateUtil("11/02/2010"),
                new DateUtil("20/08/2030")
        ));

        //////////////////////// US PR CARD (USCIS)
        dados.setAreYouLawfulPermanentResidentOfUS(true);
        dados.setUscisNumber("17262ABC12345677");
        dados.setUscisExpiryDate(new DateUtil("10/05/2028"));

        //////////////////////// Contact Info
        includeContactInfo(dados);


        return dados;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    private void includePersonalDetails(DadosVistoTrabalho dados) {
        dados.setFullname(new FullName("Teste Testando Silva"));
        dados.setAlias(new FullName("Teste", "Family Alias"));
        dados.setSex(Gender.MALE);
        dados.setDateOfBirth(new DateUtil("15/02/2001"));
        dados.setBirthCity("Fortaleza");
        dados.setCountryTerritory(Country.Brazil);
        dados.setCitizenship(CountryCitizenship.Japan);
        dados.setCurrentResidenceCountry(new CountryGroup(CountryResidence.Brazil, ResidenceCountryStatus.Citizen));

        List<CountryGroup> previusCountries = new ArrayList<>();
        previusCountries.add(
                new CountryGroup(CountryResidence.Brazil, ResidenceCountryStatus.Other, "Algum Dado", new DateUtil("01/01/2009"), new DateUtil("01/01/2015"))
        );
        previusCountries.add(
                new CountryGroup(CountryResidence.Japan, ResidenceCountryStatus.Student, "", new DateUtil("01/01/2010"), new DateUtil("01/01/2015"))
        );
        dados.setPreviousCountries(previusCountries);

        dados.setMaritalStatus(MaritalStatus.Single);

//        dados.setMaritalStatus(MaritalStatus.Divorced);
//        dados.setPreviousMaritalRelationship(
//                new PreviousMaritalRelationship(
//                        new FullName("Maria", "Joaquina"),
//                        new DateUtil("16/10/2004"),
//                        MaritalTypeOfRelationship.Married,
//                        new DateUtil("10/10/2018"),
//                        new DateUtil("10/10/2022")
//                )
//        );
    }

    private void includeContactInfo(DadosVistoTrabalho dados) {
//        dados.setPoBox("124ABC1");
//        dados.setCurrentMailingAddress(
//                new MailingAddress(
//                        "apto", "123", "Test Street", "Test City",
//                        Country.Canada,
//                        ProvinceState.CND_QC,
//                        "A1A 1A1"
//                )
//        );

        dados.setCurrentMailingAddress(
                new MailingAddress(
                        "apto", "123", "Test Street", "Test City",
                        Country.Japan,
                        "123",
                        "Akira"
                )
        );

//        dados.setResidentialAddress(
//                new MailingAddress(
//                        "apto", "123", "Test Street", "Test City",
//                        Country.Brazil,
//                        "60999-123",
//                        "Ceara"
//                )
//        );
    }
}