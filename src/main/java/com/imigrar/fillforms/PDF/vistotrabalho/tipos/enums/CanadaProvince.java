package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CanadaProvince {
    EMPTY(1),
    AB(2), // Alberta
    BC(3), // Britsh Columbia
    MB(4), // Manitoba
    NB(5), // New Brunswick
    NL(6), // Newfoundland and Labrador
    NS(7), // Nova Scotia
    NT(8), // Northwest Territories
    NU(9), // Nunavut
    ON(10), // Ontario
    PE(11), // Prince Edwards Island
    QC(12), // Quebec
    SK(13), // Sakatchewan
    YT(14)  // Yukon

    ;

    private int position;
}
