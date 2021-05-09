package leetcode.array;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = -1;

        while (left != right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
//    while (height[left] < height[right]) {
//        left++;
//    }
//            while (height[left] >= height[right]) {
//        right++;
//    }

    public static void main(String[] args) {
        ContainerWithMostWater c=new ContainerWithMostWater();
        int res=c.maxArea(new int[]{1,3,4,5,6,7,8});
        System.out.println();

    }
}
