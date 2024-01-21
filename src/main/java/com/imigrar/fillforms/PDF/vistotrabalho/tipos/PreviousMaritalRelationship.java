package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import com.imigrar.fillforms.PDF.vistotrabalho.tipos.enums.MaritalTypeOfRelationship;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreviousMaritalRelationship {
    public FullName name;
    public DateUtil dateOfBirth;
    public MaritalTypeOfRelationship typeOfRelationship;
    public DateUtil from;
    public DateUtil to;
}
