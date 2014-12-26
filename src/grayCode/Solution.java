package grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<Integer> grayCode(int n) {
		
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		if(n == 0)
			return result;
		int tmp = 1;
		for(int i = 0; i < n; i++){
			int len = result.size();
			for(int j = len-1; j >= 0; j--){
				result.add(tmp+result.get(j));
			}
			tmp *= 2;
		}
		return result;
        
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		for(int i = 0; i < 4; i++){
			System.out.println(grayCode(i));
		}

	}

}
