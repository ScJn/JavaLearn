package leetcode.binarySearch;

public class FindInsertPositon_35 {

    public int searchInsert(int[] nums, int target) {
        if(nums == null||nums.length==0)return 0;
        int left = 0, right = nums.length-1;
        int mid;
        // the normal binary search code (= can be neglected sometimes)
        while(left<=right){
            mid=(left+right)>>1;
            if(nums[mid]<target)left = mid+1;
            else right = mid - 1;
        }
        return left;
    }
}
