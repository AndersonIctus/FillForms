package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    EMPTY(1),
    FEMALE(2),
    MALE(3),
    UNKNOWN(4),
    ANOTHER(5) // X - Another Gender
    ;

    private int position;
}
