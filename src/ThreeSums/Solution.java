package ThreeSums;
import java.io.IOException;
import java.util.Arrays;


public class Solution {
    public static int threeSumClosest(int[] num, int target) {  
    if(num == null || num.length<=2)  
        return Integer.MIN_VALUE;  
    Arrays.sort(num);  
    int closest = num[0]+num[1]+num[2]-target;      
    for(int i=0;i<num.length-2;i++)  
    {  
        int cur = twoSum(num,target-num[i],i+1);  
        if(Math.abs(cur)<Math.abs(closest))  
            closest = cur;   
    }  
    return target+closest;  
	}  
	private static int twoSum(int[] num, int target, int start)  
	{  
	    int closest = num[start]+num[start+1]-target;  
	    int l = start;  
	    int r = num.length-1;  
	    while(l<r)  
	    {  
	        if(num[l]+num[r]==target)  
	            return 0;  
	        int diff = num[l]+num[r]-target;  
	        if(Math.abs(diff)<Math.abs(closest))  
	            closest = diff;      
	        if(num[l]+num[r]>target)  
	        {  
	            r--;  
	        }  
	        else  
	        {  
	            l++;  
	        }  
	    }  
	    return closest;  
	}  
    public static void main(String[] args) throws IOException
	{
    	int[] num = {-1,2,1,-4};
    	int target = 1;
    	System.out.print(threeSumClosest(num,target));
    	return;
	}
}