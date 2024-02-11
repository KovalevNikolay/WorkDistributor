package org.example;

import java.util.ArrayList;

public class Work {
    private String workName;
    private WorkType workType;
    private WorkCategory workCategory;
    private int estimateTime;
    private double involvementRequired;
    private ArrayList<TeamMember> potentialPerformers;

    public Work(String workName, WorkType workType, WorkCategory workCategory, int estimateTime, double involvementRequired) {
        this.workName = workName;
        this.workType = workType;
        this.workCategory = workCategory;
        this.estimateTime = estimateTime;
        this.involvementRequired = involvementRequired;
        this.potentialPerformers = new ArrayList<>();
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

    public ArrayList<TeamMember> getPotentialPerformers() {
        return potentialPerformers;
    }

    public void addPotentialPerformers(TeamMember t) {
        this.potentialPerformers.add(t);
    }

    @Override
    public String toString() {
        return "Work{" +
                "workName='" + workName + '\'' +
                ", workType=" + workType +
                ", workCategory=" + workCategory +
                ", estimateTime=" + estimateTime +
                ", involvementRequired=" + involvementRequired +
                '}';
    }
}
