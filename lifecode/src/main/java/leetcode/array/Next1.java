package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, situations that this interface is called, etc.]
 *
 * @author shikamaru
 * @see [String]
 * @see [Document URL]
 * @see [Class name#method name]
 * @since 2022/8/21 4:44 下午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class Next1 {

    public void nextPermutation(int[] nums) {
        int index = 0;
        boolean f = true;
        index = nums.length - 1;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = nums.length-1; i >= 0; i--){
            if (stack.isEmpty() || nums[stack.peek()] < nums[i] ) {
                stack.add(i);
            }
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                index = stack.poll();
                f=false;
            }
            if (!f) {
                int c = nums[i];
                nums[i] = nums[index];
                nums[index] = c;
                break;
            }
        }
        Arrays.sort(nums, index+1, nums.length);
        if (f)
            Arrays.sort(nums);
    }

    public static void main(String[] args) {

        int[] a  = {1,3,2};

        new Next1().nextPermutation(a);

        System.out.println(a);
    }
}
