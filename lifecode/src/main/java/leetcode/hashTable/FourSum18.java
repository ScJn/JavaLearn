package leetcode.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum18 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        return kSum(nums,target,4,0);
    }

    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k,int index) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (k == 2) {
            int i = index, j = nums.length - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);
                    // skip the duplicated
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;
                    i++;
                    j--;
                }
                //never equals
                if (target - nums[i] < nums[j]) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {
            for (int i = index; i < nums.length; i++) {

                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1,i+1);
                if (temp != null) {
                    for (List<Integer> t : temp) {
                        t.add(nums[i]);
                    }
                    lists.addAll(temp);
                    while (i < nums.length-1 && nums[i] == nums[i + 1]) i++;
                }
            }
        }
        return lists;

    }
}
