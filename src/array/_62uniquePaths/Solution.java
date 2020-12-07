package array._62uniquePaths;

import java.util.HashMap;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/7 14:44
 * @Description: A robot is located at the top-left corner of a m x n grid
 *      (marked 'Start' in the diagram below).
 *
 *      The robot can only move either down or right at any point in time.
 *      The robot is trying to reach the bottom-right corner of the grid
 *      (marked 'Finish' in the diagram below).
 *
 *      How many possible unique paths are there?
 */
public class Solution {
    /**
     * 自己写的动态规划，但是很慢，空间复杂度也有些高
     *      Runtime: 5 ms, faster than 6.62% of Java online submissions for Unique Paths.
     *      Memory Usage: 38.2 MB, less than 5.47% of Java online submissions for Unique Paths.
     *
     * @param m the row of the matrix
     * @param n the column of the matrix
     * @return the unique Paths of the matrix
     */
    public int uniquePaths(int m, int n) {
        // 自己的写法
//        HashMap<Node, Integer> lib = new HashMap<>();
//        return findWay( m, n, lib);

        // 大佬的写法
        // 明明都想到了用dp，为什么不再多想想？
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            map[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

    /**
     * Auxiliary method of my solution
     *
     * @param m the row of the matrix
     * @param n the column of the matrix
     * @param map the map contains the paths of matrix
     * @return the unique Paths of the matrix
     */
    public int findWay(int m, int n, HashMap<Node, Integer> map) {
        if (m == 1 || n == 1) return 1;
        Node node = new Node(m, n);
        if (map.containsKey(node)) return map.get(node);
        int result = findWay(m - 1, n, map) + findWay(m, n - 1, map);
        map.put(node, result);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3,3));
    }
}

class Node {
    private final int m;
    private final int n;
    public Node(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return (m == node.m && n == node.n)
                || (m == node.n && n == node.m);
    }

    @Override
    public int hashCode() {
        return m+n;
    }
}

