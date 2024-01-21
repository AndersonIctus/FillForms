package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalStatus {
    EMPTY(1),
    AnnulledMarriage(2),
    CommonLaw(3),
    Divorced(4),
    Married(5),
    Separated(6),
    Single(7),
    Unknown(8),
    Widowed(9)
    ;

    private int position;
}
