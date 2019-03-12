package forInterview;

public class Solution {
    Integer str2int(String s) {
        if (s == null || "".equals(s)) return null;
        boolean flag=false;
        if(s.charAt(0)=='-'){
            flag=true;
            s=s.substring(1,s.length());
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans *= 10;
            ans += s.charAt(i) - '0';

        }
        return flag?-ans:ans;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int a= solution.str2int("-200");
        System.out.println(a);
    }

}
