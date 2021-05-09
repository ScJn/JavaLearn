package design_pattern.observer;

public class Guardian implements Observer {
    private Character a;

    @Override
    public void notify(String tweet) {
        if (tweet.contains("boy")) {
            System.out.println("Guardian:" + tweet);
        }
    }
}
