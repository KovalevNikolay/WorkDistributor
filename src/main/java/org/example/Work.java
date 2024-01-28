package org.example;

public class Work {
    private String workName;
    private WorkType workType;
    private WorkCategory workCategory;
    private int estimateTime;

    public Work(String workName, WorkType workType, WorkCategory workCategory, int estimateTime) {
        this.workName = workName;
        this.workType = workType;
        this.workCategory = workCategory;
        this.estimateTime = estimateTime;
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
    @Override
    public String toString() {
        return "Work{" +
                "workName='" + workName + '\'' +
                ", workType=" + workType +
                ", workCategory=" + workCategory +
                ", estimateTime=" + estimateTime +
                '}';
    }
}
