package SingleNumII;

public class Solution {

	public static int singleNumber(int[] A) {
		int[] digits = new int[32];  
	    for(int i=0;i<32;i++)  
	    {  
	        for(int j=0;j<A.length;j++)  
	        {  
	            digits[i] += (A[j]>>i)&1;  
	        }  
	    }  
	    int res = 0;  
	    for(int i=0;i<32;i++)  
	    {  
	        res += (digits[i]%3)<<i;  
	    }  
	    return res;  
        
    }
	public static void main(String[] args) {
		int[] num = {-1,2,1,2,-1,-1,2};
    	System.out.print(singleNumber(num));
    	return;
	}

}
