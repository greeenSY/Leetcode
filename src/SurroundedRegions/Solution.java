package SurroundedRegions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/*class pos{
		int x,y;
		pos(int a,int b){
			x=a;y=b;
		}
	}
	
	static Solution s = new Solution();
	*/
	public static void solve(char[][] board) {
		
		int n = board.length;
		if(n <= 0)
			return;
		int m = board[0].length;
		if(m <= 0)
			return;
		
		Set<String> safe = new HashSet<String>();
		Stack<int[]> sk = new Stack<int[]>();  
		for(int i = 0; i < n; i++){
			if(board[i][0] == 'O'){
				int[] t = new int[2];
				t[0]=i;t[1]=0;
				String a = t[0]+","+t[1];
				safe.add(a);
				sk.push(t);
			}
			if(board[i][m-1] == 'O'){
				int[] t = new int[2];
				t[0]=i;t[1]=m-1;
				String a = t[0]+","+t[1];
				safe.add(a);
				sk.push(t);
			}
				
		}
		for(int j = 1; j < m-1; j++){
			if(board[0][j] == 'O'){
				int[] t = new int[2];
				t[0]=0;t[1]=j;
				String a = t[0]+","+t[1];
				safe.add(a);
				sk.push(t);
			}
			if(board[n-1][j] == 'O'){
				int[] t = new int[2];
				t[0]=n-1;t[1]=j;
				String a = t[0]+","+t[1];
				safe.add(a);
				sk.push(t);
			}	
		}
		while(!sk.isEmpty()){
			int[] t = sk.pop();
			for(int i = 0; i < 4; i++){
				int[] tN = getNeighbour(t,i);
				String a = tN[0]+","+tN[1];
				if(tN==null || tN[0] < 0 || tN[0] >= n || tN[1] < 0 || tN[1] >= m)
					continue;
				if(board[tN[0]][tN[1]] == 'O' && !safe.contains(a)){
					safe.add(a);
					sk.push(tN);
				}
			}
		}
		for(int i = 1; i < n -1 ; i++)
			for(int j = 1; j < m -1; j++){
				int[] t = new int[2];t[0]=i;t[1]=j;
				String a = t[0]+","+t[1];
				if(board[i][j] == 'O' && !safe.contains(a))
						board[i][j] = 'X';
					
			}
    }
	private static int[] getNeighbour(int[] t, int i) {
		int[] tN = new int[2];
		switch(i){
			case 0: tN[0] = t[0]-1; tN[1] = t[1];break;
			case 1: tN[0] = t[0]; tN[1] = t[1]-1;break;
			case 2: tN[0] = t[0]+1; tN[1] = t[1];break;
			case 3: tN[0] = t[0]; tN[1] = t[1]+1;break;
			default: return null;
		}
		return tN;
	}
	public static void main(String[] args) {
		//char[][] a = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char[][] a = {{'O','X','O'},{'X','O','X'},{'O','X','O'}};
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
			System.out.print(a[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		solve(a);
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
			System.out.print(a[i][j]);
			}
			System.out.println("");
		}
	}

}
