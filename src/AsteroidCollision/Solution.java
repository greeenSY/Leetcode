package AsteroidCollision;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids){
                if(stack.isEmpty()){
                    stack .push(i);
                } else {
                    int top = stack.pop();
                    if(top > 0 && i < 0){
                        while (top > 0 && top + i < 0 && !stack.isEmpty()){
                            top = stack.pop();
                        }

                        if(top < 0 ){
                            stack.push(top);
                            stack.push(i);
                        } else if(top + i < 0){
                            stack.push(i);
                        } else if(top + i > 0){
                            stack.push(top);
                        }
                    } else {
                        stack.push(top);
                        stack.push(i);
                    }
                }
        }
        int[] result = new int[stack.size()];
        for(int i=result.length-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {-2,-2,1,-2};
        System.out.println(Arrays.toString(solution.asteroidCollision(array)));
    }

}
