import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (true) {
//            ArrayList<Integer> monthDay = new ArrayList<Integer>(Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));
//            String leaveTime = in.next();
//            String returnTime = in.next();
//            String[] leaveTimeStr = leaveTime.split("\\.");
//            String[] returnTimeStr = returnTime.split("\\.");
//            boolean f = false;
//            System.out.println(leaveTime);
//            for (String a : leaveTimeStr) {
//                System.out.println("##" + a + "\n");
//            }
////
//            int leaveYear = Integer.valueOf(leaveTimeStr[0]);
//            int leaveMonth = Integer.valueOf(leaveTimeStr[1]);
//            int leaveDay = Integer.valueOf(leaveTimeStr[2]);
//            int returnYear = Integer.valueOf(returnTimeStr[0]);
//            int returnMonth = Integer.valueOf(returnTimeStr[1]);
//            int returnDay = Integer.valueOf(returnTimeStr[2]);
//
//            if (leaveYear % 4 == 0 && (leaveYear % 100 != 0 || leaveYear % 400 == 0)) monthDay.set(1, 29);
//
//            boolean yearSame = leaveYear == returnYear;
//            boolean yearSpe = (leaveYear == returnYear - 1 && (leaveMonth == 12 && returnMonth == 1));
//            boolean monthSame = leaveMonth == returnMonth;
//            boolean monthSpe = leaveMonth == returnMonth - 1;
//
//            if (yearSame) {
//                if (monthSame) {
//                    if (returnDay - leaveDay < 15 && leaveDay < returnDay) f = true;
//                } else if (monthSpe) {
//                    if (monthDay.get(leaveMonth) - leaveDay + 1 + returnDay < 15) f = true;
//                }
//            } else if (yearSpe) {
//                if (31 - leaveDay + 1 + returnDay < 15) f = true;
//            }
//            System.out.println(f);
//        }
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        int hour = cale.get(Calendar.HOUR_OF_DAY);
        int minute = cale.get(Calendar.MINUTE);
        int second = cale.get(Calendar.SECOND);
        int dow = cale.get(Calendar.DAY_OF_WEEK);
        int dom = cale.get(Calendar.DAY_OF_MONTH);
        int doy = cale.get(Calendar.DAY_OF_YEAR);
        System.out.println(doy);

    }

}
