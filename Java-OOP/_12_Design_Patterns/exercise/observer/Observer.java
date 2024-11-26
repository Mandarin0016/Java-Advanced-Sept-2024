package observer;

/*
Any class which implements this interface
will be called observer
in observer design pattern
*/
public interface Observer {

    void update(String post);
    String getName();
}
