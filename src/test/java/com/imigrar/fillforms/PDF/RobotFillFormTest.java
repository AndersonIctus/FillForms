package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.CountryGroup;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.PreviousMaritalRelationship;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.*;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.DateUtil;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.FullName;
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

        ////////////////////////
        dados.setLanguage(Language.Portuguese);


        return dados;
    }
}