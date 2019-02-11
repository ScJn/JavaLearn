package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        internal("", n, n);
        return list;
    }

    public void internal(String s, int remainLeft, int remainRight) {
        if (remainRight == 0) {
            list.add(s);
            return;
        }
        if (remainLeft == 0) internal(s + ')', 0, remainRight - 1);
        else if (remainLeft == remainRight) {
            internal(s + "(", remainLeft - 1, remainRight);
        } else if (remainRight > remainLeft) {
            internal(s + "(", remainLeft - 1, remainRight);
            internal(s + ')', remainLeft, remainRight - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new GenerateParentheses22().generateParenthesis(3);

        System.out.println('s');
    }
}

