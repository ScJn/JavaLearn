package leetcode.binarySearch;

public class SearchRotated_33 {

    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;

            if ((target >=nums[0]) ==(nums[mid] >=nums[0]) ) {
                if (nums[mid] > target) right = mid-1;
                else if (nums[mid] < target) left = mid + 1;
                else return mid;
            } else if (target > nums[mid]) right = mid-1;
            else left = mid + 1;
        }
        if(nums[left]==target)return left;
        return -1;
    }

    public static void main(String[] args) {
        int c=new SearchRotated_33().search(new int[]{1,3},3);
        System.out.println(c);
    }
}
