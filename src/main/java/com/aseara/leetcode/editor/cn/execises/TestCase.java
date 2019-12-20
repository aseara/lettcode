//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。 
//
// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 
//
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 
//
// 注意，一开始你手头没有任何零钱。 
//
// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。 
//
// 示例 1： 
//
// 输入：[5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
// 
//
// 示例 2： 
//
// 输入：[5,5,10]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[10,10]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[5,5,10,10,20]
//输出：false
//解释：
//前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
//对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
//对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
//由于不是每位顾客都得到了正确的找零，所以答案是 false。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= bills.length <= 10000 
// bills[i] 不是 5 就是 10 或是 20 
// 
// Related Topics 贪心算法
package com.aseara.leetcode.editor.cn.execises;

import com.aseara.leetcode.editor.cn.base.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 860.柠檬水找零 <br />
 * Date: 2019/11/3 <br/>
 *
 * @author qiujingde
 */
class LemonadeChange {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
        assertEquals(5, solution.ladderLength("hit", "cog", dict));
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        dict.remove(beginWord);
        dict.remove(endWord);

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int result = 1;
        while (!beginSet.isEmpty()) {
            result ++;
            Set<String> tempSet = new HashSet<>();
            // 循环beginSet，尝试匹配endSet，成功返回，不成功，把下一层放到tempSet
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != temp) {
                            chars[i] = j;
                            String next = new String(chars);
                            if (endSet.contains(next)) {
                                return result;
                            }
                            if (dict.contains(next)) {
                                tempSet.add(next);
                                dict.remove(next);
                            }
                        }
                    }
                    chars[i] = temp;
                }
            }
            if (endSet.size() <= tempSet.size()) {
                beginSet = endSet;
                endSet = tempSet;
            } else {
                beginSet = tempSet;
            }
        }

        return 0;
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] memo = new int[n + 1];
        memo[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == '0') {
                memo[i] = 0;
            } else if (i < n - 1 && (c == '1' || (c == '2' && chars[i+1] < '7'))) {
                memo[i] = memo[i+1] + memo[i+2];
            } else {
                memo[i] = memo[i+1];
            }
        }
        return memo[0];
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new LinkedList<>();
        int lCnt = (int)Math.log10(low) + 1;
        int hCnt = (int)Math.log10(high) + 1;
        for (int i = lCnt; i <= hCnt ; i++) {
            int b = 1;
            int a = 1;
            for (int j = 2; j <= i; j++) {
                b *= 10;
                b += j;

                a *= 10;
                a += 1;
            }
            for (int j = 0; j <= 9 - i; j++) {
                int num = b + a * j;
                if (num > high) {
                    break;
                }
                if (num >= low) {
                    result.add(num);
                }
            }
        }
        return result;
    }

    public int getDecimalValue(ListNode head) {
        int result = head.val;
        ListNode node = head.next;
        while (node != null) {
            result = result << 1;
            result = result | node.val;
            node = node.next;
        }
        return result;
    }

    public int minFlips(int[][] mat) {
        int num = matToInt(mat);
        if (num == 0) {
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(num);

        Set<Integer> numSet = new HashSet<>();
        numSet.add(num);

        int level = 0;
        int m = mat.length;
        int n = mat[0].length;

        while (!queue.isEmpty()) {
            level ++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int num1 = queue.removeFirst();

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int num2 = flip(num1, m, n, i, j);
                        if (num2 == 0) {
                            return level;
                        }
                        if (!numSet.contains(num2)) {
                            numSet.add(num2);
                            queue.addLast(num2);
                        }
                    }
                }
            }
        }
        return -1;
    }
    private int flip(int num, int m, int n, int i, int j) {
        num = num ^ (1 << (i * n + j));
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int k = i + dir[0];
            int l = j + dir[1];
            if (k >= 0 && k < m && l >= 0 && l < n) {
                num = num ^ (1 << (k * n + l));
            }
        }
        return num;
    }

    private int matToInt(int[][] mat) {
        int result = 0;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = result | (mat[i][j] << (i * n + j));
            }
        }
        return result;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        // 排序
        Arrays.sort(nums);
        int result = 1;

        int bi = 0;
        int n = nums.length;
        int max = 0;

        for (int i = 1; i <= nums[n - 1]; i++) {
            int sum = 0;
            for (int j = bi; j < n; j++) {
                if (i >= nums[j]) {
                    bi ++;
                    threshold --;
                    max --;
                    continue;
                }
                sum += nums[j] / i + (nums[j] % i > 0 ? 1 : 0);
            }
            if (sum == threshold) {
                return i;
            }
            if (sum < threshold && sum > max) {
                max = sum;
                result = i;
            }
        }
        return result;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> sizeMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (size == 1) {
                result.add(Collections.singletonList(i));
                continue;
            }
            List<Integer> list = sizeMap.computeIfAbsent(size, s -> {
                List<Integer> l = new ArrayList<>();
                result.add(l);
                return l;
            });
            list.add(i);
            if (list.size() == size) {
                sizeMap.remove(size);
            }
        }

        return result;
    }

    public int subtractProductAndSum(int n) {
        int j = 1;
        int h = 0;

        while (n > 0) {
            int i = n % 10;
            n = n / 10;

            j *= i;
            h += i;
        }

        return j - h;

    }

    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length < 2) {
            return 0;
        }
        int time = 0;

        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - points[i - 1][0]);
            int y = Math.abs(points[i][1] - points[i - 1][1]);

            time += Math.max(x, y);
        }

        return time;
    }

    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        Set<Integer> sets = new HashSet<>();

        LinkedList<Integer> stack = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    stack.push(i * n + j);
                }
            }
            if (stack.size() > 1) {
                sets.addAll(stack);
            }
            stack.clear();
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++  ) {
                if (grid[i][j] == 1) {
                    stack.push(i * n + j);
                }
            }
            if (stack.size() > 1) {
                sets.addAll(stack);
            }
            stack.clear();
        }

        return sets.size();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String pro : products) {
            trie.insert(pro);
        }

        List<List<String>> result = new LinkedList<>();

        char[] search = searchWord.toCharArray();
        String pre = "";
        for (int i = 0; i < search.length; i++) {
            pre += search[i];

            result.add(trie.getSuggest(pre, 3));
        }

        return result;
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char c : chars) {
                node = node.computeIfAbsent(c);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            TrieNode node = getEndNode(word);
            return node != null && node.isEnd();
        }

        public TrieNode getRoot() {
            return root;
        }

        private TrieNode getEndNode(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length && node != null; i++) {
                node = node.getNode(chars[i]);
            }
            return node;
        }

        private List<String> getSuggest(String pre, int n) {
            TrieNode node = getEndNode(pre);
            List<String> result = new LinkedList<>();

            if (node != null) {
                dfs(node, pre, result, n);
            }

            return result;
        }

        private void dfs(TrieNode node, String pre, List<String> result, int n) {
            if (node == null || result.size() == n) {
                return;
            }
            if (node.isEnd()) {
                for (int i = 0; i < node.end && n > 0; i++) {
                    result.add(pre);
                    n --;
                }
            }
            for (char c = 'a'; c <= 'z' && result.size() < n; c++) {
                TrieNode next = node.getNode(c);
                dfs(next, pre + c, result, n);
            }
        }


        static class TrieNode {
            private TrieNode[] links = new TrieNode[26];

            private int end;

            TrieNode computeIfAbsent(char c) {
                TrieNode node = getNode(c);
                if (node == null) {
                    setNode(c, new TrieNode());
                }
                return getNode(c);
            }

            TrieNode getNode(char c) {
                return links[c - 'a'];
            }

            private void setNode(char c, TrieNode node) {
                links[c - 'a'] = node;
            }

            public boolean isEnd() {
                return end != 0;
            }

            public int getEnd() {
                return end;
            }

            public void setEnd() {
                end ++;
            }
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
