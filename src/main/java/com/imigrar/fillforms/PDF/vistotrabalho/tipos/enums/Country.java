package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Country {
    EMPTY("", 0),
    Brazil("b", 17),
    Japan("j", 2)
    ;

    private String firstLetter;
    private int position;
}
