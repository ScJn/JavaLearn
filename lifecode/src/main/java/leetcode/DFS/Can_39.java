package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

public class Can_39 {

    int target;
    List<List<Integer>> ans;
    int[] cand;

    public static void main(String[] args) {
        new Can_39().combinationSum(new int[]{2,3,6,7},7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        cand = candidates;
        ans = new ArrayList<>();
        dfs(new ArrayList<>(), 0,0);
        return ans;

    }

    void dfs(List<Integer> curList, int sum, int index){

        if(sum == target){
            ans.add(new ArrayList<>(curList));
            return;
        }else if(sum > target){
            return;
        }

        for(int i=index;i<cand.length;i++){
            if(sum+cand[i]>target)return;
            curList.add(cand[i]);
            dfs(curList, sum+cand[i], i);
            curList.remove((Integer) cand[i]);
        }

    }
}
