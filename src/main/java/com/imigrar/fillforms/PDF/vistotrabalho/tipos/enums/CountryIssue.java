package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryIssue {
    EMPTY("", 0),
    USA_UNITED_STATES("u", 6),
    BRA_BRAZIL("b", 14),
    ISR_ISRAEL("i", 7),
    TWN_TAIWAN("t", 13)
    ;

    private String firstLetter;
    private int position;
}
