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

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        String[] words = {"eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojt","mervtkzsouapfbky","eucgsmpsyndddijvpxfagngnjbzxuajxnzjk","eduvadjohhskmyzipulgjeat","eucgsnatcadpbcyrxlgldpcaijmnojdkjqfwxkz","eucgsmpsynevhpeoqwbgdidv","yvu","eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske","eixctybvrnuyqibnpxpbcpcqcq","eucgsmpsyndddijvpxfagngnjrcnbbwae","lrvlimn","eucgsmpsyndddijvpxfagngnjbzgsidschcqhm","thhnadanjkbrcnofgpdfthvcodrmrezulkuytrqosqaooecqom","eucgsmpsyndddijvpxfagngwcpixbrkupusfqoyihroghoae","eucgsmpsyndddijvpxmmydswjxsdmer","fhfhindvjohibmsoipvdyedlxoinlumjlb","lsuinsmrgxxhswxshvogzxojsbvhzbcioldypag","ptbyxfktngjsofvicpvsmyqddacyahf","yjhiemwpwfpyewvcfbtljsrwlfiihwisqekfoearodlvhoejq","atoygkvdbdvmuukgfjnufsnhjcsaxk","eucgsdwqeaslgrthiruatrpulqyjgmsbdljebf","eucgsmpsyndddijvpxpcyrilzawoid","eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo","faoywdrvlgacdcfj","eucgsmpsynddwdgwnssfvds","eucgsmpsyndqgjneynofkuebob","asafyzzpxlltqyscywuahwinwijuccwnd","eucgsmpsyndddiznbxfvpqei","eucgsmpsyndddijvpximqtdtlybvziqhdvowuijbkurk","hvxmdjutynhrxyubizbyjwwxfpvblzxvfrca","eucgsu","jhckeuhdvbfdzmyjbjcfariwejezwhtzojeyhxjwegqgrl","eucgsmpsyndddijvpxfagngnjsjjbob","eucgsmpsyndddijvpxfdtbeujjoeqvezdjmopfcmzohuantaid","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszloha","eucgsmpsyndddijvpxfagngnjbzxuajlkwhlwhuwmyagdvymu","jdskdhwkehgqazzweqyzmqzsikjnwgylnhgugjixyrpmyrs","eucgsmpsdney","sasmjvaqjrrovkxqccfpqyruscxgzkbeekz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjjofldab","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdros","ekszgjqykwcwatzrzykatpxcasaifohwrrhipm","shfcpdjhktwfcqezsabkzyzyuibxpzxggnxgcwflloucbgodpm","tpcxhiehypiqtaxzdjxhofufucblqvkoqhlgxgozolaelf","swtrepxomxqemgodrupgigvpxxgptmilfkmzhfnr","dcvzdk","eucgsmpsyndddijvpxfagngnjbzxuajxmrmssckqdpjjasnms","nknhhv","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwjyi","qrsqrmqtpajtewxiegcevy","eucgsmpsyndddijvpxfagnfqcq","eucgsmpsyndddijvpxfagngnjbzxuajxmicjxmxhnrxbbczh","eucgshcaieewetzvzwigqfrlwpy","ogubeczu","eucgsmpsyndddijvpxfagngnjbzxuavqyzgaeyi","eucgsmpsyndddijvpxfagngnjbzxuajxmonbleriwyuvlnsfzt","jhz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje","xasvjrkqyxory","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsehufy","eucgsmpsyndntjxkzpjstoke","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszhwsbfrppvadx","eucgsmrczev","eucgsmpsyndddijvpxfagngnjbzxuafelaasrnq","eucgsmpsyndddijvpxohsjopdnlnlhksjadjvuvroybu","gnntehraxahinoyqdrspmjaunucrzw","roqdenkakwsbkcbkijyrpfdehrfj","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgusf","eucgsmpsyndddijvpxfagngnjbjkffxzscalu","eugyortzihuywhfyrwubdfuomvcjudxtappednlohmxz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswq","eucjqsqvatpjbfvhowkaagxyidiyymapdumaxgoqgbpwsu","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrk","es","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdwv","kbninamhdqpoyzznnsqxzmieqajsqrjocrqbmfhwomstdc","jbwggbwtybranddatuybnzre","ludoupnbvsxksvmtaxuuiymidzotziwbqaclvvk","eucgsmpsyndddijvpxfagngnsgpnllzgpyirgem","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtebvruvqmpx","nwbqryotfdaopywffjbikuqzraabwngcicsufkeerbpnfyi","eucgsmpsyndddijvoaevblhxotmowpxwpuhzmemw","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgu","eucgsmpsyndddijvpcfjbzthtculbzszzfaroncw","grygljuxydgpoygjoemajbkaqmbwyverlruejnigqdsvdpwm","eucgsmpsyomtefhlwqluqgcckz","eucijltqylixpvjwtlhurqdseysduhivw","eucgsmpsyndddijvpxfagngnjbzxuajxmrbcm","zibchozkzyhdsmfcryjyzkzgyohjs","yiuxtmtzrnnitnpzyfgfctnlednanfwtjplvueab","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwslgknojn","eucgsmpsyndddijvpxfagngnjbxzehobuljrngufbcks","bwbbmbvwzegxmqhdmufnvwpwtykmdvwngqtdwym","eucgsmpsyndddijvpxfagnoezpyieslubwxeobrnktvnpinamb","eucgsmpslmkdakhg","eucgsmczlqunsmfbrodtrtevmuflaf","rpofbqaryrhmqzqkzrmhhsmtgfecva","pmvfbplrjqcmxlpypswxgqemjpxmwmswesrhwmicumoilapzhy","eucgsmpsyndddezzokejvhvdmsoaaoowwottmw","rmvmikeynztayityavakrt","tdeypjrxduem","fqvsmpnzkzuubhuwchdqy","eucgsmpsyoesekvyqvtmymaplhzynaupevoihscjkrjtcj","eucgsmpsyndddijvpxfagngnjbzxjh","jghjdzajfpvyesz","eucgsmpsyndddijvpxfagngnjbzxlmymsyqvaojj","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwdetn","eunahmcfpnnjavmduowjntsgo","eucgsmpsyndddijvpxfagngnjbzqinqttopi","ubgzjxnomgcnrbbhyppemgyejbycpgamympgupaetudz","mtuindengcxqg","eucgdxsvzyxpbwtnqmzundoosvddromqhydyyjich","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgkqoyw","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrog","eucgsmpsyndddijvpxfagnpcl","eucgsmpsyndddijvpxfagngnjbzjegcxjcrslyvgbd","nhb","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsudaj","vnyfkvdguu","eucshaijqdl","eucgsmpsyndddijvpxfagngnjbzxuyxowpbndxvxayzxfp","fvgk","eucgsmpslzukdhnbtmsycj","wvpelpocfsodafurhbgbytnta","eucgsmpsyndddijvpxfagngnjbzzetehbbepo","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdayg","eucgsmpsyndddijvpxfagngnjbzxuajxjtkkz","knhrz","eucgsmpsyndddijvpxfagngnjbzxuyretdzgzkqaep","eucgsmpsyndddijvpxfagngnjbzxuajxmgi","eucgdjnclcqogrzxi","clliyxtdxzwwz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvvev","sugaphcopoyjzoxdpznrkrgjzcfdddvcktwxukcnan","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojp","vwavfxqerifzseyfefbchueoadvcoximlvowsndrwxspqsn","ejafexrgcikuqefkvlfe","eucgsmpsyndddijvpxfaiuejxgpzbirbus","eucgsmpsyndddijvpxfagngnjbzzdo","bgtdtziavmvfbkexrmqzojkdrapfbljxghlesmflzvgxrooc","eucgsmpsyndddijvpxfagludvrubjhfhn","jsposqsidurgsqjwkabv","eucgsmpsyndddijvpxfagnplbcjevfnfaezqcijiixrrcd","wdhaxpoe","nkj","eucgsmpsyndddijvpxfagngnjbzxuajxmweazgncksq","eucgsmpsyndddijvpxfagnyxks","bouogc","eucgabxhtbnohgmunhrospjzqozczhowc","udcilqgipfjswuscpxtbgqancfolgqbvfvrzsy","eucgsmpsyndddijvpcdswmsvlekrtarkybjwovevieve","zkwfbyawpokgpnzzikaybfosdbqjmkdthsyoojb","gabgl","bkyxlqjgdsuhzbpvtnaobudwsrjqvceliadetviiar","eucgsmpsyndddijvpxfagngnjbzxuajxqqdlwpeyxgtuvbfqj","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswwvy","ryxcr","eucgsmpsyndddijvpxfagngnjbzvrkbgrrtcpbqvlktqwwxxn","eucgsmpsyndddijfagrxzrdg","eucgsmhsnicnajhcaca","revsyodsujynljmd","fficqqokrlkfwsbosapqvaurdk","eucgudniqtxzmtschgm","eucgsmpsyncxbvicmuafacp","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgjrp","qvjbtmibwikrugaeihweuumhajcffcurgn","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdcum","jolquz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjyfpyyv","eucgsmpsyndddijvpxfagngnjbzxubimdvzlcpv","mesisdbvntasidlsnpbyrv","aekcjkuqrjfujvztrpiksbkegngbilgshwdgmfxz","fcmragokrxletuojnwflovikmovutvdzomlwyidpbzu","eucgsmpsynyozqjvjgnqtgxktlorcaij","eucgsqszvinjizxxvhypkfcigp","pxrai","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdnzxa","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvnannjxw","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrodu","kycywphmwwyeag","truu","eucgsmpsynajtisffvgqgafmdojgethmlygcekgrysvy","eucgsmpsyndddijvpxfagngnjbzxuajolf","eucgsmpsyndddijvvdpeqcwgnveozoyehjsul","eucgsmpsyndddijvsnsgoumnhjvhklzazpoqgfayum","dgnqyhduqwjunvwqkteoquyxmhi","ourbrwsthwtrfzgakvzxppbihjpsogitmoswlxalzlggzxtay","eucgsmpsyndddibedezerylnt","eucgsmpsyndddijvpxvzbiv","eucgsmpsynwdxxmogfmvuql","eucgsmpsywmnftesxvxklkezbkqbiitesnrjebsspij","eucgsbvboupistecce","iimgotnjnpwsmgqekkdtzfozjdv","eucgsmpsyndddijvpxfaxegyotcospqgyxenjferjjunmzsidt","eucgsmpsyndddijvpxfagngnjbzxuajxmvbnjxougpcblekprx","csdpcsaacavnznbqwiqlcsjzrdl","eucgsmpplakpuykrqty","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje"};
        System.out.println(solution.suggestedProducts(words, "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojjseclfhpnsjtqdqfhapmkmfqmzaunfhvkcbeqhowuuerztwldxaegwkghzthoauesdmbshzxlnpagcnyyicmtbhoqrkopemdacrkhdsxoosfhoaokqspqndtieukzjbkqixinrtqrzblufhucpzomvpmcvzfuebjfkywangcqutpzrwkwolpxuqfyjdwwrnhvnzkorsiklgqmwijynmrfezlpmdkkhafyxumiyqxhxbmxzmmcmxkajvwohhjqfuqlvknrqbjsnoimxwzbhlbddbzlwqbjpgwvjgvhgubmabuomjdmqouarvjuqzyvmsnmjaqzdmtwhaelglbt"));
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
