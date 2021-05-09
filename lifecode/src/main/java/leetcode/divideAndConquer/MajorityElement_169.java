package leetcode.divideAndConquer;

import java.util.*;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        if(nums==null)return 0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int value=0;
            if(map.get(num)!=null)value=map.get(num);
            map.put(num,value+1);
            if(value>nums.length/2)return num;
        }

        return 0;
    }
}
