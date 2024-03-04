package org.example;

public class Group {
    WorkCategory groupName;

    public Group(WorkCategory groupName) {
        this.groupName = groupName;
    }

    public WorkCategory getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "groupName=" + groupName;
    }
}
