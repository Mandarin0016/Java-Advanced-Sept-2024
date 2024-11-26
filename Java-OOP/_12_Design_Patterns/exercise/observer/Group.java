package observer;
/*
Sample code of Observer design pattern
This class implements Subject interface.
Users can register to and deregister from the list to become observer
*/

import java.util.ArrayList;
import java.util.List;


class Group implements Subject { // this class is called subject(observable) in observer design pattern

    private List<Observer> observers = new ArrayList<>();//subscriber/observer list
    private String post;
    private String name;

    Group(String name) {
        this.name = name;
    }

    public void newPost(String post) {
        this.post = post;
        notifyObserver();    //this function notifies new posts to observers
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this.getPost());    //update posts for observers
        }
    }

    public void registerObserver(Observer o) {
        observers.add(o); //add observer object to list
    }

    public void removeObserver(Observer o) {
        observers.remove(o); //remove observer object from list
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public User getObserverByName(String name) {
        return (User) observers.stream()
                               .filter(observer -> observer.getName().equals(name))
                               .findFirst()
                               .get();
    }
}































