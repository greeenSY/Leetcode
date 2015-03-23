package Triangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static int minimumTotal(List<List<Integer>> triangle) {
		
		if(triangle == null || triangle.size()==0)
			return 0;
		int n = triangle.size();
		if(n==1)  
	        return triangle.get(0).get(0);  
		int[] q = new int[n];
		q[0] = triangle.get(0).get(0);
		for(int i = 1; i < n; i++){
			q[i] = q[i-1] + triangle.get(i).get(i);
			for(int j=i-1; j>0;j--){
				q[j] = (q[j] < q[j-1] ? q[j] : q[j-1]) + triangle.get(i).get(j);
			}
			q[0] = q[0] + triangle.get(i).get(0);
		}
		int minimum = q[0];  
	    for(int i=1;i<q.length;i++)  
	    {  
	        if(q[i]<minimum)  
	        {  
	            minimum = q[i];  
	        }  
	    }  
	    return minimum;  
        
    }
	public static void main(String[] args) throws IOException{
		List<List<Integer>> triangle = new ArrayList();
		List<Integer> tmp = new ArrayList();
		tmp.add(2);
		triangle.add(tmp);
		tmp = new ArrayList();
		tmp.add(3);tmp.add(4);
		triangle.add(tmp);
		tmp = new ArrayList();
		tmp.add(6);tmp.add(5);tmp.add(7);
		triangle.add(tmp);
		tmp = new ArrayList();
		tmp.add(4);tmp.add(1);tmp.add(8);tmp.add(3);
		triangle.add(tmp);
		
		System.out.println(triangle);
		System.out.println(minimumTotal(triangle));
	}
}
