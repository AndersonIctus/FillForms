package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalTypeOfRelationship {
    EMPTY(1),
    CommonLaw(2),
    Married(3),
    ;

    private int position;
}
