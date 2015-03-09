package ReverseInteger;

public class Solution {

	static int reverse(int x) {
		int overflow = 2147483647 /10;
		int i,s=0;
		for(i=0; x!=0;i++){
			if(s>overflow || s< -overflow)
				return 0;
			s = (s*10)+x%10;
			x /=10;
		}
		if(x<0)
			s = -s;
		return s;
        
    }
	public static void main(String[] args) {
		int a = -113;
		System.out.println(reverse(a));

	}

}
