package WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

// 我们用DFS来解决这个问题吧 
public static List<String> wordBreak4(String s, Set<String> dict) {
    if (s == null || s.length() == 0 || dict == null) {
        return null;
    }
    
    List<String> ret = new ArrayList<String>();
    
    List<String> path = new ArrayList<String>();
    
    int len = s.length();
    
    // i: 表示从i索引开始的字串可以word break.
    boolean[] D = new boolean[len + 1];
    D[len] = true;
    for (int i = len - 1; i >= 0; i--) {
        for (int j = i; j <= len - 1; j++) {
            // 左边从i 到 j
            D[i] = false;
            if (D[j + 1] && dict.contains(s.substring(i, j + 1))) {
                D[i] = true;
                break;
            }
        }
    }

    dfs4(s, dict, path, ret, 0, D);
    
    return ret;
}

public static void dfs4(String s, Set<String> dict, 
        List<String> path, List<String> ret, int index,
        boolean canBreak[]) {
    int len = s.length();
    if (index == len) {
        // 结束了。index到了末尾
        StringBuilder sb = new StringBuilder();
        for (String str: path) {
            sb.append(str);
            sb.append(" ");
        }
        // remove the last " "
        sb.deleteCharAt(sb.length() - 1);
        ret.add(sb.toString());
        return;
    }
    
    // if can't break, we exit directly.
    if (!canBreak[index]) {
        return;
    }

    for (int i =  index; i < len; i++) {
        // 注意这些索引的取值。左字符串的长度从0到len
        String left = s.substring(index, i + 1);
        if (!dict.contains(left)) {
            // 如果左字符串不在字典中，不需要继续递归
            continue;
        }
        
        // if can't find any solution, return false, other set it 
        // to be true;
        path.add(left);
        dfs4(s, dict, path, ret, i + 1, canBreak);
        path.remove(path.size() - 1);
    }

}
*/
public class Solution {

	// 我们用DFS来解决这个问题吧 
    public static List<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if (s == null || s.length() == 0 || dict == null) {
            return null;
        }

        return dfs(s, dict, map);
    }

    // 解法1：我们用DFS来解决这个问题吧 
    public static List<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<String>();
        int len = s.length();

        if (len == 0) {
            list.add("");
        } else {
            // i 表示左边字符串的长度
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);

                // 左边的子串可以为空，或是在字典内
                if (!dict.contains(sub)) {
                    continue;
                }

                // 字符串划分为2边，计算右边的word break.
                List<String> listRight = dfs(s.substring(i, len), dict, map);

                // 右边不能break的时候，我们跳过.
                if (listRight.size() == 0) {
                    continue;
                }

                // 把左字符串加到右字符串中，形成新的解.
                for (String r: listRight) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sub);
                    if (i != 0 && i != len) {
                        // 如果左边为空，或是右边为空，不需要贴空格
                        sb.append(" ");
                    }
                    sb.append(r);
                    list.add(sb.toString());
                }
            }
        }

        map.put(s, list);
        return list;
    }
	public static void main(String[] args) {
		String s="aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aaa");
		List<String> res = wordBreak(s,dict);
		for(String str:res){
			System.out.println(str);
		}

	}

}
