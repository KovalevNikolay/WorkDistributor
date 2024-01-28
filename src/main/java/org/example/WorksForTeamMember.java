package org.example;

import java.util.ArrayList;

public class WorksForTeamMember {
    private Work work;
    private TeamMember teamMember;
    private double involvementRequired;
    private double involvementAverage;
    private ArrayList<InvolvementPerDay> involvementPerDays;

    public WorksForTeamMember(Work work, TeamMember teamMember, double involvementRequired, ArrayList<InvolvementPerDay> involvementPerDays) {
        this.work = work;
        this.teamMember = teamMember;
        this.involvementRequired = involvementRequired;
        this.involvementPerDays = involvementPerDays;
    }
    public Work getWork() {
        return work;
    }
    public TeamMember getTeamMember() {
        return teamMember;
    }
    public double getInvolvementRequired() {
        return involvementRequired;
    }
    public double getInvolvementAverage() {
        return involvementAverage;
    }
    public ArrayList<InvolvementPerDay> getInvolvementPerDays() {
        return involvementPerDays;
    }
}
