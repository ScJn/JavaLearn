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
            Pair(int v, int ov){
                this.v = v;
                this.ov = ov;
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
                int os = arr[i];
                int c = 0;
                for(int s = os; s > 0; s >>= 1){
                    c += s & 1;
                }
                bits[i] = new Pair(c,os);
            }

            Arrays.sort(bits);
            int[] res = new int[len];
            for(int i = 0; i < len; i++){
                res[i] = bits[i].ov;
            }
            return res;
        }


    }
    public static void main(String[] args) {
        SortByBits s = new SortByBits();
        Solution solution = s.new Solution();
        int[] ints = solution.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1});
        System.out.println(1);
    }
}
