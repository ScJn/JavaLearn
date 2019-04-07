package leetcode.dp;

public class WildMatch_44 {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null)return false;
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[plen+1][slen+1];
        for(int i=1;i<plen+1;i++){
            dp[i][0] =false;
        }
        for(int i=1;i<slen+1;i++)dp[0][i] = false;
        dp[0][0]=true;
        if(plen>=1) dp[1][0]= p.charAt(0) == '*';
        for(int i = 1; i<=plen; i++){
            for(int j = 1; j<=slen; j++){
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
                }else dp[i][j]=false;
            }
        }
        return dp[plen][slen];
    }

    public static void main(String[] args) {
        new WildMatch_44().isMatch("","**");
    }
}
