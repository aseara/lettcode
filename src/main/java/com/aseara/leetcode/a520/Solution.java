package com.aseara.leetcode.a520;

/**
 * Created by qiujingde on 2017/4/19.
 * Algorithm 520
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]*");
    }

}
