package GuessNumberHigherOrLower;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int guessNumber(int n) {
        return guessNumberFrom(1, n);
    }

    public int guess(int mid){
        return 0;
    }
    private int guessNumberFrom(int start, int end){
        if(start == end){
            return start;
        }
        int mid = (end - start) / 2 + start;
        int result = guess(mid);
        if(result == 0){
            return mid;
        } else if (result > 0){
            return guessNumberFrom(mid+1, end);
        } else {
            return guessNumberFrom(start, mid-1);
        }
    }

}
