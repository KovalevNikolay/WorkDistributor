package org.example;

public class WorkType {
    private String workTypeName;

    public WorkType(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    @Override
    public String toString() {
        return workTypeName;
    }
}
