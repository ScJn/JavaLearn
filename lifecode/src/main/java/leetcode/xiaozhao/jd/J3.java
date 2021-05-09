package leetcode.xiaozhao.jd;

import java.util.concurrent.locks.ReentrantLock;

public class J3 {

    public static void main(String[] args) {

       double a= Math.random();
        System.out.println(a);
    }

    public double totalMoney;
    public volatile double remainMoney;
    public int totalPerson;

    /**
     *
     * @param curMoney
     * @param remainPackage
     * @return
     * @throws Exception
     */
    public double getMoney3(double curMoney, int remainPackage) throws Exception {

        if(curMoney < 0) throw new Exception("error current money");
        if(remainPackage < 0 || totalPerson < remainPackage) throw new Exception("error package number");
        if(remainPackage * 0.01 < curMoney) throw new Exception("error combination of money and total person");


        // DecimalFormat df = new DecimalFormat("#.00");
        ReentrantLock lock = new ReentrantLock(true);

        double factor = Math.random();
        double money;

        lock.lock();
        if(remainPackage == totalPerson){
            money = curMoney;
        }else if(curMoney > totalMoney * 0.9){
            money = totalMoney * 0.9 * factor;
        }else {
            money = curMoney * factor;
        }
        money = (double) Math.round(money * 100) / 100;

        if(money < 0.01) money = 0.01;
        remainMoney -= money;
        lock.unlock();
        return money;
    }

}
