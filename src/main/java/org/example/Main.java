package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        HashMap<Double, Double> conversion = new HashMap<>();
        conversion.put(1.4, 0.5);
        conversion.put(1.2, 0.8);
        conversion.put(1.0, 1.0);
        conversion.put(0.9, 1.4);
        conversion.put(0.7, 2.0);
        conversion.put(0.5, 2.5);
        conversion.put(0.3, 3.0);

    }

    private static void workDistribution(ArrayList<TeamMember> teamMembers, ArrayList<Work> works, HashMap<Double, Double> conversion) {

        HashMap<WorkCategory, ArrayList<TeamMember>> teamMembersByCategory = divideWorkersIntoCategories(teamMembers);

        PriorityQueue<Work> priorityQueueWorks = createQueueOfWorks(works, teamMembersByCategory);

        while (!priorityQueueWorks.isEmpty()) {

            TeamMember fastWorker = null;
            int minCountOfDaysToWork = Integer.MAX_VALUE;

            for (TeamMember teamMember : teamMembersByCategory.get(priorityQueueWorks.peek().getWorkCategory())) {
                Double degreeWorkTypeOfWorker = teamMember.getWorker().getWorkTypeWorker().get(priorityQueueWorks.peek().getWorkType().getWorkTypeName());
                if (degreeWorkTypeOfWorker != null) {

                    int currentCountOfDaysToWork = 0;
                    double progressOfExecution = 0;
                    double coefKnowledge = conversion.get(teamMember.getWorker().getCoefKnowledge());
                    double focusFactor = teamMember.getWorker().getFocusFactor();

                    while (progressOfExecution < priorityQueueWorks.peek().getEstimateTime()) {
                        double currentInvolvement = 1; //не учитывается свободная вовлеченность на конкретный день
                        progressOfExecution += coefKnowledge * focusFactor * degreeWorkTypeOfWorker * currentInvolvement;
                        currentCountOfDaysToWork++;

                    }
                    if (currentCountOfDaysToWork < minCountOfDaysToWork) {
                        fastWorker = teamMember;
                    }
                }

            }

//            fastWorker.setWork(priorityQueueWorks.poll()); TODO create new Object WorksForTeamMember(fastWorker, Work)
        }
    }

    private static HashMap<WorkCategory, ArrayList<TeamMember>> divideWorkersIntoCategories(ArrayList<TeamMember> teamMembers) {
        HashMap<WorkCategory, ArrayList<TeamMember>> teamMembersByCategory = new HashMap<>();

        teamMembersByCategory.put(WorkCategory.ANALYTICS, new ArrayList<>());
        teamMembersByCategory.put(WorkCategory.DEVELOP, new ArrayList<>());
        teamMembersByCategory.put(WorkCategory.TESTING, new ArrayList<>());

        for (TeamMember teamMember : teamMembers) {
            teamMembersByCategory.get(teamMember.getWorker().getGroup().groupName).add(teamMember);
        }

        return teamMembersByCategory;
    }

    private static PriorityQueue<Work> createQueueOfWorks(ArrayList<Work> works, HashMap<WorkCategory, ArrayList<TeamMember>> teamMembers) {
        PriorityQueue<Work> worksQueue = new PriorityQueue<>((first, second) -> first.getCountWorker() - second.getCountWorker());

        for (Work work : works) {
            for (TeamMember teamMember : teamMembers.get(work.getWorkCategory())) {
                Double workTypeOfWorker = teamMember.getWorker().getWorkTypeWorker().get(work.getWorkType().getWorkTypeName());
                if (workTypeOfWorker != null) {
                    work.increaseCountWorker();
                }
            }
            if (work.getCountWorker() != 0) {
                worksQueue.add(work);
            }
        }

        return worksQueue;
    }
}