package leetcode.binarySearch;

public class MsizeSubArray_209 {

    public int minSubArrayLen(int s, int[] nums) {

        int temp = 0;
        int len = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (temp < s) {
                temp += nums[i];
                len++;

            }
            while (temp >= s){
                min = Math.min(min, len);
                temp -= nums[i - len + 1];
                len--;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        int c = new MsizeSubArray_209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(c);
    }
}
