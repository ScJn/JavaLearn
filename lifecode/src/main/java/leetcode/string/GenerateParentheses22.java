package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * use recursive method
 * three parameters, the String, the remainLeft and the remainRight
 * remainRight==0 means over;
 * two possibilities , one is remainLeft==remainRight, you can only plus the '(',
 * invoke the method recursively with the remainLeft-1, the other is remainLeft>remainRight,
 * you can invoke both two way, make sure you have remainLeft.
 */
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

