import leetcode.linkedList.ListNode;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

public class test1 {

    public int reverse(int x) {
        long res = 0;
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        while (x > 0) {
            int tail = x % 10;
            x /= 10;
            res = res * 10 + tail;
            if (res > Integer.MAX_VALUE) return 0;
        }
        return flag ? (int) (-res) : (int) res;
    }

    public static void main(String[] args) {

        ArrayList<Integer>a = new ArrayList<>();
        a.add(3);a.add(2);a.add(1);
        a.remove((Integer)2);
    }


}

class Atest {

    public static void main(String[] args) {

//        prefixesDivBy5(new int[]{1, 1, 0, 0, 0, 1, 0, 0, 1});
        test1 t= new test1();
        Object a = new Object();
        java.lang.Object aa =new Object();
        System.out.println(a.getClass().getClassLoader());
        System.out.println(aa.getClass().getClassLoader());
        System.out.println(t.getClass().getClassLoader());
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        int sum = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            sum <<= 1;
            sum += A[i];
            if (sum % 5 == 0) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }

    public static int[] nextLargerNodes(ListNode head) {


        Stack<Integer> data = new Stack<>();
        Stack<Integer> s = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        while (head != null) {
            data.push(head.val);
            head = head.next;
        }

        while (!data.isEmpty()) {
            int curNum = data.pop();
            if (s.isEmpty()) s.push(curNum);
            while (!s.isEmpty() && s.peek() < curNum) {
                s.pop();
            }
            if (!s.isEmpty())
                ans.push(s.peek());
            else ans.push(0);
            s.push(curNum);
        }

        int[] ans2 = new int[ans.size()];
        int index = 0;
        while (!ans.isEmpty()) ans2[index++] = ans.pop();
        return ans2;
    }


    static int re;
    static StringBuilder ans;
    static boolean f;

    public static String baseNeg2(int N) {
        f = true;
        re = N;
        ans = new StringBuilder();
        dfs(N, 1, 1);
        return ans.toString();
    }

    static void dfs(int remain, int mul, int flag) {
        if (!f) return;
        if (remain == 0) {
            f = false;
            return;
        }
        if (Math.abs(mul) > re * 2) return;
        ans.insert(0, 1);
        dfs(remain - mul * flag, mul * 2, -flag);
        if (!f) return;
        ans.delete(0, 1);
        ans.insert(0, 0);
        dfs(remain, mul * 2, -flag);
        if (!f) return;
        ans.delete(0, 1);
    }
}

class test3 {

    public static void main(String[] args) {
        int a=2;
        System.out.println(a);
    }

}
