package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.CountryIssue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NationalIdentityDocument {
    private String documentNumber;
    private CountryIssue countryIssue;
    private DateUtil issueDate;
    private DateUtil expiryDate;
}
