package org.example;

import java.util.*;

public class Work {
    private String workName;
    private WorkType workType;
    private WorkCategory workCategory;
    private int estimateTime;
    private double involvementRequired;

    public Work(String workName, WorkType workType, WorkCategory workCategory, int estimateTime, double involvementRequired) {
        this.workName = workName;
        this.workType = workType;
        this.workCategory = workCategory;
        this.estimateTime = estimateTime;
        this.involvementRequired = involvementRequired;
    }

    public String getWorkName() {
        return workName;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public WorkCategory getWorkCategory() {
        return workCategory;
    }

    public int getEstimateTime() {
        return estimateTime;
    }

    public double getInvolvementRequired() {
        return involvementRequired;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workName='" + workName + '\'' +
                ", involvementRequired=" + involvementRequired +
                '}';
    }
}
