package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PreviousMaritalRelationship {
    public FullName name;
    public DateUtil dateOfBirth;
    public String typeOfRelationship;
    public DateUtil from;
    public DateUtil to;
}
