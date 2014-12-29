package Pascal_sTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		if(rowIndex < 0)
			return result;
		result.add(1);
		if(rowIndex == 0)
			return result;
		
		for(int i = 1; i <= rowIndex / 2 ; i++){
			long tm = (long)result.get(i-1) * (rowIndex - i + 1) / i ;
			result.add((int)tm);
		}
		for(int i = rowIndex / 2 + 1; i <= rowIndex; i++){
			result.add(result.get(rowIndex - i));
		}
		return result;
        
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		for(int i = 1; i< 31; i ++){
			System.out.println(getRow(i));
		}

	}

}
