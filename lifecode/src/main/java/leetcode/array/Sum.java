package leetcode.array;

public class Sum {

    public String name;
     public int[] twoSum(int[] nums, int target) {

        int[] a=new int[2];
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]+nums[j]==target){
                    a[1]=i;a[0]=j;
                    return a;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a= new Sum().twoSum(new int[]{2,3,4,1},3);
        System.out.println(a[0]+" "+a[1]);
    }
}
