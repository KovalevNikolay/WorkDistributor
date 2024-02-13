package org.example;

import java.util.ArrayList;
import java.util.List;

public class WorkForTeamMember {
    private Work work;
    private TeamMember teamMember;
    private double involvementAverage;
    private List<InvolvementPerDay> involvementPerDays;
    private int executionTime;

    public WorkForTeamMember(Work work, TeamMember teamMember, int executionTime) {
        this.work = work;
        this.teamMember = teamMember;
        this.executionTime = executionTime;
        this.involvementAverage = 0.0;
        this.involvementPerDays = new ArrayList<>();
    }

    public Work getWork() {
        return work;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public double getInvolvementAverage() {
        return involvementAverage;
    }

    public List<InvolvementPerDay> getInvolvementPerDays() {
        return involvementPerDays;
    }

    @Override
    public String toString() {
        return "WorksForTeamMember{" +
                "work=" + work +
                ", teamMember=" + teamMember +
                ", involvementAverage=" + involvementAverage +
                ", involvementPerDays=" + involvementPerDays +
                '}';
    }
}
