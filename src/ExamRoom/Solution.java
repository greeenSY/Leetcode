package ExamRoom;

public class Solution {

	public static int climbStairs(int n) {
		if(n<1){
			return 0; 
		}else if(n<3){
			return n;
		}
        int[] res = new int[n+1];
        res[0]=0;res[1]=1;res[2]=2;
        for(int i=3; i<=n; i++){
        	res[i] = res[i-1] + res[i-2];
        }
		return res[n];
    }
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		return;

	}

}
