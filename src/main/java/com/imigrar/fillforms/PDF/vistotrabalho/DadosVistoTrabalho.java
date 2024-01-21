package com.imigrar.fillforms.PDF.vistotrabalho;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.*;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DadosVistoTrabalho {
    // General
    private TypeOfService wantServiceIn = TypeOfService.ENGLISH;

    // PERSONAL DETAILS
    private FullName fullname;
    private FullName alias;
    private Gender sex;
    private DateUtil dateOfBirth;
    private String birthCity;
    private Country countryTerritory;
    private CountryCitizenship citizenship;
    private CountryGroup currentResidenceCountry;
    private List<CountryGroup> previousCountries = new ArrayList<>();
    private CountryGroup countryWhereApplying;
    private MaritalStatus maritalStatus;
    private DateUtil dateOfMarriage;
    private FullName currentSpouse;
    private PreviousMaritalRelationship previousMaritalRelationship;

    // LANGUAGES
    private Language language;
    private CommunicateLanguage communicateLanguage;
    private CommunicateLanguageMostEase mostEaseCommunicateLanguage;
    private boolean haveTakenTestToProeficiency = false;

    // PASSPORT
    private String passportNumber;
    private CountryIssue countryIssue;
    private DateUtil issueDate;
    private DateUtil expiryDate;
    private boolean passportIssuedByTaiwanIncludePersonalIdentificator = false;
    private boolean passportUseNationalIsraeliPassport = false;

    // National Identity Document
    private NationalIdentityDocument nationalIdentityDocument;

    // US PR CARD (USCIS)
    private boolean areYouLawfulPermanentResidentOfUS = false;
    private String uscisNumber;
    private DateUtil uscisExpiryDate;

    // Contact Information
    private String poBox;
    private MailingAddress currentMailingAddress;
    private MailingAddress residentialAddress;

}
