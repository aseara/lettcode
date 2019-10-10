package com.aseara.leetcode.a412;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 邱境德 on 2017/4/16.
 * algorithm 412
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0;
            boolean mod5 = i % 5 == 0;

            if (mod3 && mod5) {
                result.add("FizzBuzz");
            } else if (mod3) {
                result.add("Fizz");
            } else if (mod5) {
                result.add("Buzz");
            } else {
                result.add(i + "");
            }

        }
        return result;
    }

}
