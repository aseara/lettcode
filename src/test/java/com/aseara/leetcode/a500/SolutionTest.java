package com.aseara.leetcode.a500;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by qiujingde on 2017/4/16.
 *
 */
public class SolutionTest {
    @Test
    public void findWords() throws Exception {

        String[] input = new String[] {"Hello", "Alaska", "Dad", "Peace"};
        String[] output = new String[] {"Alaska", "Dad"};

        Solution solution = new Solution();

        assertEquals(output, solution.findWords(input));

    }

}