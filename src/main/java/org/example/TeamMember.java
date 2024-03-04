package org.example;

import java.util.ArrayList;

public class TeamMember {
    private Worker worker;
    private ArrayList<WorkForTeamMember> worksForTeamMember;

    public TeamMember(Worker worker) {
        this.worker = worker;
        this.worksForTeamMember = new ArrayList<>();
    }

    public ArrayList<WorkForTeamMember> getWorksForTeamMember() {
        return worksForTeamMember;
    }

    public Worker getWorker() {
        return worker;
    }

    @Override
    public String toString() {
        return "TeamMember {" + worker + '}';
    }
}
