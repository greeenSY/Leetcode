package UniquePaths;

public class Solution {

	public static long uniquePaths(int m, int n) {
		int[][] result = new int[m+1][n+1];
		if(m==0||n==0)
			return 0;
		for(int i = 1; i <= m; i++){
			result[i][1] = 1;
		}
		for(int i = 1; i <= n; i++){
			result[1][i] = 1;
		}
		for(int i = 2; i <= m; i++){
			for(int j = 2; j <= n; j++){
				result[i][j] = result[i][j-1] + result[i-1][j];
			}
		}
		
		return result[m][n];
        
    }
	public static void main(String[] args) {
		System.out.println(uniquePaths(4,4));
		
	}

}
