package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeOfService {
    EMPTY(1),
    ENGLISH(2),
    FRENCH(3);

    private int position;
}
