package RangeSumQuery2DImmutable;

public class Solution {
    static class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            if (n == 0) {
                sum = null;
                return;
            }
            int m = matrix[0].length;
            if (m == 0) {
                sum = null;
                return;
            }
            sum = new int[n + 1][m + 1];
            sum[0][0] = matrix[0][0];
            for (int i = 0; i <= n; i++) {
                sum[i][0] = 0;
            }
            for (int j = 0; j <= m; j++) {
                sum[0][j] = 0;
            }
            for (int i = 1; i <= n; i++) {
                sum[i][1] = matrix[i - 1][0] + sum[i - 1][1];
            }
            for (int j = 1; j <= m; j++) {
                sum[1][j] = matrix[0][j - 1] + sum[1][j - 1];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sum == null) {
                return 0;
            } else {
                return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
            }
        }
    }


    public static void main(String[] args) {
        int[][] nums = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(nums);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(0, 1, 4, 3));
        System.out.println(obj.sumRegion(2, 0, 4, 3));
        System.out.println(obj.sumRegion(0, 0, 4, 3));
    }

}
