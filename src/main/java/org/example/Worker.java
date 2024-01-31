package org.example;
import java.util.HashMap;

public class Worker {
    private String name;
    private Group group;
    private double coefKnowledge;  // ArrayList <Skills> ???? worker a have many skills => many coefKnowledge
    private double focusFactor;
    private HashMap<String, Double> workTypeWorker;

    public Worker(String name, Group group, double coefKnowledge, double focusFactor, HashMap<String, Double> workTypeWorker) {
        this.name = name;
        this.group = group;
        this.coefKnowledge = coefKnowledge;
        this.focusFactor = focusFactor;
        this.workTypeWorker = workTypeWorker;
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
        return workTypeWorker;
    }
    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}
