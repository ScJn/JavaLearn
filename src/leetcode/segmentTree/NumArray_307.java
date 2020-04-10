package leetcode.segmentTree;

public class NumArray_307 {
}

class NumArray {

    int[] tree;
    int[] nums;

    void build(int[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[end];
            return;
        }
        int mid = (start + end) >> 1;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        build(tree, arr, leftNode, start, mid);
        build(tree, arr, rightNode, mid + 1, end);
        tree[node] = tree[leftNode] + tree[rightNode];
        return;
    }

    void update(int[] tree, int node, int start, int end, int i, int val) {

        if (start == end) {

            tree[node] = val;
            return;
        }
        int mid = (start + end) >> 1;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        if (start <= i && i <= mid)
            update(tree, leftNode, start, mid, i, val);
        else update(tree, rightNode, mid + 1, end, i, val);
        tree[node] = tree[leftNode] + tree[rightNode];

    }

    int sumRange(int[] tree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) return 0;
        else if (left <= start && end <= right) return tree[node];
        else if (start == end) {
            return tree[node];
        }

        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        int mid = (start + end) >> 1;
        return sumRange(tree, leftNode, start, mid, left, right) + sumRange(tree, rightNode, mid + 1, end, left, right);

    }

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length << 2];
        build(tree, nums, 0, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(tree, 0, 0, nums.length - 1, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(tree, 0, 0, nums.length - 1, i, j);
    }

    public static void main(String[] args) {
        NumArray a = new NumArray(new int[]{1, 3, 5, 7});
        for (int node : a.tree) System.out.print(node + ",");
        System.out.println();
        System.out.println(a.sumRange(1, 3));
        a.update(0, 2);
        for (int node : a.tree) System.out.print(node + ",");
        System.out.println(a.sumRange(0, 2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */