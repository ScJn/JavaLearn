package leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstring3 {
    public static void main(String[] args) {
        while (true) {

            HashSet<Character> set = new HashSet<>();
            int size = 0;
            int maxSize = -1;
            int head = 0;
            Scanner in = new Scanner(System.in);


            String s = in.next();
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                if (!set.contains(now)) {
                    set.add(now);
                    size++;
                    maxSize = Math.max(size, maxSize);
                } else {
                    while (s.charAt(head) != now) {
                        set.remove(s.charAt(head));
                        head++;
                        size--;
                    }
                    head++;
                }
            }
            System.out.println(maxSize);
        }
    }
}
