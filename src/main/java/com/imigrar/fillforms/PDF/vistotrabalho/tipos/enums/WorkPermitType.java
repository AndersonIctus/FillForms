package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkPermitType {
    EMPTY(1),
    ExemptionFromLabourMarketImpactAssessment(2),
    LabourMarketImpactAssessmentStream(3),
    OpenWorkPermit(4),
    Other(5),
    SeasonalAgriculturalWorkersProgram(6),
    StartUpBusinessClass(7)
    ;

    private int position;
}
