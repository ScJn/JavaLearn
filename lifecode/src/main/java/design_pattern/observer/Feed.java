package design_pattern.observer;

import java.util.ArrayList;

public class Feed implements Subject {

    private ArrayList<Observer>  observerArrayList = new ArrayList<>();
    @Override
    public void registerObserver(Observer o) {
        observerArrayList.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        for (Observer observer : observerArrayList) {
            observer.notify(tweet);
        }
    }
}
