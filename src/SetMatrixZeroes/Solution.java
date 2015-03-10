package SetMatrixZeroes;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	 * click to show follow up.
	 * 
	 * Follow up:
	 * Did you use extra space?
	 * A straight forward solution using O(mn) space is probably a bad idea.
	 * A simple improvement uses O(m + n) space, but still not the best solution.
	 * Could you devise a constant space solution?
	 * 
	 */
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if(m==0)
			return;
		int n = matrix[0].length;
		List<List<Integer>> zeroes = new ArrayList<List<Integer>>();
		if(n==0)
			return;
		for(int i=0; i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==0){
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(i);tmp.add(j);
					zeroes.add(tmp);
				}
			}
		}
		for(int i=0; i<zeroes.size();i++){
			int x  = zeroes.get(i).get(0);
			int y = zeroes.get(i).get(1);
			for(int k=0;k<m;k++)
				matrix[k][y]=0;
			for(int k=0;k<n;k++)
				matrix[x][k]=0;
		}
    }
	//better, using constant space
	public void setZeroes2(int[][] matrix) {
	
	    if(matrix==null || matrix.length==0 || matrix[0].length==0)
	        return;
	    boolean rowFlag = false;
	    boolean colFlag = false;
	    for(int i=0;i<matrix.length;i++)
	    {
	        if(matrix[i][0]==0)
	        {
	            colFlag = true;
	            break;
	        }
	    }
	    for(int i=0;i<matrix[0].length;i++)
	    {
	        if(matrix[0][i]==0)
	        {
	            rowFlag = true;
	            break;
	        }
	    }      
	    for(int i=1;i<matrix.length;i++)
	    {
	        for(int j=1;j<matrix[0].length;j++)
	        {
	            if(matrix[i][j]==0)
	            {
	                matrix[i][0] = 0;
	                matrix[0][j] = 0;
	            }
	        }
	    }
	    for(int i=1;i<matrix.length;i++)
	    {
	        for(int j=1;j<matrix[0].length;j++)
	        {
	            if(matrix[i][0]==0 || matrix[0][j]==0)
	                matrix[i][j] = 0;
	        }
	    }
	    if(colFlag)
	    {
	        for(int i=0;i<matrix.length;i++)
	        {
	            matrix[i][0] = 0;
	        }
	    }
	    if(rowFlag)
	    {
	        for(int i=0;i<matrix[0].length;i++)
	        {
	            matrix[0][i] = 0;
	        }
	    }
	}
	public static void main(String[] args) {
		int cases[][] = {{1,3,4,1},{0,1,2,3},{9,2,0,1}};
		for(int i=0; i<cases.length;i++){
			for(int j=0;j<cases[i].length;j++)
				System.out.print(cases[i][j]);
			System.out.println();
		}
		setZeroes(cases);
		System.out.println();
		for(int i=0; i<cases.length;i++){
			for(int j=0;j<cases[i].length;j++)
				System.out.print(cases[i][j]);
			System.out.println();
		}
	}

}
