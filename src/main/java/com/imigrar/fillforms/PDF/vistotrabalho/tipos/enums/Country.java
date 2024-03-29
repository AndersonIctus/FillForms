package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Country {
    EMPTY("", 0),
    Brazil("b", 17),
    Canada("c", 4),
    Japan("j", 2),
    UnitedStatesOfAmerica("u", 6)
    ;

    private String firstLetter;
    private int position;
}
