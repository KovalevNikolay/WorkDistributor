package org.example;

import java.util.Comparator;

public class Work {
    private String workName;
    private WorkType workType;
    private WorkCategory workCategory;
    private int estimateTime;
    private double involvementRequired;
    private int countWorkerWhoCanDoThisWork;

    public Work(String workName, WorkType workType, WorkCategory workCategory, int estimateTime, double involvementRequired) {
        this.workName = workName;
        this.workType = workType;
        this.workCategory = workCategory;
        this.estimateTime = estimateTime;
        this.involvementRequired = involvementRequired;
        this.countWorkerWhoCanDoThisWork = 0;
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

    public void increaseCountWorker() {
        this.countWorkerWhoCanDoThisWork++;
    }

    public int getCountWorkerWhoCanDoThisWork() {
        return countWorkerWhoCanDoThisWork;
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
