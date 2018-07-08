package OneBitAndTwobitCharacters;

public class Solution2 {
    public boolean isOneBitCharacter(int[] bits) {
        int one = 0;
        for(int i = bits.length-2;i>=0;i--){
            if(bits[i]==0) break;
            else one+=1;
        }
        if(one%2 == 1){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] bits = {1, 1, 1, 0};
        int[] bits2 = {1, 0, 0};
        System.out.println(solution.isOneBitCharacter(bits));
        System.out.println(solution.isOneBitCharacter(bits2));
    }

}
