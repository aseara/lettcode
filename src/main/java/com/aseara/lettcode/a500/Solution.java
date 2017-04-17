package com.aseara.lettcode.a500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by qiujingde on 2017/4/16.
 *
 */
public class Solution {

    private static Map<Character, Integer> letterMap = new HashMap<>();
    private static List<Set<Character>> letterSetList = new ArrayList<>();

    static {
        cacheLine("qwertyuiop");
        cacheLine("asdfghjkl");
        cacheLine("zxcvbnm");
    }

    private static void cacheLine(String line) {
        Set<Character> lineSet = new TreeSet<>();
        letterSetList.add(lineSet);
        int setIndex = letterSetList.size() - 1;
        for (char c : line.toCharArray()) {
            lineSet.add(c);
            letterMap.put(c, setIndex);
        }
    }


    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        out:
        for (String rawWord : words) {
            String word = rawWord.toLowerCase();
            Set<Character> lineSet = letterSetList.get(letterMap.get(word.charAt(0)));
            for (int i = 1; i < word.length(); i++) {
                if (!lineSet.contains(word.charAt(i))) {
                    continue out;
                }
            }
            result.add(rawWord);
        }
        return result.toArray(new String[result.size()]);
    }

}
