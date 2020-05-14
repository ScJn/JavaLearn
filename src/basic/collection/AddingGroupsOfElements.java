package basic.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddingGroupsOfElements {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 1, 2, 3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(2);
        int[] a = new int[]{1, 3, 2, 4, 5};
        ArrayList<Integer> arrayList1 = new ArrayList<>(arrayList);
    }
}
