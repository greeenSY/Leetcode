package FriendCircles;

public class Solution {

    public int findCircleNum(int[][] M) {

        int n = M.length;
        int num = 0;
        int[] read = new int[n];
        for (int i = 0; i < n; i++) {
            if (read[i] == 0){
                readAll(i, read, M);
                num ++;
            }
        }
        return num;
    }

    private void readAll(int num, int[] read, int[][] M) {
        int n = M.length;
        read[num] = 1;
        for (int i = 0; i < n; i++) {
            if (M[num][i] == 1 && read[i] == 0) {
                readAll(i, read, M);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        int[][] N = {{1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        Solution s = new Solution();
        System.out.println(s.findCircleNum(M));
        System.out.println(s.findCircleNum(N));
    }

}
