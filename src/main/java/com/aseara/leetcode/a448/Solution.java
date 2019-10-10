package com.aseara.leetcode.a448;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 邱境德 on 2017/4/23.
 * Algorithm 448
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;

    }

}
