package MinCostClimbingStairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        if (cost.length == 1) {
            return cost[0];
        } else if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        result[0] = 0;
        result[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i-1], result[i - 2] + cost[i-2]);
        }
        return result[cost.length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = {10, 15, 20};
        int[] bits2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution.minCostClimbingStairs(bits));
        System.out.println(solution.minCostClimbingStairs(bits2));
    }

}
