package ThreeSums;
import java.io.IOException;


public class Solution {
	public final static int MAX_INT = 2147483647;
	public static int abs(int a){
		if(a>0)
			return a;
		else
			return -a;
	}
    public static int threeSumClosest(int[] num, int target) throws IOException {
        int n = num.length;
        int[] num1 = new int[n*n*n];
        int s = 0;
        for(int i = 0; i < n; i++){
        	for(int j = i+1; j < n; j++){
        		for(int k = j+1; k < n; k++){
        			num1[s++] = num[i]+num[j]+num[k];
        		}
        	}
        }
        int t = MAX_INT;
        int result = MAX_INT;
        int tmp = 0;
        for(int i = 0; i < s; i++){
        	tmp = num1[i]- target;
        	if(abs(tmp) < t){
        		t= abs(tmp);
        		result = num1[i];
        	}
        }
        
		return result;
        
    }
    public static void main(String[] args) throws IOException
	{
    	int[] num = {-1,2,1,-4};
    	int target = 1;
    	System.out.print(threeSumClosest(num,target));
    	return;
	}
}