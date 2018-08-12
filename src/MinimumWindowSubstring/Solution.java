package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class  Count{
        int s = 0;
        int t = 0;
        Count(int s, int t){
            this.s = s;
            this.t = t;
        }
    }
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Count> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            if (!s.contains(c.toString())) {
                return "";
            }
            if(!map.containsKey(c)) {
                map.put(c, new Count(0, 1));
            } else {
                map.get(c).t++;
            }
        }
        int start = 0, end = 0, len = s.length(), min = len+1;
        String result = "";
        int countKey = 0;
        while (start <= end && end < len) {
            while (end < len && countKey < map.size()) {
                if (t.contains(new Character(s.charAt(end)).toString())) {
                    Count count = map.get(s.charAt(end));
                    count.s++;
                    if(count.s == count.t){
                        countKey ++;
                    }
                }
                end++;
            }
            if (countKey == map.size() && end - start < min) {
                min = end - start;
                result = s.substring(start, end);
            }
            while (start <= end && countKey == map.size()) {
                if (end - start < min) {
                    min = end - start;
                    result = s.substring(start, end);
                }
                if (t.contains(new Character(s.charAt(start)).toString())) {
                    Count count = map.get(s.charAt(start));
                    count.s--;
                    if(count.s < count.t){
                        countKey --;
                    }
                }
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babb";
        String t = "baba";
        System.out.println(solution.minWindow(s, t));
    }

}
