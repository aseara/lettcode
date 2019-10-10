package com.aseara.leetcode.a557;


import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by qiujingde on 2017/4/15.
 * LettCode解题测试
 */
public class SolutionTest {

    /**
     * 解决方案。
     */
    private static Solution solution;

    @BeforeClass
    public static void beforeClass() {
        solution = new Solution();
    }

    @Test
    public void reverseWords() {
        String input = "Let's take LeetCode contest";
        String output = "s'teL ekat edoCteeL tsetnoc";

        assertEquals(output, solution.reverseWords(input));

        input = "a b d ee$#% aef$ea eaef eaj ae##ea'fe";
        output = "a b d %#$ee ae$fea feae jae ef'ae##ea";
        assertEquals(output, solution.reverseWords(input));
    }

}