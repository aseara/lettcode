package com.aseara.lettcode.a575;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qiujingde on 2017/5/13.
 * Algorithm 575
 */
public class Solution {

    public int distributeCandies(int[] candies) {
        int halfSize = candies.length / 2;
        Set<Integer> allKindSet = new HashSet<>();
        for (int kind : candies) {
            allKindSet.add(kind);
        }

        return Math.min(halfSize, allKindSet.size());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println(s.distributeCandies(new int[]{1,1,2,3}));
    }

}
