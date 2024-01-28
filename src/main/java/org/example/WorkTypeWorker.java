package org.example;

public class WorkTypeWorker {
    private WorkType workType;
    private double degreeWorkType;

    public WorkTypeWorker(WorkType workType, double degreeWorkType) {
        this.workType = workType;
        this.degreeWorkType = degreeWorkType;
    }
    public WorkType getWorkType() {
        return workType;
    }
    public double getDegreeWorkType() {
        return degreeWorkType;
    }
    public void setDegreeWorkType(double degreeWorkType) {
        this.degreeWorkType = degreeWorkType;
    }
}
