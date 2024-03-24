package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProjectTeamCreatorApp {
    public List<TeamMember> createProjectTeam(List<TeamMember> teamMembers, Map<WorkCategory, Integer> countPeople, Selection t) {
        List<TeamMember> projectTeam = new ArrayList<>();
        Map<WorkCategory, List<TeamMember>> workersByCategory = new WorkDistributorApp().groupingWorkersIntoCategories(teamMembers);

        switch (t) {
            case QUALIFICATION:
                Collections.sort(teamMembers, (t1, t2) -> (int)
                        (t1.getWorker().getCoefKnowledge() - t2.getWorker().getCoefKnowledge()));
                break;
            case EFFECTIVENESS:
                Collections.sort(teamMembers, (t1, t2) -> (int)
                        ((t1.getWorker().getCoefKnowledge() * t1.getWorker().getFocusFactor()) -
                                (t2.getWorker().getCoefKnowledge() * t2.getWorker().getFocusFactor())));
                //add an average value involvement to the comparator parameters
                break;
            case FREEDOM:
                //Collections.sort(teamMembers, (t1, t2) -> {});
                break;
        }

        for (Map.Entry<WorkCategory, Integer> entry : countPeople.entrySet()) {
            int count = 0;
            while (count != entry.getValue()) {
                TeamMember tm = workersByCategory.get(entry.getKey()).get(count);
                projectTeam.add(tm);
            }
        }

        return projectTeam;
    }
}
