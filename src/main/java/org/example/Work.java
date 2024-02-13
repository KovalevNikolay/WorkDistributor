package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Work {
    private String workName;
    private WorkType workType;
    private WorkCategory workCategory;
    private int estimateTime;
    private double involvementRequired;
    private Map<TeamMember, Integer> potentialPerformers;

    public Work(String workName, WorkType workType, WorkCategory workCategory, int estimateTime, double involvementRequired) {
        this.workName = workName;
        this.workType = workType;
        this.workCategory = workCategory;
        this.estimateTime = estimateTime;
        this.involvementRequired = involvementRequired;
        this.potentialPerformers = new TreeMap<>((t1, t2) -> {
            Worker w1 = t1.getWorker();
            Worker w2 = t2.getWorker();
            Double coefKnowledgeOfW1 = w1.getCoefKnowledge();
            Double coefKnowledgeOfW2 = w2.getCoefKnowledge();
            Double focusFactorOfW1 = w1.getCoefKnowledge();
            Double focusFactorOfW2 = w2.getCoefKnowledge();
            Double degreeOfW1 = w1.getWorkTypeWorker().get(this.getWorkType().getWorkTypeName());
            Double degreeOfW2 = w2.getWorkTypeWorker().get(this.getWorkType().getWorkTypeName());

            Double result = coefKnowledgeOfW2 * focusFactorOfW2 * degreeOfW2 - coefKnowledgeOfW1 * focusFactorOfW1 * degreeOfW1;

            return result.intValue();
        });
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

    public Map<TeamMember, Integer> getPotentialPerformers() {
        return potentialPerformers;
    }

    public void addPotentialPerformer(TeamMember t) {
        this.potentialPerformers.putIfAbsent(t, Integer.MAX_VALUE);
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
