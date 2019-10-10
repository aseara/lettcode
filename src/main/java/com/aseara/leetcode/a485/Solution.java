package com.aseara.leetcode.a485;

/**
 * Created by 邱境德 on 2017/4/18.
 * Algorithm 485
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int top = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 0) {
                if (current > top) {
                    top = current;
                }
                current = 0;
            } else {
                current++;
            }
        }
        return current > top ? current : top;
    }

}
