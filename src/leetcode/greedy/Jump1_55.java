package leetcode.greedy;

public class Jump1_55 {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)return true;
        for(int i=0;i<nums.length;){
            int max=-1,  next = i;
            for(int j=i; j-i<=nums[i] && j<nums.length; j++){
                if(j + nums[j] >= nums.length-1)return true;
                if(j + nums[j] >= max){
                    max = j + nums[j];
                    next = j;
                }
            }
            i = next;
            if(nums[next] == 0) return i>=nums.length-1;
        }
        return true;
    }

    public static void main(String[] args) {
        new Jump1_55().canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0});
    }


}
