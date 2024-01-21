package com.imigrar.fillforms.PDF.vistotrabalho.tipos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DateUtil {
    private String year;
    private String month;
    private String day;

    public DateUtil(String data) {
        this.day = data.substring(0, 2);
        this.month = data.substring(3, 5);
        this.year = data.substring(6);
    }

    public String print() {
        return String.format("%s%s%s", year, month, day);
    }
}
