package com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CanadaCityTown {
    EMPTY("", 1),

    // AB - Alberta
    AB_Acme("a", 1),
    AB_Aden("a", 2),
    AB_Aetna("a", 3),
    AB_Airdrie("a", 4),
    AB_AlbertaBeach("a", 5),

    AB_Balac("b", 1),
    AB_Balzac("b", 2),
    AB_Banff("b", 3),

    AB_Calgary("c", 1),
    AB_Calmar("c", 2),
    AB_Camrose("c", 3),

    AB_Daysland("d", 1),
    AB_DeWinton("d", 2),

    AB_Eaglesham("e", 1),
    AB_Eckville("e", 2),

    AB_Wabamun("w", 1),
    AB_WabasDesmar("w", 2),

    AB_Yellowstone("y", 1),
    AB_Youngstown("y", 2),

    AB_Zama("z", 1),


    // BC - Britsh Columbia
    BC_100MileHouse("1", 1),
    BC_108MileRanch("1", 2),
    BC_150MileHouse("1", 3),
    BC_70MileHouse("7", 1),

    BC_Abbotsford("a", 1),

    BC_Hangensborg("h", 1),

    BC_LaHache("l", 1),
    BC_Ladner("l", 2),

    BC_RadiumHotSprings("r", 1),
    BC_Revelstoke("r", 2),

    BC_TaTaCreek("t", 1),
    BC_Tahsis("t", 2),

    BC_Zeballos("z", 1),


    // MB - Manitoba
    MB_Alexander_MB("a", 1),
    MB_Altona("a", 2),


    // NB - New Brunswick
    NB_Acadieville("a", 1),
    NB_Alma_NB("a", 2),


    // NL - Newfoundland and Labrador
    NL_Aguathuna("a", 1),

    NL_Badger("b", 1),
    NL_BaieDeVerde("b", 2),


    // NS - Nova Scotia
    NS_Amherst("a", 1),
    NS_AnnapolisRoyal("a", 2),


    // NT - Northwest Territories
    NT_ColevilleLk("c", 1),
    NT_Deline("d", 1),
    NT_Detah("d", 2),
    NT_Enterprise("e", 1),


    // NU - Nunavut
    NU_ArcticBay("a", 1),
    NU_Arviat("a", 2),


    // ON - Ontario
    ON_Aberfoyl("a", 1),
    ON_Acton("a", 2),
    ON_Agincourt("a", 3),
    ON_AilsaCraig("a", 4),
    ON_Ajax("a", 5),


    // PE - Prince Edwards Island
    PE_Albany_PE("a", 1),
    PE_Alberton("a", 2),


    // QC - Quebec
    QC_Abercorn("a", 1),
    QC_Abitibi("a", 2),


    // SK - Sakatchewan
    SK_Abbey("a", 1),
    SK_Aberdeen("a", 2),

    // YT - Yukon
    YT_Carcross("c", 1),
    YT_Carmacks("c", 2),
    YT_DawsonCity("d", 1),
    YT_Faro("f", 1),
    YT_HainesJunction("h", 1),
    YT_LittleGold("l", 1),
    YT_MayoElsa("m", 1),
    YT_OldCrow("o", 1),
    YT_Other("o", 2),
    YT_RossRiver("r", 1),
    YT_SwiftRiver("s", 1),
    YT_Tagish("t", 1),
    YT_WatsonLake("w", 1),
    YT_Whitehorse("w", 2)
    ;

    private String firstLetter;
    private int position;

}
