package array._48rotateImage;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/2 14:40
 * @Description: You are given an n x n 2D matrix representing an image, rotate
 *      the image by 90 degrees (clockwise).
 *
 *      You have to rotate the image in-place, which means you have to modify
 *      the input 2D matrix directly. DO NOT allocate another 2D matrix and do
 *      the rotation.
 */
public class Solution {
    /**
     *##########################
     * clockwise rotate        #
     *##########################
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     *  void rotate(vector<vector<int>> &matrix) {
     *      reverse(matrix.begin(), matrix.end());
     *      for (int i = 0; i < matrix.size(); ++i) {
     *          for (int j = i + 1; j < matrix[i].size(); ++j)
     *              swap(matrix[i][j], matrix[j][i]);
     *          }
     *  }
     *
     *##########################
     * anticlockwise rotate    #
     *##########################
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     *
     *
     *  void anti_rotate(vector<vector<int>> &matrix) {
     *      for (auto vi : matrix) reverse(vi.begin(), vi.end());
     *      for (int i = 0; i < matrix.size(); ++i) {
     *          for (int j = i + 1; j < matrix[i].size(); ++j)
     *              swap(matrix[i][j], matrix[j][i]);
     *      }
     *  }
     *
     * @param matrix the matrix to rotate
     */
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        if (matrix.length == 1) return;
        reverse(matrix);
        symmetry(matrix);

//        // Another idea
//        // explain: https://leetcode.com/problems/rotate-image/discuss/18895/Clear-Java-solution
//        int n=matrix.length;
//        for (int i=0; i<n/2; i++) {
//            for (int j=i; j<n-i-1; j++) {
//                int tmp=matrix[i][j];
//                matrix[i][j]=matrix[n-j-1][i];
//                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
//                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
//                matrix[j][n-i-1]=tmp;
//            }
//        }
    }

    public void reverse(int[][] matrix) {
        int[] temp;
        int h = 0, t = matrix.length-1;
        while (h < t) {
            temp = matrix[h];
            matrix[h] = matrix[t];
            matrix[t] = temp;
            h++;
            t--;
        }
    }

    public void symmetry(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
