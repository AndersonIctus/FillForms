package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhoneDetail {
    private static final String CANADA_US_CODE = "1";

    private PhoneType type;
    private String countryCode;
    private String number;
    private String numberExt;

    public PhoneDetail(PhoneType type, String number, String numberExt) {
        this.type = type;
        this.number = number;
        this.numberExt = numberExt;
        this.countryCode = CANADA_US_CODE;
    }

    public boolean isCanadaUsCode() {
        return CANADA_US_CODE.equals(countryCode);
    }
}
