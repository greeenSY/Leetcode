package SimplifyPath;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static String simplifyPath(String path) {
		if(path == null || path == ""){
			return "";
		}
		List<String> re = new ArrayList<String>();
		String []p = path.split("/");
		for(String a:p){
			if(a.equals("")||a.equals(".")){
				continue;
			}else if(a.equals("..")){
				if(re.size() > 0)
					re.remove(re.size()-1);
			}else{
				re.add(a);
			}
		}
		String result="";
		if(re.isEmpty())
			result+="/";
		else
			for(String a:re){
				result+=("/"+a);
			}
		return result;
        
    }
	public static void main(String[] args) {
		String a = "/home/";
		System.out.println(simplifyPath(a));
	}

}
