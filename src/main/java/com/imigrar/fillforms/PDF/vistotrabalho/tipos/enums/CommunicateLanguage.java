package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommunicateLanguage {
    EMPTY(1),
    English(2),
    French(3),
    Both(4),
    Neither(5)
    ;

    private int position;
}
