package com.aseara.leetcode.editor.cn.a496;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邱境德 on 2017/4/17.
 * Algorithm 496
 */
public class Solution {


    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> indexMap = new HashMap<>();
        int scanIndex = 0;
        out:
        for (int findNum : findNums) {
            int index = indexMap.getOrDefault(findNum, -1);
            if (index == -1) {
                for (int j = scanIndex; j < nums.length; j++) {
                    indexMap.put(nums[j], j);
                    if (nums[j] == findNum) {
                        index = j;
                        scanIndex = j;
                        break;
                    }
                }
            }
            for (int j = index + 1; j < nums.length; j++) {
                if (j > scanIndex) {
                    indexMap.put(nums[j], j);
                    scanIndex = j;
                }
                if (nums[j] > findNum) {
                    result.add(nums[j]);
                    continue out;
                }
            }
            result.add(-1);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
