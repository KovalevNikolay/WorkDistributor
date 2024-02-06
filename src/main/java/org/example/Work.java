package org.example;

public class Work {
    private String workName;
    private WorkType workType;
    private WorkCategory workCategory;
    private int estimateTime;
    private double involvementRequired;
    private int countWorker;

    public Work(String workName, WorkType workType, WorkCategory workCategory, int estimateTime, double involvementRequired) {
        this.workName = workName;
        this.workType = workType;
        this.workCategory = workCategory;
        this.estimateTime = estimateTime;
        this.involvementRequired = involvementRequired;
        this.countWorker = 0;
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
        this.countWorker++;
    }

    public int getCountWorker() {
        return countWorker;
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
