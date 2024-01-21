package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.CountryResidence;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.ResidenceCountryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryGroup {
    public CountryResidence countryResidence;
    public ResidenceCountryStatus status = ResidenceCountryStatus.Other;
    public String statusOther = "";
    public DateUtil from;
    public DateUtil to;

    public CountryGroup(CountryResidence countryResidence, ResidenceCountryStatus status) {
        this.countryResidence = countryResidence;
        this.status = status;
    }
}
