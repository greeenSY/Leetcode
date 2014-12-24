package SingleNum;

import java.io.IOException;

public class Solution {

	 public static int singleNumber(int[] A) {
		int result = 0;
		for(int i = 0; i < A.length; i ++){
			result = result ^ A[i];
		}
		return result;
	        
	}
	 
	public static void main(String[] args) throws IOException
	{
    	int[] num = {-1,2,1,-1,2};
    	System.out.print(singleNumber(num));
    	return;
	}
}
