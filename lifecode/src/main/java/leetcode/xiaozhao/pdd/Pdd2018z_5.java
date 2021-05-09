package leetcode.xiaozhao.pdd;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 时间复杂度过高
 *
 *
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），
 * 则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 * 如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
 *
 * 我的算法，copy2个数组，一个以x降序，一个以y降序
 * 遍历xList，对于每一个node遍历yList看在碰到自己之前有没有既在xList中排前，又在yList中排前面
 *
 * 复杂原因，xList维护了x信息。然后只需要比较前缀有没有比我y大的，只需要2值比较（维护前缀中y最大的），不需要全部排序
 */
public class Pdd2018z_5 {

    public static void main(String[] args) {

        class Bear implements Comparable<Bear> {
            int no;
            int fight;
            int hunger;

            public Bear(int fight, int hunger, int no) {
                this.no = no;
                this.fight = fight;
                this.hunger = hunger;
            }

            @Override
            public int compareTo(Bear o) {
                return o.fight - this.fight;
            }
        }
        Scanner in = new Scanner(System.in);
        int bearNum = in.nextInt();
        Bear[] bears = new Bear[bearNum];
        int candyNum = in.nextInt();
        Integer[] candy = new Integer[candyNum];
        LinkedList<Integer> sortCandyList = new LinkedList<>();
        for (int i = 0; i < candyNum; i++) {
            candy[i] = (in.nextInt());
        }
        Bear[] originBears = Arrays.copyOf(bears, bearNum);
        Arrays.sort(candy, (o1, o2) -> o2 - o1);
        sortCandyList.addAll(Arrays.asList(candy));
        for (int i = 0; i < bearNum; i++) {
            int fight = in.nextInt();
            int hunger = in.nextInt();
            bears[i] = new Bear(fight, hunger, i);
        }

        Arrays.sort(bears);
        for (Bear bear : bears) {
            int candyIndex = 0;
            while (candyIndex < sortCandyList.size()&&bear.hunger!=0) {
                if (bear.hunger - sortCandyList.get(candyIndex) >= 0) {
                    bear.hunger -= sortCandyList.get(candyIndex);
                    sortCandyList.remove(candyIndex);
                } else{
                    candyIndex++;
                }
            }
        }

        Arrays.sort(bears, Comparator.comparingInt(o -> o.no));
        for (Bear bear : bears) System.out.println(bear.hunger);
    }
}
