package org.example;

import java.util.ArrayList;

public class WorksForTeamMember {
    private Work work;
    private TeamMember teamMember;
    private double involvementAverage;
    private ArrayList<InvolvementPerDay> involvementPerDays;

    public WorksForTeamMember(TeamMember teamMember, ArrayList<InvolvementPerDay> involvementPerDays) {
        this.work = null;
        this.teamMember = teamMember;
        this.involvementAverage = 0;
        this.involvementPerDays = involvementPerDays;
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

    public ArrayList<InvolvementPerDay> getInvolvementPerDays() {
        return involvementPerDays;
    }

    public void setWork(Work work) {
        this.work = work;
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
