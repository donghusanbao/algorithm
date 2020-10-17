package questions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Ext_FindJob {
    public static class Job {
        public int ability;
        public int salary;
        public Job(int ability, int salary) {
            this.ability = ability;
            this.salary = salary;
        }
    }

    public static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job job1, Job job2) {
            return job1.ability == job2.ability ? (job2.salary - job1.salary) : (job1.ability - job2.ability);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int jobNum = sc.nextInt();
        int friendNum = sc.nextInt();
        Job[] jobs = new Job[jobNum];
        for (int i = 0; i < jobNum; i++) {
            jobs[i] = new Job(sc.nextInt(), sc.nextInt());
        }
        int[] friends = new int[friendNum];
        for (int i = 0; i < friendNum; i++) {
            friends[i] = sc.nextInt();
        }
        Arrays.sort(jobs, new JobComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(jobs[0].ability, jobs[0].salary);
        int preAbility = jobs[0].ability;
        int preSalary = jobs[0].salary;
        for (int i = 1; i < jobNum; i++) {
            if (jobs[i].ability != preAbility && (jobs[i].salary > preSalary)) {
                map.put(jobs[i].ability, jobs[i].salary);
                preAbility = jobs[i].ability;
                preSalary = jobs[i].salary;
            }
        }
        for (int i = 0; i < friendNum; i++) {
            System.out.println(map.floorKey(friends[i]) == null ? 0 : map.get(map.floorKey(friends[i])));
        }
    }
}
