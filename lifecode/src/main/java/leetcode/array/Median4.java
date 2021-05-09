package leetcode.array;

import java.util.ArrayList;

public class Median4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        final int len1=nums1.length;
        final int len2=nums2.length;
        int head1 = 0, head2 = 0;
        while (head1 != len1 && head2 != len2) {
            int temp;
            if (nums1[head1] > nums2[head2]) {
                temp = nums2[head2++];
            } else {
                temp = nums1[head1++];
            }
            list.add(temp);
        }

        while (head2 != len2) list.add(nums2[head2++]);
        while (head1 != len1) list.add(nums1[head1++]);
        final int size=list.size();

//        double c=(size%2==0?(list.get(size/2)+list.get(size/2-1))/2.0:list.get(size/2));
//        System.out.println(c);
        return (size % 2 == 0 ? (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0 : list.get(size / 2));

    }

    public static void main(String[] args) {
        new Median4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }
}
