package LongestPalindromicSubstring;

public class Solution {

	public String longestPalindrome(String s) {
		int n = s.length();
		int max = 1;
		int res = 0;
		if(n==0)
			return null;
        for(int i=0; i<n; i++){
        	int j=1;
        	for(; j<=i && j<n-i; j++){
        		if(s.charAt(i-j) != s.charAt(i+j)){
        			break;
        		}
        	}
        	if(2*--j+1 > max){
        		max = j*2+1;
        		res = i-j;
        	}
        	j = 1;
        	for(; j<=i+1 && j<n-i; j++){
        		if(s.charAt(i+1-j) != s.charAt(i+j)){
        			break;
        		}
        	}
        	if(--j*2 > max){
        		max = j*2;
        		res = i+1-j;
        	}
        }
		return s.substring(res,res+max);
    }
	public static void main(String[] args) {
		Solution s= new Solution();
		String a= "aaa";
		System.out.println(s.longestPalindrome(a));
		return;

	}

}
