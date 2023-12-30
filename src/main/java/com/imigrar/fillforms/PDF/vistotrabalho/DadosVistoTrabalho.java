package com.imigrar.fillforms.PDF.vistotrabalho;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DadosVistoTrabalho {
    // General
    public TypeOfService wantServiceIn = TypeOfService.ENGLISH;

    // PERSONAL DETAILS
    public FullName fullname;
    public FullName alias;
    public Gender sex;
    public DateUtil dateOfBirth;
    public String birthCity;
    public Country countryTerritory;
    public Country citizenship;
    public CountryGroup currentResidenceCountry;
    public List<CountryGroup> previousCountries = new ArrayList<>();
    public CountryGroup countryWhereApplying;
    public MaritalStatus maritalStatus;
    public DateUtil dateOfMarriage;
    public FullName currentSpouse;
    public PreviousMaritalRelationship previousMaritalRelationship;

    // LANGUAGES
    public Language language;
    public CommunicateLanguage communicateLanguage;
    public CommunicateLanguage mostEaseCommunicateLanguage;

    // PASSPORT
    public String passportNUmber;
    public Country countryIssue;
    public DateUtil issueDate;
    public DateUtil expiryDate;
}
