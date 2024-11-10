package core;

// TODO: Implement session manager for the active User
public interface SessionManager<T> {

    T getActiveSession();

    void setActiveSession(T user);

    boolean hasActiveSession();

    void terminateActiveSession();
}
