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
        conversion.put(0.9, 1.25);
        conversion.put(0.7, 2.0);
        conversion.put(0.5, 2.5);
        conversion.put(0.3, 3.0);



    }

    private static void workDistribution(ArrayList<WorksForTeamMember> teamMembers, ArrayList<Work> works, HashMap<Double, Double> conversion) {

        ArrayList<WorksForTeamMember> analytics = new ArrayList<>();
        ArrayList<WorksForTeamMember> develop = new ArrayList<>();
        ArrayList<WorksForTeamMember> testing = new ArrayList<>();
        HashMap<WorkCategory, ArrayList<WorksForTeamMember>> teamMembersByCategory = new HashMap<>();

        for (WorksForTeamMember teamMember : teamMembers) {
            switch (teamMember.getTeamMember().getWorker().getGroup().getGroupName()) {
                case ANALYTICS:
                    analytics.add(teamMember);
                    break;
                case DEVELOP:
                    develop.add(teamMember);
                    break;
                case TESTING:
                    testing.add(teamMember);
                    break;
            }
            teamMembersByCategory.put(WorkCategory.ANALYTICS, analytics);
            teamMembersByCategory.put(WorkCategory.DEVELOP, develop);
            teamMembersByCategory.put(WorkCategory.TESTING, testing);
        }

        PriorityQueue<Work> priorityQueueWorks = new PriorityQueue<>();
        for (Work work : works) {
            for (WorksForTeamMember teamMember : teamMembersByCategory.get(work.getWorkCategory())) {
                // return value degreeWorkType if worker can perform this type work, else return null
                Double workTypeOfWorker = teamMember.getTeamMember().getWorker().getWorkTypeWorker().get(work.getWorkType().getWorkTypeName());
                if (workTypeOfWorker != null) {
                    work.increaseCountWorker();
                }
            }
            // если не найдется сотрудников, которые могут выполнить эту работу, она все равно добавится в очередь самой первой (приоритет 0)
            // может не добавлять ее? т.к. на следующей стадиии алгоритма для каждой такой работы
            // мы сделаем O(n) по списку сотрудников, но не назначим сотрудника на эту работу

            // Solution -> if (work.getCountWorkerWhoCanDoThisWork() != 0) { priorityQueueWorks.add(work); }
            priorityQueueWorks.add(work);
        }

        while (!priorityQueueWorks.isEmpty()) {

            WorksForTeamMember fastWorker = null;
            int minCountOfDaysToWork = Integer.MAX_VALUE;

            for (WorksForTeamMember teamMember : teamMembersByCategory.get(priorityQueueWorks.peek().getWorkCategory())) {
                Double degreeWorkTypeOfWorker = teamMember.getTeamMember().getWorker().getWorkTypeWorker().get(priorityQueueWorks.peek().getWorkType().getWorkTypeName());
                // return degreeWorkType if worker can perform this type work, else return null
                if (degreeWorkTypeOfWorker != null) {

                    int currentCountOfDaysToWork = 0;
                    double progressOfExecution = 0;
                    double coefKnowledge = conversion.get(teamMember.getTeamMember().getWorker().getCoefKnowledge());
                    double focusFactor = teamMember.getTeamMember().getWorker().getFocusFactor();

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

            fastWorker.setWork(priorityQueueWorks.poll());
        }

        //если сотрудник может выполнять такой тип работы, то считаем
        //нужно завести временную поле, которое будет хранить сотрудника, который быстрее всего выполнит задачу
        //если назначили сотрудника на работу, то лучше его удалить из списка. чтобы в дальнейшем не выполнять на нем расчеты для других работ,
        //т.к. его свободная вовлеченность будет явно меньше, чем у других сотрудников.
        //upd. лучше не удалять, т.к. возможно есть работы, которые может выполнить только один сотрудник

        //для лучшей оптимизации лучше сделать PriorityQueue, CompareTo -> количество сотрудников, способных выполнить эту работу

    }
}