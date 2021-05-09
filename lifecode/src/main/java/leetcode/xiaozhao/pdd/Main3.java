package leetcode.xiaozhao.pdd;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Main2 {
    public static void main(String[] args) {

        class bank {
            int x;
            int money;

            public bank(int x, int money) {
                this.x = x;
                this.money = money;
            }
        }
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = in.nextInt();

        bank[] banks = new bank[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int money = in.nextInt();
            banks[i] = new bank(x, money);

        }
/*
6 3
1 1
3 5
4 8
6 4
10 3
11 2
 */

        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(banks, (o1, o2) -> o1.x - o2.x);
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (stack.empty() || banks[stack.peek()].money < banks[i].money) {
                stack.push(i);
            } else {
                for (int j = 1; stack.size()-j>=0&& banks[stack.elementAt(stack.size() - j)].money >= banks[i].money; j++) {
                    if (banks[i].x - banks[stack.elementAt(stack.size() - j)].x >= d) {
                        res = Math.max(banks[stack.elementAt(stack.size() - j)].money + banks[i].money, res);
                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
