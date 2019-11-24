//给你一个产品数组 products 和一个字符串 searchWord ，products 数组中每个产品都是一个字符串。 
//
// 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。 
//
// 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。 
//
// 
//
// 示例 1： 
//
// 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
//输出：[
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
//输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
//输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
// 
//
// 示例 2： 
//
// 输入：products = ["havana"], searchWord = "havana"
//输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// 
//
// 示例 3： 
//
// 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
//输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
// 
//
// 示例 4： 
//
// 输入：products = ["havana"], searchWord = "tatiana"
//输出：[[],[],[],[],[],[],[]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= products.length <= 1000 
// 1 <= Σ products[i].length <= 2 * 10^4 
// products[i] 中所有的字符都是小写英文字母。 
// 1 <= searchWord.length <= 1000 
// searchWord 中所有字符都是小写英文字母。 
// 
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a5273;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * desc: 5273.搜索推荐系统 <br />
 * Date: 2019/11/24 <br/>
 *
 * @author qiujingde
 */
class SearchSuggestionsSystem {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        String[] words = {"eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojt","mervtkzsouapfbky","eucgsmpsyndddijvpxfagngnjbzxuajxnzjk","eduvadjohhskmyzipulgjeat","eucgsnatcadpbcyrxlgldpcaijmnojdkjqfwxkz","eucgsmpsynevhpeoqwbgdidv","yvu","eucgsmpsyndddijvpxfagnbjthdmywjcmbmgpfrvwhdarjske","eixctybvrnuyqibnpxpbcpcqcq","eucgsmpsyndddijvpxfagngnjrcnbbwae","lrvlimn","eucgsmpsyndddijvpxfagngnjbzgsidschcqhm","thhnadanjkbrcnofgpdfthvcodrmrezulkuytrqosqaooecqom","eucgsmpsyndddijvpxfagngwcpixbrkupusfqoyihroghoae","eucgsmpsyndddijvpxmmydswjxsdmer","fhfhindvjohibmsoipvdyedlxoinlumjlb","lsuinsmrgxxhswxshvogzxojsbvhzbcioldypag","ptbyxfktngjsofvicpvsmyqddacyahf","yjhiemwpwfpyewvcfbtljsrwlfiihwisqekfoearodlvhoejq","atoygkvdbdvmuukgfjnufsnhjcsaxk","eucgsdwqeaslgrthiruatrpulqyjgmsbdljebf","eucgsmpsyndddijvpxpcyrilzawoid","eucgsmpsyndddijvpxfagngnjbhvxvjmecfdqzpokhzpqdo","faoywdrvlgacdcfj","eucgsmpsynddwdgwnssfvds","eucgsmpsyndqgjneynofkuebob","asafyzzpxlltqyscywuahwinwijuccwnd","eucgsmpsyndddiznbxfvpqei","eucgsmpsyndddijvpximqtdtlybvziqhdvowuijbkurk","hvxmdjutynhrxyubizbyjwwxfpvblzxvfrca","eucgsu","jhckeuhdvbfdzmyjbjcfariwejezwhtzojeyhxjwegqgrl","eucgsmpsyndddijvpxfagngnjsjjbob","eucgsmpsyndddijvpxfdtbeujjoeqvezdjmopfcmzohuantaid","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszloha","eucgsmpsyndddijvpxfagngnjbzxuajlkwhlwhuwmyagdvymu","jdskdhwkehgqazzweqyzmqzsikjnwgylnhgugjixyrpmyrs","eucgsmpsdney","sasmjvaqjrrovkxqccfpqyruscxgzkbeekz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjjofldab","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdros","ekszgjqykwcwatzrzykatpxcasaifohwrrhipm","shfcpdjhktwfcqezsabkzyzyuibxpzxggnxgcwflloucbgodpm","tpcxhiehypiqtaxzdjxhofufucblqvkoqhlgxgozolaelf","swtrepxomxqemgodrupgigvpxxgptmilfkmzhfnr","dcvzdk","eucgsmpsyndddijvpxfagngnjbzxuajxmrmssckqdpjjasnms","nknhhv","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwjyi","qrsqrmqtpajtewxiegcevy","eucgsmpsyndddijvpxfagnfqcq","eucgsmpsyndddijvpxfagngnjbzxuajxmicjxmxhnrxbbczh","eucgshcaieewetzvzwigqfrlwpy","ogubeczu","eucgsmpsyndddijvpxfagngnjbzxuavqyzgaeyi","eucgsmpsyndddijvpxfagngnjbzxuajxmonbleriwyuvlnsfzt","jhz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje","xasvjrkqyxory","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsehufy","eucgsmpsyndntjxkzpjstoke","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszhwsbfrppvadx","eucgsmrczev","eucgsmpsyndddijvpxfagngnjbzxuafelaasrnq","eucgsmpsyndddijvpxohsjopdnlnlhksjadjvuvroybu","gnntehraxahinoyqdrspmjaunucrzw","roqdenkakwsbkcbkijyrpfdehrfj","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgusf","eucgsmpsyndddijvpxfagngnjbjkffxzscalu","eugyortzihuywhfyrwubdfuomvcjudxtappednlohmxz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswq","eucjqsqvatpjbfvhowkaagxyidiyymapdumaxgoqgbpwsu","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrk","es","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdwv","kbninamhdqpoyzznnsqxzmieqajsqrjocrqbmfhwomstdc","jbwggbwtybranddatuybnzre","ludoupnbvsxksvmtaxuuiymidzotziwbqaclvvk","eucgsmpsyndddijvpxfagngnsgpnllzgpyirgem","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtebvruvqmpx","nwbqryotfdaopywffjbikuqzraabwngcicsufkeerbpnfyi","eucgsmpsyndddijvoaevblhxotmowpxwpuhzmemw","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgu","eucgsmpsyndddijvpcfjbzthtculbzszzfaroncw","grygljuxydgpoygjoemajbkaqmbwyverlruejnigqdsvdpwm","eucgsmpsyomtefhlwqluqgcckz","eucijltqylixpvjwtlhurqdseysduhivw","eucgsmpsyndddijvpxfagngnjbzxuajxmrbcm","zibchozkzyhdsmfcryjyzkzgyohjs","yiuxtmtzrnnitnpzyfgfctnlednanfwtjplvueab","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwslgknojn","eucgsmpsyndddijvpxfagngnjbxzehobuljrngufbcks","bwbbmbvwzegxmqhdmufnvwpwtykmdvwngqtdwym","eucgsmpsyndddijvpxfagnoezpyieslubwxeobrnktvnpinamb","eucgsmpslmkdakhg","eucgsmczlqunsmfbrodtrtevmuflaf","rpofbqaryrhmqzqkzrmhhsmtgfecva","pmvfbplrjqcmxlpypswxgqemjpxmwmswesrhwmicumoilapzhy","eucgsmpsyndddezzokejvhvdmsoaaoowwottmw","rmvmikeynztayityavakrt","tdeypjrxduem","fqvsmpnzkzuubhuwchdqy","eucgsmpsyoesekvyqvtmymaplhzynaupevoihscjkrjtcj","eucgsmpsyndddijvpxfagngnjbzxjh","jghjdzajfpvyesz","eucgsmpsyndddijvpxfagngnjbzxlmymsyqvaojj","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwdetn","eunahmcfpnnjavmduowjntsgo","eucgsmpsyndddijvpxfagngnjbzqinqttopi","ubgzjxnomgcnrbbhyppemgyejbycpgamympgupaetudz","mtuindengcxqg","eucgdxsvzyxpbwtnqmzundoosvddromqhydyyjich","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgkqoyw","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrog","eucgsmpsyndddijvpxfagnpcl","eucgsmpsyndddijvpxfagngnjbzjegcxjcrslyvgbd","nhb","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwsudaj","vnyfkvdguu","eucshaijqdl","eucgsmpsyndddijvpxfagngnjbzxuyxowpbndxvxayzxfp","fvgk","eucgsmpslzukdhnbtmsycj","wvpelpocfsodafurhbgbytnta","eucgsmpsyndddijvpxfagngnjbzzetehbbepo","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdayg","eucgsmpsyndddijvpxfagngnjbzxuajxjtkkz","knhrz","eucgsmpsyndddijvpxfagngnjbzxuyretdzgzkqaep","eucgsmpsyndddijvpxfagngnjbzxuajxmgi","eucgdjnclcqogrzxi","clliyxtdxzwwz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvvev","sugaphcopoyjzoxdpznrkrgjzcfdddvcktwxukcnan","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojp","vwavfxqerifzseyfefbchueoadvcoximlvowsndrwxspqsn","ejafexrgcikuqefkvlfe","eucgsmpsyndddijvpxfaiuejxgpzbirbus","eucgsmpsyndddijvpxfagngnjbzzdo","bgtdtziavmvfbkexrmqzojkdrapfbljxghlesmflzvgxrooc","eucgsmpsyndddijvpxfagludvrubjhfhn","jsposqsidurgsqjwkabv","eucgsmpsyndddijvpxfagnplbcjevfnfaezqcijiixrrcd","wdhaxpoe","nkj","eucgsmpsyndddijvpxfagngnjbzxuajxmweazgncksq","eucgsmpsyndddijvpxfagnyxks","bouogc","eucgabxhtbnohgmunhrospjzqozczhowc","udcilqgipfjswuscpxtbgqancfolgqbvfvrzsy","eucgsmpsyndddijvpcdswmsvlekrtarkybjwovevieve","zkwfbyawpokgpnzzikaybfosdbqjmkdthsyoojb","gabgl","bkyxlqjgdsuhzbpvtnaobudwsrjqvceliadetviiar","eucgsmpsyndddijvpxfagngnjbzxuajxqqdlwpeyxgtuvbfqj","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswwvy","ryxcr","eucgsmpsyndddijvpxfagngnjbzvrkbgrrtcpbqvlktqwwxxn","eucgsmpsyndddijfagrxzrdg","eucgsmhsnicnajhcaca","revsyodsujynljmd","fficqqokrlkfwsbosapqvaurdk","eucgudniqtxzmtschgm","eucgsmpsyncxbvicmuafacp","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgjrp","qvjbtmibwikrugaeihweuumhajcffcurgn","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdcum","jolquz","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjyfpyyv","eucgsmpsyndddijvpxfagngnjbzxubimdvzlcpv","mesisdbvntasidlsnpbyrv","aekcjkuqrjfujvztrpiksbkegngbilgshwdgmfxz","fcmragokrxletuojnwflovikmovutvdzomlwyidpbzu","eucgsmpsynyozqjvjgnqtgxktlorcaij","eucgsqszvinjizxxvhypkfcigp","pxrai","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdnzxa","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvnannjxw","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrodu","kycywphmwwyeag","truu","eucgsmpsynajtisffvgqgafmdojgethmlygcekgrysvy","eucgsmpsyndddijvpxfagngnjbzxuajolf","eucgsmpsyndddijvvdpeqcwgnveozoyehjsul","eucgsmpsyndddijvsnsgoumnhjvhklzazpoqgfayum","dgnqyhduqwjunvwqkteoquyxmhi","ourbrwsthwtrfzgakvzxppbihjpsogitmoswlxalzlggzxtay","eucgsmpsyndddibedezerylnt","eucgsmpsyndddijvpxvzbiv","eucgsmpsynwdxxmogfmvuql","eucgsmpsywmnftesxvxklkezbkqbiitesnrjebsspij","eucgsbvboupistecce","iimgotnjnpwsmgqekkdtzfozjdv","eucgsmpsyndddijvpxfaxegyotcospqgyxenjferjjunmzsidt","eucgsmpsyndddijvpxfagngnjbzxuajxmvbnjxougpcblekprx","csdpcsaacavnznbqwiqlcsjzrdl","eucgsmpplakpuykrqty","eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdroje"};
        System.out.println(solution.suggestedProducts(words, "eucgsmpsyndddijvpxfagngnjbzxuajxmrmszwtjvwswgdrojjseclfhpnsjtqdqfhapmkmfqmzaunfhvkcbeqhowuuerztwldxaegwkghzthoauesdmbshzxlnpagcnyyicmtbhoqrkopemdacrkhdsxoosfhoaokqspqndtieukzjbkqixinrtqrzblufhucpzomvpmcvzfuebjfkywangcqutpzrwkwolpxuqfyjdwwrnhvnzkorsiklgqmwijynmrfezlpmdkkhafyxumiyqxhxbmxzmmcmxkajvwohhjqfuqlvknrqbjsnoimxwzbhlbddbzlwqbjpgwvjgvhgubmabuomjdmqouarvjuqzyvmsnmjaqzdmtwhaelglbt"));
    }
    
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product: products) {
            trie.insert(product);
        }
        return trie.suggest(searchWord, 3);
    }
}

class Trie {

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.link(c);
        }
        node.setEnd();
    }

    List<List<String>> suggest(String word, int n) {
        List<List<String>> result = new LinkedList<>();

        TrieNode node = root;
        String pre = "";
        for (char c : word.toCharArray()) {
            pre += c;
            node = node == null ? null : node.getNode(c);
            result.add(suggest(node, pre, n));
        }

        return result;
    }

    private List<String> suggest(TrieNode node, String pre, int n) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<String> result = new LinkedList<>();
        dfs(node, pre, result, n);
        return result;
    }

    private void dfs (TrieNode node, String pre, List<String> store, int n) {
        if (store.size() == n || node == null) {
            return;
        }

        for (int i = 0; i < node.wordCnt && store.size() < n; i++) {
            store.add(pre);
        }

        for (char i = 'a'; i <= 'z' && store.size() < n; i++) {
            dfs(node.getNode(i), pre + i, store, n);
        }
    }

    private TrieNode startWith(String pre) {
        if (pre == null || pre.length() == 0) {
            return null;
        }
        TrieNode node = root;
        char[] chars = pre.toCharArray();
        for (int i = 0; i < chars.length && node != null; i++) {
            node = node.getNode(chars[i]);
        }
        return node;
    }

    static class TrieNode {
        TrieNode[] links = new TrieNode[26];

        int wordCnt;

        TrieNode getNode(char a) {
            return links[a - 'a'];
        }

        TrieNode link(char c) {
            int index = c - 'a';
            if (links[index] == null) {
                links[index] = new TrieNode();
            }
            return links[index];
        }

        void setEnd() {
            wordCnt ++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
