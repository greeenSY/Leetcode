package ScrambleString;

public class Solution {
	private
		static boolean[][][] f = new boolean[100][100][100];
	public static boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()) 
			return false;  
		for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++)
                f[1][i][j] = (s1.charAt(i) == s2.charAt(j));
                
        for(int len = 2; len <= s1.length(); len++)
        {
            for(int s1Beg = 0; s1Beg < s1.length(); s1Beg++)
            {
                int s1End = s1Beg + len - 1;
                if (s1End >= s1.length())
                    break;
                
                for(int s2Beg = 0; s2Beg < s2.length(); s2Beg++)
                {
                    int s2End = s2Beg + len - 1;
                    if (s2End >= s2.length())
                        break;
                    
                    f[len][s1Beg][s2Beg] = false;    
                    for(int s1Mid = s1Beg; s1Mid < s1End; s1Mid++)
                    {
                        int leftSize = s1Mid - s1Beg + 1;
                        int rightSize = len - leftSize;
                        int s2Mid = s2Beg + leftSize - 1;
                        boolean res1 = f[leftSize][s1Beg][s2Beg] && f[rightSize][s1Mid+1][s2Mid+1];
                        
                        s2Mid = s2End - leftSize;
                        boolean res2 = f[leftSize][s1Beg][s2Mid+1] && f[rightSize][s1Mid+1][s2Beg];
                        
                        f[len][s1Beg][s2Beg] = f[len][s1Beg][s2Beg] || res1 || res2;
                    }
                }
            }
        }
        
        return f[s1.length()][0][0];
		        
    }
	public static void main(String[] args) {
		String s1 = "aab",s2 = "aba",s3="baa";

		System.out.println(isScramble(s1,s2));
		//System.out.println(isScramble(s3,s2));
		//System.out.println(isScramble(s1,s3));
	}

}
