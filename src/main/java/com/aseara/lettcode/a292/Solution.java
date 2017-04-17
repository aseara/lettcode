package com.aseara.lettcode.a292;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 邱境德 on 2017/4/17.
 * Algorithm 292
 */
public class Solution {

    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        if (n == 4) {
            return false;
        }
        Set<Integer> fails = new HashSet<>();
        fails.add(4);
        for (int i = 5; i <= n; i++) {
            if (!fails.contains(i - 1) && !fails.contains(i - 2) && !fails.contains(i - 3)) {
                fails.add(i);
            }
        }
        return !fails.contains(n);
    }

}
