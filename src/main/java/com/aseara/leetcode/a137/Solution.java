package com.aseara.leetcode.a137;

/**
 * Created by 邱境德 on 2017/4/24.
 * Algorithm 137
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int t = (a ^ num) | (a & ~b & num);
            b = (b & ~num) | (a ^ b) & num;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 2, 2, 4};
        System.out.println(s.singleNumber(nums));
    }

}
