package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResidenceCountryStatus {
    EMPTY(1),
    Citizen(2),
    PermanentResident(3),
    Visitor(4),
    Worker(5),
    Student(6),
    Other(7),
    ProtectedPerson(8),
    RefugeeClaimant(9),
    ForeignNational(10)
    ;

    private int position;
}
