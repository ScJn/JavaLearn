package design_pattern.observer;

public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet.contains("money")) {
            System.out.println("NY times:" + tweet);
        }
    }
}
