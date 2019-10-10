package com.aseara.leetcode.a371;

/**
 * Created by 邱境德 on 2017/4/23.
 * Algorithm 371
 */
public class Solution {

    public int getSum(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a;
            a = temp ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(1 + 2);
        System.out.println(s.getSum(1, 2));
        System.out.println(s.getSum(4, 5));
    }

}
