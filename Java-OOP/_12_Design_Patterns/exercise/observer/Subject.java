package observer;



/*
Sample code for observer design pattern
This is the interface which must be implemented by a class
to be called as subject in observer pattern
*/
public interface Subject { //subject(observable) must implement these functions
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}