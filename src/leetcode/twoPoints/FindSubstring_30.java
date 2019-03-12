package leetcode.twoPoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * counts.put(word, counts.getOrDefault(word, 0) + 1); // <word,count>
 */
public class FindSubstring_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        final List<Integer> indexes = new ArrayList<>();
        if("".equals(s)||words.length==0)return indexes;
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1); // <word,count>
        }
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) { // first need have the word
                    seen.put(word, seen.getOrDefault(word, 0) + 1);//  <word,count>
                    if (seen.get(word) > counts.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
