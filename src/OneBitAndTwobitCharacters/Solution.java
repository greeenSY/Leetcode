package OneBitAndTwobitCharacters;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length-1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }
        return i==bits.length-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bits = {1, 1, 1, 0};
        int[] bits2 = {1, 0, 0};
        System.out.println(solution.isOneBitCharacter(bits));
        System.out.println(solution.isOneBitCharacter(bits2));
    }

}
