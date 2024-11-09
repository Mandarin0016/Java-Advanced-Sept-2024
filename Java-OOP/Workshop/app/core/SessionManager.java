package core;

import entities.user.User;

public interface SessionManager {

    User getActiveUser();

    void setActiveUser(User user);

    boolean hasActiveSession();

    void terminateActiveSession();
}
