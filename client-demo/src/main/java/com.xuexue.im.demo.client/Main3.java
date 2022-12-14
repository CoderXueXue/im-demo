package com.xuexue.im.demo.client;

/**
 * @author huchai
 * @date 2022/12/14
 */
public class Main3 {
    public static void main(String[] args) {
//        int[][] ints = new int[30][2];
//        System.out.println(ints.length);

        Solution solution = new Solution();
        // [[1,2,10],[2,3,20],[2,5,25]]
        //			5
        solution.corpFlightBookings(new int[][]{
                {1, 2, 10}, {2, 3, 20}, {2, 5, 25}
        }, 5);
    }

    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] diff = new int[n + 1];

            for (int[] booking : bookings) {
                int i = booking[0];
                int j = booking[1];
                int num = booking[2];

                diff[i] = diff[i] + num;
                if (j + 1 < n + 1) {
                    diff[j + 1] = diff[j + 1] - num;
                }
            }

            // 返回结果
            int[] result = new int[n];
            for (int i = 1; i < diff.length; i++) {
                result[i - 1] = diff[i] + (i == 1 ? result[i - 1] : result[i - 2]);
            }
            return result;
        }
    }
}
