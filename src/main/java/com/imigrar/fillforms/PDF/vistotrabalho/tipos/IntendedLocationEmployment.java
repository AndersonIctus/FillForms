package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.CanadaProvince;
import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.CanadaCityTown;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IntendedLocationEmployment {
    private CanadaProvince province;
    private CanadaCityTown cityTown;
    private String address;
}
