package WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

// ������DFS������������� 
public static List<String> wordBreak4(String s, Set<String> dict) {
    if (s == null || s.length() == 0 || dict == null) {
        return null;
    }
    
    List<String> ret = new ArrayList<String>();
    
    List<String> path = new ArrayList<String>();
    
    int len = s.length();
    
    // i: ��ʾ��i������ʼ���ִ�����word break.
    boolean[] D = new boolean[len + 1];
    D[len] = true;
    for (int i = len - 1; i >= 0; i--) {
        for (int j = i; j <= len - 1; j++) {
            // ��ߴ�i �� j
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
        // �����ˡ�index����ĩβ
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
        // ע����Щ������ȡֵ�����ַ����ĳ��ȴ�0��len
        String left = s.substring(index, i + 1);
        if (!dict.contains(left)) {
            // ������ַ��������ֵ��У�����Ҫ�����ݹ�
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

	// ������DFS������������� 
    public static List<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if (s == null || s.length() == 0 || dict == null) {
            return null;
        }

        return dfs(s, dict, map);
    }

    // �ⷨ1��������DFS������������� 
    public static List<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<String>();
        int len = s.length();

        if (len == 0) {
            list.add("");
        } else {
            // i ��ʾ����ַ����ĳ���
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);

                // ��ߵ��Ӵ�����Ϊ�գ��������ֵ���
                if (!dict.contains(sub)) {
                    continue;
                }

                // �ַ�������Ϊ2�ߣ������ұߵ�word break.
                List<String> listRight = dfs(s.substring(i, len), dict, map);

                // �ұ߲���break��ʱ����������.
                if (listRight.size() == 0) {
                    continue;
                }

                // �����ַ����ӵ����ַ����У��γ��µĽ�.
                for (String r: listRight) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sub);
                    if (i != 0 && i != len) {
                        // ������Ϊ�գ������ұ�Ϊ�գ�����Ҫ���ո�
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
