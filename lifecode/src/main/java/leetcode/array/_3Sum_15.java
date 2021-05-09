package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum_15 {

    public static void main(String[] args) {
//        new _3Sum_15().threeSum(new int[]{-1,3,4,1,0,2,-6});
        int n =2;
        long ans = (long) n*Integer.MAX_VALUE;
        System.out.println(ans);
    }



    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1])continue;
            List<List<Integer>> lists = twoSum(nums,i+1, -nums[i]);
            for(List<Integer> alist : lists){
                alist.add(nums[i]);
            }
            ans.addAll(lists);
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int begin, int target){
        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length - 1;
        int i=begin, j=n;
        while(i<j){
            int temp = nums[i] + nums[j];
            if(temp<target)i++;
            else if(temp>target)j--;
            else {
                List<Integer> internalList = new ArrayList<>();
                internalList.add(nums[i]);
                internalList.add(nums[j]);
                list.add(internalList);
                i++;
                j--;
            }
        }
        return list;
    }
}
