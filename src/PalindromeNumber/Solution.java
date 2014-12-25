package PalindromeNumber;

public class Solution {

	public static boolean isPalindrome(int x) {
		if(x<0)
			return false;
		int maxN = 1,left,right;
		while(x / maxN >= 10)
			maxN *= 10;
		while(x != 0){
			left = x / maxN;
			right = x % 10;
			if(left != right){
				return false;
			}
			x = (x % maxN) / 10;
			maxN /= 100;
		}	
		return true;
        
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] test = {123321,12321,11,1,-1,0,2311,2122,2147483647};
		for(int i = 0; i < test.length; i ++){
			System.out.println(isPalindrome(test[i]));
		}

	}

}
