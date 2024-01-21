package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.Country;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.ProvinceState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailingAddress {
    private String aptUnit;
    private String streetNo;
    private String streetName;
    private String cityTown;
    private Country country;
    private ProvinceState provinceState;
    private String postalCode;
    private String district;

    public MailingAddress(String aptUnit, String streetNo, String streetName, String cityTown, Country country, ProvinceState provinceState, String postalCode) {
        this.aptUnit = aptUnit;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.cityTown = cityTown;
        this.country = country;
        this.provinceState = provinceState;
        this.postalCode = postalCode;
    }

    public MailingAddress(String aptUnit, String streetNo, String streetName, String cityTown, Country country, String postalCode, String district) {
        this.aptUnit = aptUnit;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.cityTown = cityTown;
        this.country = country;
        this.postalCode = postalCode;
        this.district = district;
    }
}
