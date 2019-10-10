package com.aseara.leetcode.a136;

/**
 * Created by qiujingde on 2017/4/19.
 * Algorithm 136
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
