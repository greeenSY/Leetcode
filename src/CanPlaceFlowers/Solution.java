package CanPlaceFlowers;

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i] == 0){
                if((i>0 && flowerbed[i-1] > 0)
                        || (i<flowerbed.length-1 && flowerbed[i+1] > 0)){
                    continue;
                }
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] flowerbed = {0, 0, 1, 0, 1};
        System.out.println(solution.canPlaceFlowers(flowerbed, 1));
        System.out.println(solution.canPlaceFlowers(flowerbed, 2));
    }

}
