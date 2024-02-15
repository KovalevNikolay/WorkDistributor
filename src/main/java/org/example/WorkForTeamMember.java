package org.example;

import java.util.ArrayList;
import java.util.List;

public class WorkForTeamMember {
    private Work work;
    private TeamMember teamMember;
    private double involvementAverage;
    private List<InvolvementPerDay> involvementPerDays;
    private int executionTime;

    public WorkForTeamMember(Work work, TeamMember teamMember) {
        this.work = work;
        this.teamMember = teamMember;
        this.executionTime = et(work, teamMember);
        this.involvementAverage = 0.0;
        this.involvementPerDays = new ArrayList<>();
    }

    public int getExecutionTime() {
        return executionTime;
    }

    private int et(Work work, TeamMember teamMember) {
        double result = 0;
        int countDays = 0;
        if (teamMember.getWorksForTeamMember().size() == 0) {
            while (result <= work.getEstimateTime()) {
                countDays++;
                result += teamMember.getWorker().getCoefKnowledge() * teamMember.getWorker().getFocusFactor() *
                        teamMember.getWorker().getWorkTypeWorker().get(work.getWorkType().getWorkTypeName()) * 1;
            }
        }
        return countDays;
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
