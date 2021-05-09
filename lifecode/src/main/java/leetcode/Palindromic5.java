package leetcode;

public class Palindromic5 {

    // first version
    public String longestPalindrome(String s) {
        final int len = s.length();
        String res = "";
        int[][] judge = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int ti = i, tj = j;
                if (s.charAt(i) == s.charAt(j)) {
                    while (ti < tj) {
                        if (judge[ti][tj] == 1) {
                            judge[i][j] = 1;
                            break;
                        }
                        if (s.charAt(ti) != s.charAt(tj)) break;
                        ti++;
                        tj--;
                    }
                    if (ti >= tj) judge[i][j] = 1;
                    if (judge[i][j] == 1) res = j - i + 1 > res.length() ? s.substring(i, j + 1) : res;
                }

            }
        }
        return res;
    }

    /**
     * regard i as the center, let i from 0 to len-1
     * 然后向外扩张，
     *
     * @param s string
     * @return longestPalindrome2
     */
    public String longestPalindrome2(String s) {
        final int len = s.length();
        String res="";
        if (len <= 1) return s;
        for (int i = 0; i < len;) {
//            if(res.length()>(i+1)*2&&res.length()>(len-i)*2)return res;
            int left = i, right = i;
            while (right < len - 1 && s.charAt(right) == s.charAt(right + 1)) right++;//属于对称无中心的情况。
            i = right + 1;//left 到 right都不可能是下一个中心
            while (0 < left && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            res=res.length()<right-left+1?s.substring(left,right+1):res;
        }

        return res;
    }

    public static void main(String[] args) {
        String ss = new Palindromic5().longestPalindrome2("abbasdfna");
        System.out.println(ss);
    }
}
