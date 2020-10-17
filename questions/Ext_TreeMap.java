package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class Ext_TreeMap {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int workNum =sc.nextInt();
        int peopleNum =sc.nextInt();
        TreeMap<Integer, Integer> abilityEarns = new TreeMap<>();
        for (int i = 0; i < workNum; i++) {
            int ability = sc.nextInt();
            System.out.println("ability:" + ability);
            int earn = sc.nextInt();
            System.out.println("earn" +earn);
            if (abilityEarns.containsKey(ability)) {
                if (abilityEarns.get(ability) < earn) {
                    abilityEarns.put(ability, earn);
                }
            } else if (abilityEarns.floorKey(ability) == null ||
                    (abilityEarns.floorKey(ability) < earn )) {
                abilityEarns.put(ability, earn);
            }
        }
        System.out.println("============");
        for (int i = 0; i < peopleNum; i++) {
            int level = sc.nextInt();
            if (abilityEarns.floorKey(level) == null) {
                System.out.println(0);
            } else {
                int floorKey = abilityEarns.floorKey(level);
                System.out.println(abilityEarns.get(floorKey));
            }
        }
        System.out.println("**********");
    }
}
