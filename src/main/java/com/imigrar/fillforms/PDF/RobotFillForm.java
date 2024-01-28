package com.imigrar.fillforms.PDF;

import com.imigrar.fillforms.PDF.robotutil.RobotUtils;
import com.imigrar.fillforms.PDF.vistotrabalho.DadosVistoTrabalho;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.*;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.CanadaCityTown;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.CanadaProvince;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.CountryIssue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotFillForm {
    private static String NOME_FORMULARIO = "imm1295e.pdf";
    //private static String NOME_FORMULARIO = "testFileReader.pdf";

    public static void fillForm(DadosVistoTrabalho dadosVisto) throws AWTException {
        JOptionPane.showMessageDialog(null, "Por favor clique no campo \"UCI\"");

        System.out.println("** Gravando Dados para o formulario => " + NOME_FORMULARIO);

        RobotUtils.setAutoDelay(10);
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // Fill "I Want Service In"
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, dadosVisto.getWantServiceIn().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // ************ Personal Details ************
        fillFormPersonalDetails(dadosVisto);

        // ************ Languages ************
        fillFormLanguages(dadosVisto);

        // ************ Passport ************
        fillFormPassport(dadosVisto);

        // ************ National Identity Document ************
        fillFormNationalIdentityDocument(dadosVisto);

        // ************ US PR CARD (USCIS) ************
        fillFormUS_PR_CARD(dadosVisto);

        // ************ Contact Information ************
        fillFormContactInformation(dadosVisto);

        // ************ Details of Intended Work in Canada ************
        fillFormDetailsOfIntendedWorkInCanada(dadosVisto);
    }


    private static void fillFormPersonalDetails(DadosVistoTrabalho dadosVisto) {
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

    private static void fillFormLanguages(DadosVistoTrabalho dadosVisto) {
        // 1 - a - native language
        RobotUtils.sendKeys(dadosVisto.getLanguage().getFirstLetter(), dadosVisto.getLanguage().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 1 - b - Able to comunicate
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, dadosVisto.getCommunicateLanguage().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 1 - c - In which language are you most ease
        if(dadosVisto.getMostEaseCommunicateLanguage() != null){
            RobotUtils.sendKeys(KeyEvent.VK_DOWN, dadosVisto.getMostEaseCommunicateLanguage().getPosition());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 1 - d - have you taken a test for proeficiency in English or French?
        if(dadosVisto.isHaveTakenTestToProeficiency()){
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
        } else {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
        }
        RobotUtils.sendKeys(KeyEvent.VK_ENTER);
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
    }

    private static void fillFormPassport(DadosVistoTrabalho dadosVisto) {
        // 1 - Passport Number
        RobotUtils.sendKeys(dadosVisto.getPassportNumber());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 2 - Country Territory
        RobotUtils.sendKeys(dadosVisto.getCountryIssue().getFirstLetter(), dadosVisto.getCountryIssue().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 3 - Issue date
        RobotUtils.sendKeys(dadosVisto.getIssueDate().print());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 4 - Expiry date
        RobotUtils.sendKeys(dadosVisto.getExpiryDate().print());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 5 - Use a passport issued by Foreign Affairs in Taiwan?
        if(dadosVisto.getCountryIssue() == CountryIssue.TWN_TAIWAN) {
            if(dadosVisto.isPassportIssuedByTaiwanIncludePersonalIdentificator()) {
                RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            } else {
                RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            }
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 6 - Will you use a National Israeli passport?
        if(dadosVisto.getCountryIssue() == CountryIssue.ISR_ISRAEL) {
            if(dadosVisto.isPassportUseNationalIsraeliPassport()) {
                RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            } else {
                RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            }
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
    }

    private static void fillFormNationalIdentityDocument(DadosVistoTrabalho dadosVisto) {
        final NationalIdentityDocument nationalIdentityDocument = dadosVisto.getNationalIdentityDocument();
        if(nationalIdentityDocument != null) {
            // 1 - Do you have National Identity Document?
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            // 2 - Document Number
            RobotUtils.sendKeys(nationalIdentityDocument.getDocumentNumber());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            // 3 - Country Territory
            RobotUtils.sendKeys(nationalIdentityDocument.getCountryIssue().getFirstLetter(), nationalIdentityDocument.getCountryIssue().getPosition());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            // 4 - Issue date
            RobotUtils.sendKeys(nationalIdentityDocument.getIssueDate().print());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            // 5 - Expiry date
            RobotUtils.sendKeys(nationalIdentityDocument.getExpiryDate().print());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 5);
        }

    }

    private static void fillFormUS_PR_CARD(DadosVistoTrabalho dadosVisto) {
        if(dadosVisto.isAreYouLawfulPermanentResidentOfUS()) {
            // 1 - Are you a lawful permanent resident of the United States?
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            // 2 - US Citizenship and Immigration Services Number (USCIS)
            RobotUtils.sendKeys(dadosVisto.getUscisNumber());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            // 2 - USCIS expiry date
            RobotUtils.sendKeys(dadosVisto.getUscisExpiryDate().print());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 3);
        }
    }

    private static void fillFormContactInformation(DadosVistoTrabalho dadosVisto) {
        // 1 - Current Mailing Address
        if( !("".equals(dadosVisto.getPoBox())) ) {
            RobotUtils.sendKeys(dadosVisto.getPoBox());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        fillMaillingAddres(dadosVisto.getCurrentMailingAddress());

        // 2 - Residential Address
        if(dadosVisto.getResidentialAddress() == null) {
            RobotUtils.sendKeys(KeyEvent.VK_RIGHT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 9);

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_LEFT);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            fillMaillingAddres(dadosVisto.getResidentialAddress());
        }

        // 3 - Telephone no.
        if(dadosVisto.getTelephoneNumber() != null) {
            fillTelephoneNumber(dadosVisto.getTelephoneNumber());
        } else {
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 5);
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 4 - Alternate Telephone no.
        if(dadosVisto.getTelephoneAlternateNumber() != null) {
            fillTelephoneNumber(dadosVisto.getTelephoneAlternateNumber());
        } else {
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 5);
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 5 - Fax no.
        if(dadosVisto.getFaxNumber() != null) {
            fillFaxNumber(dadosVisto.getFaxNumber());
        } else {
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 4);
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // 6 - Email Address
        if(!StringUtil.isEmptyOrNull(dadosVisto.getEmail())) {
            RobotUtils.sendKeys(dadosVisto.getEmail());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
    }

    private static void fillFormDetailsOfIntendedWorkInCanada(DadosVistoTrabalho dadosVisto) {
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, dadosVisto.getWorkPermitType().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if(!StringUtil.isEmptyOrNull(dadosVisto.getEmployerName())) {
            RobotUtils.sendKeys(dadosVisto.getEmployerName());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if(!StringUtil.isEmptyOrNull(dadosVisto.getEmployerAddress())) {
            RobotUtils.sendKeys(dadosVisto.getEmployerAddress());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        final IntendedLocationEmployment intendedLocationEmployment = dadosVisto.getIntendedLocationEmployment();
        if(intendedLocationEmployment != null) {
            final CanadaProvince province = intendedLocationEmployment.getProvince();
            RobotUtils.sendKeys(KeyEvent.VK_DOWN, province.getPosition() );
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            final CanadaCityTown cityTown = intendedLocationEmployment.getCityTown();
            RobotUtils.sendKeys(cityTown.getFirstLetter(), cityTown.getPosition() );
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            RobotUtils.sendKeys(intendedLocationEmployment.getAddress());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

        } else {
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 3);
        }

        if(!StringUtil.isEmptyOrNull(dadosVisto.getJobTitle())) {
            RobotUtils.sendKeys(dadosVisto.getJobTitle());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);


        if(!StringUtil.isEmptyOrNull(dadosVisto.getJobBriefDescriptionOfDuties())) {
            RobotUtils.sendKeys(dadosVisto.getJobBriefDescriptionOfDuties());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if(dadosVisto.getIntendedWorkDurationFrom() != null) {
            RobotUtils.sendKeys(dadosVisto.getIntendedWorkDurationFrom().print());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if(dadosVisto.getIntendedWorkDurationTo() != null) {
            RobotUtils.sendKeys(dadosVisto.getIntendedWorkDurationTo().print());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if(!StringUtil.isEmptyOrNull(dadosVisto.getLmiaOrLmiaExemptNumber())) {
            RobotUtils.sendKeys(dadosVisto.getLmiaOrLmiaExemptNumber());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
    }

    //////////////////////////////////////////////////////////////////////////////////////
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

    private static void fillMaillingAddres(MailingAddress mailingAddress) {
        RobotUtils.sendKeys(mailingAddress.getAptUnit());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        RobotUtils.sendKeys(mailingAddress.getStreetNo());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        RobotUtils.sendKeys(mailingAddress.getStreetName());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        RobotUtils.sendKeys(mailingAddress.getCityTown());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        RobotUtils.sendKeys(mailingAddress.getCountry().getFirstLetter(), mailingAddress.getCountry().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        switch (mailingAddress.getCountry()){
            case UnitedStatesOfAmerica :
            case Canada:
                RobotUtils.sendKeys(KeyEvent.VK_DOWN, mailingAddress.getProvinceState().getPosition());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        RobotUtils.sendKeys(mailingAddress.getPostalCode());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        if( !("".equals(mailingAddress.getDistrict())) ) {
            RobotUtils.sendKeys(mailingAddress.getDistrict());
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);
    }

    private static void fillTelephoneNumber(PhoneDetail telephoneNumber) {
        if(telephoneNumber.isCanadaUsCode()) {
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 2);
        } else {
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
        }

        // Type
        RobotUtils.sendKeys(KeyEvent.VK_DOWN, telephoneNumber.getType().getPosition());
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // Country Code And Number
        if(telephoneNumber.isCanadaUsCode()) {
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            fillCanadaUsPhoneNumber(telephoneNumber.getNumberExt(), telephoneNumber.getNumber());

        } else {
            RobotUtils.sendKeys(telephoneNumber.getCountryCode());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            fillComumPhoneNumber(telephoneNumber.getNumberExt(), telephoneNumber.getNumber());
        }
    }

    private static void fillFaxNumber(FaxDetail faxNumber) {
        if(faxNumber.isCanadaUsCode()) {
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB, 2);
        } else {
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            RobotUtils.sendKeys(KeyEvent.VK_ENTER);
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
        }

        // Country Code And Number
        if(faxNumber.isCanadaUsCode()) {
            RobotUtils.sendKeys(KeyEvent.VK_TAB);
            fillCanadaUsPhoneNumber(faxNumber.getNumberExt(), faxNumber.getNumber());

        } else {
            RobotUtils.sendKeys(faxNumber.getCountryCode());
            RobotUtils.sendKeys(KeyEvent.VK_TAB);

            fillComumPhoneNumber(faxNumber.getNumberExt(), faxNumber.getNumber());
        }
    }

    private static void fillComumPhoneNumber(String numberExt, String number) {
        // Number
        RobotUtils.sendKeys(number);
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // Ext
        if(!StringUtil.isEmptyOrNull(numberExt)) {
            RobotUtils.sendKeys(numberExt);
        }
    }

    private static void fillCanadaUsPhoneNumber(String numberExt, String number) {
        // EXT
        if(!StringUtil.isEmptyOrNull(numberExt)) {
            RobotUtils.sendKeys(numberExt);
        }
        RobotUtils.sendKeys(KeyEvent.VK_TAB);

        // Number
        RobotUtils.sendKeys(number);

        // skips ....
        RobotUtils.sendKeys(KeyEvent.VK_TAB, 3);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    private static void LOG(String logLine) {
        System.out.println(logLine);
    }
}
