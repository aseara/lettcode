package com.aseara.leetcode.a561;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by 邱境德 on 2017/4/24.
 * Algorithm 561
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return IntStream.range(0, nums.length / 2)
                .map(i -> nums[i * 2])
                .sum();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = new int[] {1, 4, 3, 2};
        System.out.println(s.arrayPairSum(in));
    }

}
