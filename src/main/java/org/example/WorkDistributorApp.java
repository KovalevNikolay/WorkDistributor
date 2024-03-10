package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class WorkDistributorApp {
    public Map<Integer, List<WorkForTeamMember>> getPlanningOptions(ArrayList<TeamMember> projectTeam, ArrayList<Work> worksList, HashMap<Double, Double> conversion) {

        Map<WorkCategory, List<TeamMember>> teamMembersByCategory = groupingWorkersIntoCategories(projectTeam);
        Map<Work, List<TeamMember>> performers = assignmentOfWorksToWorkers(worksList, teamMembersByCategory);
        Map<Integer, List<WorkForTeamMember>> options = new HashMap<>();
        options.put(0, new ArrayList<>());
        options.put(1, new ArrayList<>());
        options.put(2, new ArrayList<>());
        options.put(3, new ArrayList<>());
        options.put(4, new ArrayList<>());

        WorkForTeamMember workForTeamMember;

        for (Map.Entry<Work, List<TeamMember>> work : performers.entrySet()) {
            List<WorkForTeamMember> workForTeamMemberList = new ArrayList<>();
            for (TeamMember tm : work.getValue()) {
                workForTeamMember = new WorkForTeamMember(work.getKey(), tm);
                workForTeamMemberList.add(workForTeamMember);
            }

            Collections.sort(workForTeamMemberList, (w1, w2) -> w1.getExecutionTime() - w2.getExecutionTime());

            int currentIndex = 0;
            for (int i = 0; i < options.size(); i++) {
                if (currentIndex == workForTeamMemberList.size()) {
                    currentIndex = 0;
                }
                options.get(i).add(workForTeamMemberList.get(currentIndex));
                currentIndex++;
            }

            workForTeamMemberList.clear();

        }
        return options;
    }

    private Map<WorkCategory, List<TeamMember>> groupingWorkersIntoCategories(ArrayList<TeamMember> teamMembers) {
        return teamMembers.stream().collect(Collectors.groupingBy(tm -> tm.getWorker().getGroup().groupName));
    }

    private Map<Work, List<TeamMember>> assignmentOfWorksToWorkers(ArrayList<Work> works, Map<WorkCategory, List<TeamMember>> teamMembers) {
        Map<Work, List<TeamMember>> performersOfWork = new HashMap<>();
        for (Work work : works) {
            performersOfWork.putIfAbsent(work, new ArrayList<>());
            for (TeamMember teamMember : teamMembers.get(work.getWorkCategory())) {
                Double workTypeOfWorker = teamMember.getWorker().getWorkTypeWorker().get(work.getWorkType().getWorkTypeName());
                if (workTypeOfWorker != null) {
                    performersOfWork.get(work).add(teamMember);
                }
            }
        }

        return performersOfWork;
    }
}
