package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FaxDetail {
    private static final String CANADA_US_CODE = "1";

    private String countryCode;
    private String number;
    private String numberExt;

    public FaxDetail(String number, String numberExt) {
        this.number = number;
        this.numberExt = numberExt;
        this.countryCode = CANADA_US_CODE;
    }

    public boolean isCanadaUsCode() {
        return CANADA_US_CODE.equals(countryCode);
    }
}
