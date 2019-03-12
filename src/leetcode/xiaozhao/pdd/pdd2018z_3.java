package leetcode.xiaozhao.pdd;

import java.util.Scanner;

public class pdd2018z_3 {

    public static void main(String[] args) {
        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            nodes[i] = new Node(x, y);
        }
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i; j < n - 1; j++) {
                for (int k = j; k < n; k++) {
                    Node n1 = nodes[i];
                    Node n2 = nodes[j];
                    Node n3 = nodes[k];

                    if ((n2.y - n1.y) * (n3.x - n1.x) != (n3.y - n1.y) * (n2.x - n1.x)) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
