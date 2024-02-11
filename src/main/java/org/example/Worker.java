package org.example;

import java.util.HashMap;

public class Worker {
    private int id;
    private String name;
    private Group group;
    private double coefKnowledge;  // ArrayList <Skills> ???? worker a have many skills => many coefKnowledge
    private double focusFactor;
    private HashMap<String, Double> worksTypeWorker;

    public Worker(int id, String name, Group group, double coefKnowledge, double focusFactor) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.coefKnowledge = coefKnowledge;
        this.focusFactor = focusFactor;
        this.worksTypeWorker = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public double getCoefKnowledge() {
        return coefKnowledge;
    }

    public double getFocusFactor() {
        return focusFactor;
    }

    public HashMap<String, Double> getWorkTypeWorker() {
        return worksTypeWorker;
    }

    public void addWorkTypeWorker(WorkType wt, double degreeWorkType) {
        this.worksTypeWorker.putIfAbsent(wt.getWorkTypeName(), degreeWorkType);
    }
    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", coefKnowledge=" + coefKnowledge +
                ", focusFactor=" + focusFactor +
                '}';
    }
}
