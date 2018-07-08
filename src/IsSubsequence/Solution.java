package IsSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int i=0,j=0;
        while(i<lenS && j<lenT){
            while(j<lenT && s.charAt(i) != t.charAt(j)){
                j++;
            }
            if(j == lenT){
                break;
            }
            i++;
            j++;
        }
        if(i == lenS){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ace";
        String s1 = "aec";
        String t = "abcde";
        System.out.println(solution.isSubsequence(s, t));
        System.out.println(solution.isSubsequence(s1, t));
    }

}
