package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        HashMap<Double, Double> conversion = new HashMap<>();
        conversion.put(1.0, 1.0);
        conversion.put(0.9, 1.2);
        conversion.put(0.8, 1.4);
        conversion.put(0.7, 1.7);
        conversion.put(0.6, 2.0);
        conversion.put(0.5, 2.2);
        conversion.put(0.4, 2.4);
        conversion.put(0.3, 2.7);
        conversion.put(0.2, 2.9);
        conversion.put(0.1, 3.1);

        Group analytics = new Group(WorkCategory.ANALYTICS);
        Group develop = new Group(WorkCategory.DEVELOP);
        Group testing = new Group(WorkCategory.TESTING);

        WorkType wt1 = new WorkType("wt1");
        WorkType wt2 = new WorkType("wt2");
        WorkType wt3 = new WorkType("wt3");
        WorkType wt4 = new WorkType("wt4");
        WorkType wt5 = new WorkType("wt5");
        WorkType wt6 = new WorkType("wt6");
        WorkType wt7 = new WorkType("wt7");

        TeamMember tm1 = new TeamMember(new Worker(1, "Аналитик1", analytics, 0.8, 0.65));
        TeamMember tm2 = new TeamMember(new Worker(2, "Аналитик2", analytics, 0.6, 0.7));
        TeamMember tm3 = new TeamMember(new Worker(3, "Разработчик1", develop, 0.8, 0.8));
        TeamMember tm4 = new TeamMember(new Worker(4, "Разработчик2", develop, 0.65, 0.8));
        TeamMember tm5 = new TeamMember(new Worker(5, "Разработчик3", develop, 0.9, 0.8));
        TeamMember tm6 = new TeamMember(new Worker(6, "Тестировщик1", testing, 0.85, 0.8));
        TeamMember tm7 = new TeamMember(new Worker(7, "Тестировщик2", testing, 0.8, 0.8));

        tm1.getWorker().addWorkTypeWorker(wt1, 0.9);
        tm1.getWorker().addWorkTypeWorker(wt2, 0.7);
        tm2.getWorker().addWorkTypeWorker(wt1, 0.8);
        tm2.getWorker().addWorkTypeWorker(wt2, 0.8);
        tm3.getWorker().addWorkTypeWorker(wt3, 0.8);
        tm3.getWorker().addWorkTypeWorker(wt4, 0.75);
        tm4.getWorker().addWorkTypeWorker(wt3, 0.9);
        tm4.getWorker().addWorkTypeWorker(wt4, 0.7);
        tm5.getWorker().addWorkTypeWorker(wt3, 0.8);
        tm5.getWorker().addWorkTypeWorker(wt4, 0.7);
        tm5.getWorker().addWorkTypeWorker(wt5, 0.7);
        tm6.getWorker().addWorkTypeWorker(wt6, 0.75);
        tm6.getWorker().addWorkTypeWorker(wt7, 0.7);
        tm7.getWorker().addWorkTypeWorker(wt6, 0.7);
        tm7.getWorker().addWorkTypeWorker(wt7, 0.8);

        ArrayList<TeamMember> projectTeam = new ArrayList<>();
        projectTeam.add(tm1);
        projectTeam.add(tm2);
        projectTeam.add(tm3);
        projectTeam.add(tm4);
        projectTeam.add(tm5);
        projectTeam.add(tm6);
        projectTeam.add(tm7);

        Work work1 = new Work("work1", wt1, WorkCategory.ANALYTICS, 2, 0.5); //tm1, tm2
        Work work2 = new Work("work2", wt2, WorkCategory.ANALYTICS, 2, 0.4); //tm1, tm2
        Work work3 = new Work("work3", wt3, WorkCategory.DEVELOP, 2, 0.5); //tm3, tm4, tm5
        Work work4 = new Work("work4", wt4, WorkCategory.DEVELOP, 2, 0.4); //tm3, tm4, tm5
        Work work5 = new Work("work5", wt5, WorkCategory.DEVELOP, 3, 0.5); //tm5 only
        Work work6 = new Work("work6", wt6, WorkCategory.TESTING, 2, 0.5); //tm6, tm7
        Work work7 = new Work("work7", wt7, WorkCategory.TESTING, 3, 0.5); //tm6, tm7

        ArrayList<Work> works = new ArrayList<>();
        works.add(work1);
        works.add(work2);
        works.add(work3);
        works.add(work4);
        works.add(work5);
        works.add(work6);
        works.add(work7);

        Map<Integer, List<WorkForTeamMember>> result = getPlanningOptions(projectTeam, works, conversion);
        for (var option : result.entrySet()) {
            System.out.println(option.getValue());
        }
    }

    private static Map<Integer, List<WorkForTeamMember>> getPlanningOptions(ArrayList<TeamMember> projectTeam, ArrayList<Work> worksList, HashMap<Double, Double> conversion) {

        Map<WorkCategory, List<TeamMember>> teamMembersByCategory = groupingWorkersIntoCategories(projectTeam);
        List<Work> works = assignmentOfWorksToWorkers(worksList, teamMembersByCategory);

        Map<Integer, List<WorkForTeamMember>> planningOptions = new HashMap<>();

        planningOptions.put(0, new ArrayList<>());
        planningOptions.put(1, new ArrayList<>());
        planningOptions.put(2, new ArrayList<>());
        planningOptions.put(3, new ArrayList<>());
        planningOptions.put(4, new ArrayList<>());


        WorkForTeamMember workForTeamMember;
        List<WorkForTeamMember> worksForTeamMemberList = new ArrayList<>();

        for (Work work : works) {

            for (TeamMember tm : work.getPotentialPerformers()) {
                workForTeamMember = new WorkForTeamMember(work, tm);
                worksForTeamMemberList.add(workForTeamMember);
            }

            Collections.sort(worksForTeamMemberList, (wt1, wt2) -> wt1.getExecutionTime() - wt2.getExecutionTime());

            int countOptions = 0;
            Iterator<WorkForTeamMember> iterator = worksForTeamMemberList.iterator();
            while (countOptions < planningOptions.size()) {
                WorkForTeamMember current = null;
                if (iterator.hasNext()) {
                    current = iterator.next();
                }
                planningOptions.get(countOptions).add(current);
                countOptions++;
            }

            worksForTeamMemberList.clear();
        }

        return planningOptions;
    }

    private static Map<WorkCategory, List<TeamMember>> groupingWorkersIntoCategories(ArrayList<TeamMember> teamMembers) {
        return teamMembers.stream().collect(Collectors.groupingBy(tm -> tm.getWorker().getGroup().groupName));
    }

    private static List<Work> assignmentOfWorksToWorkers(ArrayList<Work> works, Map<WorkCategory, List<TeamMember>> teamMembers) {
        List<Work> worksSort = new ArrayList<>();

        for (var work : works) {
            for (var teamMember : teamMembers.get(work.getWorkCategory())) {
                Double workTypeOfWorker = teamMember.getWorker().getWorkTypeWorker().get(work.getWorkType().getWorkTypeName());
                if (workTypeOfWorker != null) {
                    work.addPotentialPerformer(teamMember);
                }
            }
            if (!work.getPotentialPerformers().isEmpty()) {
                worksSort.add(work);
            }
        }

        Collections.sort(worksSort, (first, second) -> first.getPotentialPerformers().size() - second.getPotentialPerformers().size());

        return worksSort;
    }
}
