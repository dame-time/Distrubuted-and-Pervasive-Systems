package org.client;

import java.util.Date;

public class Exam {
    private String name;
    private int mark;
    private Date verbalizationDate;

    public Exam(String name, int mark, Date verbalizationDate) {
        this.name = name;
        this.mark = mark;
        this.verbalizationDate = verbalizationDate;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public Date getVerbalizationDate() {
        return verbalizationDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                ", verbalizationDate=" + verbalizationDate +
                '}';
    }
}
