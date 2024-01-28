package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    EMPTY(1),
    Residence(2),
    Cellular(3),
    Business(4)
    ;

    private int position;
}
