package FrogJump;

import java.util.*;

public class Solution {
    class Step{
        public int stone;
        public Set<Integer> lastK;
        Step(int index){
            stone = index;
            lastK = new HashSet<>();
        }
    }

    public boolean canCross(int[] stones) {
        Map<Integer, Step> map = new HashMap<>();
        for(int i : stones ){
            map.put(i, new Step(i));
        }
        map.get(0).lastK.add(0);
        for(int i : stones){
            Step step = map.get(i);
            for(int k: step.lastK){
                for(int j=k-1; j<=k+1; j++){
                    if(j > 0 && map.containsKey(step.stone + j)) {
                        map.get(step.stone + j).lastK.add(j);
                    }
                }
            }
        }

        return !map.get(stones[stones.length-1]).lastK.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {0,1,3,5,6,8,12,17};
        int[] array2 = {0,1,2,3,4,8,9,11};
        int[] array3 = {0,1,3,6,7};
        int[] array4 = {0,1};
        System.out.println(solution.canCross(array));
        System.out.println(solution.canCross(array2));
        System.out.println(solution.canCross(array3));
        System.out.println(solution.canCross(array4));
    }

}
