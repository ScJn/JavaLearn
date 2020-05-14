package leetcode.random;

import java.util.Arrays;

/**
 * @author scjn
 * @date 2020/5/14 20:54
 */
public class SortByBits {

    class Solution {
        class Pair implements Comparable<Pair>{
            int v;
            int ov;
            int index;
            Pair(int v, int ov, int index){
                this.v = v;
                this.ov = ov;
                this.index = index;
            }

            @Override
            public int compareTo(Pair o) {
                int c =  this.v - o.v;
                return c == 0? ov - o.ov : c;
            }
        }
        public int[] sortByBits(int[] arr) {
            int len = arr.length;
            Pair[] bits = new Pair[len];
            for(int i = 0; i < len; i++){
                int s = arr[i];
                int c = 0;
                for(; s > 0; s >>= 1){
                    c += s & 1;
                }
                bits[i] = new Pair(c,s, i);
            }

            Arrays.sort(bits);
            int[] res = new int[len];
            for(int i = 0; i < len; i++){
                res[i] = res[bits[i].index];
            }
            return res;
        }


    }
    public static void main(String[] args) {
        SortByBits s = new SortByBits();
        Solution solution = s.new Solution();
        int[] ints = solution.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(1);
    }
}
