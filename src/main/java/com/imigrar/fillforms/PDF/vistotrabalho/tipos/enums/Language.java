package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    EMPTY("", 1),
    English("e", 5),
    Portuguese("p", 18),
    PortugueseBrazil("p", 20),
    Spanish("s", 39)
    ;

    private String firstLetter;
    private int position;
}
