package com.aseara.leetcode.a389;

/**
 * Created by 邱境德 on 2017/4/23.
 * Algorithm 389
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += t.charAt(i);
            result -= s.charAt(i);
        }
        result += t.charAt(t.length() - 1);
        return (char)result;
    }

}
