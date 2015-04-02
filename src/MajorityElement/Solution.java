package MajorityElement;

public class Solution {

	public static int majorityElement(int[] num) {
		int n = num.length;
		int candidate = 0,count = 0;
		for(int i=0; i<n; i++){
			if(count==0){
				candidate = num[i];
				count =1;
			}else{
				
				if(num[i]==candidate)
					count++;
				else
					count--;
			}
		}
		return candidate;
        
    }
	public static void main(String[] args) {
		int[] a = {1,2,3,4,3,2,1,2,2,2,2};
		System.out.println(majorityElement(a));
	}

}
