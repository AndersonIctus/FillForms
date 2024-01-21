package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.robotutil.RobotUtils;
import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.CountryGroup;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.DateUtil;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.FullName;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.PreviousMaritalRelationship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotFillForm {
    //    private static String NOME_FORMULARIO = "imm1295e.pdf";
    private static String NOME_FORMULARIO = "testFileReader.pdf";

    public static void fillForm(DadosVistoTrabalho dadosVisto) throws AWTException {
        JOptionPane.showMessageDialog(null, "Por favor clique no campo \"UCI\"");

        System.out.println("** Gravando Dados para o formulario => " + NOME_FORMULARIO);

        RobotUtils.setAutoDelay(10);
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // Fill "I Want Service In"
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, dadosVisto.getWantServiceIn().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // ************ Personal Details ************
        fillPersonalDetails(dadosVisto);

        // ************ Languages ************
        fillLanguages(dadosVisto);

        // ************ Passport ************
        fillPassport(dadosVisto);
    }

    private static void fillPersonalDetails(DadosVistoTrabalho dadosVisto) {
        // 1 - Full Name
        RobotUtils.sendKeys(dadosVisto.getFullname().getFamilyName());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
        RobotUtils.sendKeys(dadosVisto.getFullname().getGivenName());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 2 - Have you ever used any other name?
        if(dadosVisto.getAlias() != null) {
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            RobotUtils.sendKeys(dadosVisto.getAlias().getFamilyName());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            RobotUtils.sendKeys(dadosVisto.getAlias().getGivenName());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 3);
        }

        // 3 - Sex
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, dadosVisto.getSex().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 4 - Date of birth
        final DateUtil dateOfBirth = dadosVisto.getDateOfBirth();
        RobotUtils.sendKeys(dateOfBirth.getYear());
        RobotUtils.sendKeys(dateOfBirth.getMonth());
        RobotUtils.sendKeys(dateOfBirth.getDay());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 5 - Place of Birth
        RobotUtils.sendKeys(dadosVisto.getBirthCity());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
        RobotUtils.sendKeys(dadosVisto.getCountryTerritory().getFirstLetter(), dadosVisto.getCountryTerritory().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 6 - Citizenship
        RobotUtils.sendKeys(dadosVisto.getCitizenship().getFirstLetter(), dadosVisto.getCitizenship().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 7 - Current country or territory
        final CountryGroup currentResidenceCountry = dadosVisto.getCurrentResidenceCountry();
        fillCountryGroup(currentResidenceCountry);

        // 8 - Previus countries or territories
        if(dadosVisto.getPreviousCountries().size() != 0) {
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            CountryGroup previusCountry = dadosVisto.getPreviousCountries().get(0);
            fillCountryGroup(previusCountry);
            if(dadosVisto.getPreviousCountries().size() > 1) {
                previusCountry = dadosVisto.getPreviousCountries().get(1);
                fillCountryGroup(previusCountry);
            } else {
                RobotUtils.sendKeys(KeyEvent.VK_TAB, 5);
            }

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 11);
        }

        // 9 - Country or territory where applying
        final CountryGroup countryWhereApplying = dadosVisto.getCountryWhereApplying();
        if(countryWhereApplying != null) {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            fillCountryGroup(countryWhereApplying);

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 6);
        }

        // 10 - Your Current Marital Status
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, dadosVisto.getMaritalStatus().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
        if(dadosVisto.getDateOfMarriage() != null) {
            RobotUtils.sendKeys(dadosVisto.getDateOfMarriage().print());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        final FullName currentSpouse = dadosVisto.getCurrentSpouse();
        if(currentSpouse != null) {
            RobotUtils.sendKeys(currentSpouse.getFamilyName());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            RobotUtils.sendKeys(currentSpouse.getGivenName());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
        } else {
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 2);
        }

        // 11 - Have you previously been married
        final PreviousMaritalRelationship previousMaritalRelationship = dadosVisto.getPreviousMaritalRelationship();
        if(previousMaritalRelationship != null) {
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            final FullName previusSpouseName = previousMaritalRelationship.getName();
            RobotUtils.sendKeys(previusSpouseName.getFamilyName());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            RobotUtils.sendKeys(previusSpouseName.getGivenName());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            final DateUtil previusSpouseDateOfBirth = previousMaritalRelationship.getDateOfBirth();
            RobotUtils.sendKeys(previusSpouseDateOfBirth.getYear());
            RobotUtils.sendKeys(previusSpouseDateOfBirth.getMonth());
            RobotUtils.sendKeys(previusSpouseDateOfBirth.getDay());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            if(previousMaritalRelationship.getTypeOfRelationship() != null) {
                RobotUtils.sendKeys(KeyEvent.VK_DOWN, previousMaritalRelationship.getTypeOfRelationship().getPosition());
            }
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            if(previousMaritalRelationship.getFrom() != null) {
                RobotUtils.sendKeys(previousMaritalRelationship.getFrom().print());
            }
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            if(previousMaritalRelationship.getTo() != null) {
                RobotUtils.sendKeys(previousMaritalRelationship.getTo().print());
            }
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 9);
        }
    }

    private static void fillCountryGroup(CountryGroup countryGroup) {
        RobotUtils.sendKeys(countryGroup.getCountryResidence().getFirstLetter(), countryGroup.getCountryResidence().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, countryGroup.getStatus().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
        if( !("".equals(countryGroup.getStatusOther())) ) {
            RobotUtils.sendKeys(countryGroup.getStatusOther());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if(countryGroup.getFrom() != null) {
            RobotUtils.sendKeys(countryGroup.getFrom().print());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if(countryGroup.getTo() != null) {
            RobotUtils.sendKeys(countryGroup.getTo().print());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
    }

    private static void fillLanguages(DadosVistoTrabalho dadosVisto) {
        // 1 - a - native language
        RobotUtils.sendKeys(dadosVisto.getLanguage().getFirstLetter(), dadosVisto.getLanguage().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

    }

    private static void fillPassport(DadosVistoTrabalho dadosVisto) {
    }
}
