package org.example;
import java.util.HashMap;

public class Worker {
    private String name;
    private WorkCategory groupName;
    private double coefKnowledge;  // ArrayList <Skills> ???? worker a have many skills => many coefKnowledge
    private double focusFactor;
    private HashMap<String, Double> workTypeWorker;
}
