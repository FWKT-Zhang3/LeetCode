package array._63uniquePaths2;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/7 16:03
 * @Description: A robot is located at the top-left corner of a m x n grid
 *      (marked 'Start' in the diagram below).
 *
 *      The robot can only move either down or right at any point in time.
 *      The robot is trying to reach the bottom-right corner of the grid
 *      (marked 'Finish' in the diagram below).
 *
 *      Now consider if some obstacles are added to the grids. How many
 *      unique paths would there be?
 *
 *      An obstacle and space is marked as 1 and 0 respectively in the grid.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 这个方法太巧妙了
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];

//        int m = obstacleGrid.length, n = obstacleGrid[0].length;
//        if (m == 1 && n == 1) return 1 - obstacleGrid[0][0];
//        if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;
//
//        obstacleGrid[0][0] = 1 - obstacleGrid[0][0];
//
//        for (int i = 1; i < m; i++) {
//            if (obstacleGrid[i][0] == 1 || obstacleGrid[i - 1][0] == 0) {
//                obstacleGrid[i][0] = 0;
//            } else {
//                obstacleGrid[i][0] = -1;
//            }
//        }
//
//        for (int i = 1; i < n; i++) {
//            if (obstacleGrid[0][i] == 1 || obstacleGrid[0][i - 1] == 0) {
//                obstacleGrid[0][i] = 0;
//            } else {
//                obstacleGrid[0][i] = -1;
//            }
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
//                else obstacleGrid[i][j] = obstacleGrid[i - 1][j]
//                        + obstacleGrid[i][j - 1];
//            }
//        }
//        return -obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0},
        };
        Solution s = new Solution();
        System.out.println(s.uniquePathsWithObstacles(a));
    }
}
