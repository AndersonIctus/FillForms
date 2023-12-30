package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FullName {
    private String familyName;
    private String givenName;

    public FullName(String familyName, String givenName) {
        this.familyName = familyName;
        this.givenName = givenName;
    }

    public FullName(String fullName) {
        List<String> names = Arrays.stream(fullName.split(" "))
                .filter(name -> name.length() != 0)
                .collect(Collectors.toList());
        int media = names.size()/2;

        StringBuilder familyName = new StringBuilder();
        StringBuilder givenName = new StringBuilder();
        for(int i = 0; i < names.size(); i++) {
            StringBuilder aux = givenName;
            if(i + 1 > media || i > 1) aux = familyName;

            if(aux.length() > 0) aux.append(" ");

            aux.append(names.get(i));
        }

        this.familyName = familyName.toString();
        this.givenName = givenName.toString();
    }
}
