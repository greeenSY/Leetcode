package PerfectNumber;

public class Solution {

    public boolean checkPerfectNumber(int num) {
        if(num == 1){
            return false;
        }
        int sum=1, i=2, max = (int)Math.sqrt(num);
        for(; i<=max; i++){
            if(num % i == 0){
                sum += i;
                if (i != num / i) sum += num / i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkPerfectNumber(6));
        System.out.println(s.checkPerfectNumber(28));
        System.out.println(s.checkPerfectNumber(35));
        System.out.println(s.checkPerfectNumber(36));
    }

}
