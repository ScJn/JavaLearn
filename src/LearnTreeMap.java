import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LearnTreeMap {


    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(2, 4);
        map.put(-1, 2);

        System.out.println(map.lowerKey(2));
        System.out.println(map.higherKey(2));
    }


}

class SummaryRanges {

    /**
     * Initialize your data structure here.
     */
    TreeMap<Integer, Integer> L = new TreeMap<>();
    TreeMap<Integer, Integer> R = new TreeMap<>();
    public SummaryRanges() {

    }

    public void addNum(int val) {
        Integer left = R.get(val - 1);
        Integer right = L.get(val + 1);
        L.remove(val + 1);
        R.remove(val - 1);
        Integer nl = left == null ? val : left;
        Integer nr = right == null ? val : right;
        L.put(nl, nr);
        R.put(nr, nl);

    }

    public int[][] getIntervals() {
        int[][] a = new int[L.size()][2];
        final Set<Map.Entry<Integer, Integer>> entries = L.entrySet();
        int index = 0;
        for (Map.Entry entry : entries) {
            a[index][0] = (int) entry.getKey();
            a[index][1] = (int) entry.getValue();
            index ++;
        }
        return a;
    }

    public static void main(String[] args) {
        SummaryRanges s= new SummaryRanges();
        s.addNum(1);
        s.addNum(3);
        s.addNum(7);
        s.addNum(2);
        s.addNum(6);

        s.getIntervals();
    }
}