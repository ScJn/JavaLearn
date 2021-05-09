package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingPositive41 {

    public int firstMissingPositive(int[] nums) {
        int[] a = new int[nums.length + 2];
        for (int now : nums) {
            if (now > 0 && now < a.length - 1)
                a[now] = 1;

        }
        for (int i = 1; i < nums.length + 2; i++) {
            if (a[i] == 0) return i;
        }
        return nums.length + 1;
    }

    int firstMissingPositive2(int[] A) {
        int n=A.length;
        for (int i = 0; i < n; ++i)
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]){}
//                swap(A[i], A[A[i] - 1]);

        for (int i = 0; i < n; ++i)
            if (A[i] != i + 1)
                return i + 1;
        List<List<Integer>> lists=new ArrayList<>();


        return n + 1;
    }
}
