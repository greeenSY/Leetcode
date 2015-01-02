package UniquePathsII;

public class Solution {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if(m==0)
			return 0;
		int n = obstacleGrid[0].length;
		if(n==0)
			return 0;
		int[][] result = new int[m][n];
		
		for(int i = 0; i < m; i++){
			if(obstacleGrid[m-i-1][n-1]==1){
				for(int k = i; k < m; k++)
					result[k][0] = 0;
				break;
			}
			else
				result[i][0] = 1;
		}
		for(int j = 0; j < n; j++){
			if(obstacleGrid[m-1][n-1-j]==1){
				for(int k = j; k < n; k++)
					result[0][k] = 0;
				break;
			}
			else
				result[0][j] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(obstacleGrid[m-1-i][n-1-j]==1)
					result[i][j] = 0;
				else 
					result[i][j] = result[i][j-1] + result[i-1][j];
			}
		}
		
		return result[m-1][n-1];
        
    }
	public static void main(String[] args) {

		int[][] s = {{0,0,0},{0,1,0},{0,0,0}};
		int[][] s1 = {{1,0}};
		int[][] s2 = {{0,1}};
		int[][] s3 = {{1,0},{0,0}};
		System.out.println(uniquePathsWithObstacles(s3));
			

	}

}
