package design_pattern.observer;

public class NewsProducer {

    public static void main(String[] args) {

        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver((s)-> {
            if (s.contains("hero")) {
                System.out.println("hero: " + s);
            }
        });

        feed.notifyObservers("Does hero love money?");
    }
}
