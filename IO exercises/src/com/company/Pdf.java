package com.company;

import java.util.Date;

public class Pdf {
    private String name;
    private String size;
    private String dateModified;

    public Pdf(){}

    public Pdf(String name, String size, String datrModified) {
        this.name = name;
        this.size = size;
        this.dateModified = datrModified;
    }

    public String getType() {
        return name;
    }

    public void setType(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDatrModified() {
        return dateModified;
    }

    public void setDatrModified(String datrModified) {
        this.dateModified = datrModified;
    }

    @Override
    public String toString() {
        return  "{\n" +
                "doc: " + name + ",\n" +
                "size: " + size + ",\n" +
                "DateModified:" + dateModified +
                "\n}\n" ;
    }
}
