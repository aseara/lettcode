package com.aseara.lettcode.a557;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiujingde on 2017/4/15.
 * LettCode解题
 */
public class Solution {

    /**
     * LettCode 557. Reverse Words in a String III
     * @param s input
     * @return output
     */
    public String reverseWords(String s) {
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(s);
        boolean find = matcher.find();
        if (find) {
            StringBuilder sb = new StringBuilder();
            int end = 0;
            do {
                sb.append(s.substring(end, matcher.start()));
                sb.append(new StringBuilder(matcher.group()).reverse());
                end = matcher.end();
                find = matcher.find();
            } while (find);
            sb.append(s.substring(end));
            return sb.toString();
        }
        return s;
    }

}
