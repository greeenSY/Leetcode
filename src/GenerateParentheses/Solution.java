package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	static int stringCheck(String str,int n){
		int left=0,right=0,i=0;
		while(i<str.length()){
			if(str.charAt(i) == '(')
				left++;
			else 
				right++;
			if(left>n || right>n || left<right)
				return -1;
			i++;
		}
		if(str.length()==2*n)
			return 1;
		else
			return 0;
	}
	public static List<String> generateParenthesis(int n) {
		List<String> re= new ArrayList<String>();
		Stack<String> sk = new Stack<String>(); 
		String[] a = {"(",")"};
		sk.push("(");
		while(!sk.isEmpty()){
			String tmp = sk.pop();
			for(int i=0;i<2;i++){
				String t = tmp+a[i];
				int r = stringCheck(t,n);
				if(r==0)
					sk.push(t);
				else if(r==1)
					re.add(t);
			}
		}
		return re;
	        
	}
	public static void main(String[] args) {
		System.out.println(generateParenthesis(4));

	}

}
