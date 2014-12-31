package SpiralMatrixII;

public class Solution {

	public static int[][] generateMatrix(int n) {
		
		if(n<0)
			return null;
		int[][] result = new int[n][n];
		if(n == 0)
			return result;
		int i,j;
		for(j = 0; j < n; j++){
			result[0][j] = j+1;
		}
		for(i = 1; i <= n-1; i++){
			result[i][n-1] = i + n;
		}
		for(j = n-2; j >= 0; j--){
			result[n-1][j] = 3*n-2-j;
		}
		for(i = n-2; i >= 1; i--){
			result[i][0] = 4*n-3-i;
		}
		int[][] tmp = generateMatrix(n-2);
		if(tmp == null || tmp.length == 0)
			return result;
		for(i = 1; i < n-1; i ++)
			for(j = 1; j < n -1; j++){
				result[i][j] = 4*n - 4 + tmp[i-1][j-1];
			}
		return result;
        
    }
	public static void main(String[] args) {
		int[][] t = generateMatrix(0);
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j <t[i].length; j ++)
				System.out.print(t[i][j]+" ");
			System.out.println("");
		}

	}

}
