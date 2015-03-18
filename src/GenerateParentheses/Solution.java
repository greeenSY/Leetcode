package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public ArrayList<String> generateParenthesis2(int n) {
	    ArrayList<String> res = new ArrayList<String>();
	    if(n<=0)
	        return res;
	    helper(n,n,new String(),res);
	    return res;
	}
	private void helper(int l, int r, String item, ArrayList<String> res)
	{
	    if(r<l)
	        return;
	    if(l==0 && r==0)
	    {
	        res.add(item);
	    }
	    if(l>0)
	        helper(l-1,r,item+"(",res);
	    if(r>0)
	        helper(l,r-1,item+")",res);
	}
	
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
