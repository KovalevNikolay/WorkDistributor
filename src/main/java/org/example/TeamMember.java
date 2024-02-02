package org.example;

public class TeamMember {
    private Worker worker;

    public TeamMember(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "worker=" + worker +
                '}';
    }
}
