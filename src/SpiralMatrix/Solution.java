package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

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
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;
		if(m <= 0)
			return result;
		int n = matrix[0].length;
		if(n <= 0)
			return result;
		
		int i,j,left=0,right=n-1,top=0,bottom=m-1;
		while(left<=right && top<=bottom){
			for(j = left; j <= right; j++){
				result.add(matrix[top][j]);
			}
			for(i = top+1; i <= bottom; i++){
				result.add(matrix[i][right]);
			}
			for(j = right-1; j >= left && i > top+1; j--){
				result.add(matrix[bottom][j]);
			}
			for(i = bottom-1; i >= top+1 && j < right-1; i--){
				result.add(matrix[i][left]);
			}
			left++;right--;top++;bottom--;
		}
		
		return result;
	}
	 
	public static void main(String[] args) {
		int[][] t = generateMatrix(5);
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j <t[i].length; j ++)
				System.out.print(t[i][j]+" ");
			System.out.println("");
		}
		int[][] t1 = {{7},{9},{6}};
		List<Integer> s = spiralOrder(t1);
		System.out.println(s);

	}

}
