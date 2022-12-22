package com.xuexue.im.demo.client;

/**
 * @author huchai
 * @date 2022/12/14
 */
public class Main3 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{}, 0));
    }


    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int x = 0;
            int y = matrix.length - 1;

            while (x < matrix[0].length && y >= 0) {
                int curr = matrix[y][x];

                if (curr == target) {
                    return true;
                }
                if (curr > target) {
                    y--;
                }
                if (curr < target) {
                    x++;
                }

            }
            return false;
        }
    }

}
