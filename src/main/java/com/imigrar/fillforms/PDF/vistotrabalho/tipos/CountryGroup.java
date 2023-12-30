package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CountryGroup {
    public Country country;
    public ResidenceCountryStatus status = ResidenceCountryStatus.Other;
    public String statusOther = "";
}
