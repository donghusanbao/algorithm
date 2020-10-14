package greedy;

public class Code134_CompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int n = gas.length;
        int index = -1;
        int i = 0;
        while (i < n) {
            int save = 0;
            if (gas[i] < cost[i]) {
                i++;
                continue;
            }
            int breakPoint = -1;
            for (int j = 0; j < n; j++) {
                save = save + gas[(j + i) % n] - cost[(j + i) % n];
                if (save < 0) {
                    breakPoint = j + i;
                    break;
                }
            }
            if (breakPoint == -1) {
                index = i;
                break;
            } else {
                if (breakPoint >= n - 1) {
                    return -1;
                } else {
                    i = breakPoint + 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3,4, 3};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
