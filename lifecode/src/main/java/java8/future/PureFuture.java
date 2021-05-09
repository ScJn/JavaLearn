package java8.future;


import java.util.concurrent.*;

public class PureFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
// 定义任务:
        Callable<String> task = new Task();
// 提交任务并获得Future:
        Future<String> future = executor.submit(task);
// 从Future获取异步执行返回的结果:
        String result = future.get(); // 可能阻塞
        System.out.println(result);
        executor.shutdown();
    }

    static class Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "call";
        }
    }
}
