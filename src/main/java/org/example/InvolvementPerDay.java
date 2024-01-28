package org.example;

import java.util.Date;

public class InvolvementPerDay {
    private Date date;
    private double involvement;

    public InvolvementPerDay(Date date, double involvement) {
        this.date = date;
        this.involvement = involvement;
    }
    public Date getDate() {
        return date;
    }
    public double getInvolvement() {
        return involvement;
    }
    public void setInvolvement(double involvement) {
        this.involvement = involvement;
    }
}
