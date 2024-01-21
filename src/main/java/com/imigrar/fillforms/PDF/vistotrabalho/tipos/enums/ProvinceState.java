package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProvinceState {
    EMPTY(1),

    // CANADA (CND)
    CND_AB(2),
    CND_BC(3),
    CND_MB(4),
    CND_NB(5),
    CND_NL(6),
    CND_NS(7),
    CND_NT(8),
    CND_NU(9),
    CND_ON(10),
    CND_PE(11),
    CND_QC(12),
    CND_SK(13),
    CND_YT(14),

    // UNITED STATES OF AMERICA (USA)
    USA_AL(2),
    USA_AK(3),
    USA_AZ(4),
    USA_AR(5),
    USA_CA(6),
    USA_CO(7),
    USA_CT(8),
    USA_DE(9),
    USA_DC(10),
    USA_FL(11),
    USA_GA(12),
    USA_HI(13),
    USA_ID(14),
    USA_IL(15),
    USA_IN(16),
    USA_IA(17),
    USA_KS(18),
    USA_KY(19),
    USA_LA(20),
    USA_ME(21),
    USA_MD(22),
    USA_MA(23),
    USA_MI(24),
    USA_MN(25),
    USA_MS(26),
    USA_MO(27),
    USA_MT(28),
    USA_NE(29),
    USA_NV(30),
    USA_NH(31),
    USA_NJ(32),
    USA_NM(33),
    USA_NY(34),
    USA_NC(35),
    USA_ND(36),
    USA_OH(37),
    USA_OK(38),
    USA_OR(39),
    USA_PA(40),
    USA_RI(41),
    USA_SC(42),
    USA_SD(43),
    USA_TN(44),
    USA_TX(45),
    USA_UT(46),
    USA_VT(47),
    USA_VA(48),
    USA_WA(49),
    USA_WV(50),
    USA_WI(51),
    USA_WY(52),
    USA_AS(53),
    USA_FM(54),
    USA_GU(55),
    USA_MH(56),
    USA_MP(57),
    USA_PW(58),
    USA_VI(59),
    USA_PR(60)
    ;

    private int position;
}
