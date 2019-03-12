package leetcode.dp;

public class RegularMatch_10 {


    public boolean isMatch(String s, String p) {

        int[][] dp=new int[s.length()+1][p.length()+1];




        return dp[s.length()][p.length()] == 1;

    }
}
