package forMyTest;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        /*** 定制每日2:00执行方法 ***/

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date date=calendar.getTime(); //第一次执行定时任务的时间
        Timer timer = new Timer();
        timer.schedule(new MyTask("C:\\a.txt"),date,PERIOD_DAY);
    }
}

class MyTask extends TimerTask {

    private String fileName;

    public MyTask(String filename){
        this.fileName = filename;
    }
    private void deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
        }
    }
    @Override
    public void run() {
       deleteFile(fileName);
    }

}