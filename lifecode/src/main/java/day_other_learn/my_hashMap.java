package day_other_learn;

import java.util.HashMap;

public class my_hashMap {

    public static te cc = new te(2);

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("my", 2);
        System.out.println(map.get("my"));
        String key2 = "aa";
        int a = key2.hashCode();
        Integer a2 = 4;
        int a3 = a2.hashCode();
        System.out.println(a);
        int a4 = -2;
        System.out.println(a4 >>> 1);
        System.out.println(a4 >> 1);
        HashMap<te, Integer> map1 = new HashMap<>
                ();
        map1.put(cc, 4);
        System.out.println(map1.get(cc));
        map1.put(cc,5);
        System.out.println(map1.get(cc));
        System.out.println(cc.hashCode());

        int s=Integer.parseInt("213");
        int s2=Integer.valueOf("213");

    }

    static class te {
        private te(int c) {
            this.c = c;
        }

        int c;

//        @Override
//        public int hashCode() {
//            return super.hashCode();
//        }
    }

}
