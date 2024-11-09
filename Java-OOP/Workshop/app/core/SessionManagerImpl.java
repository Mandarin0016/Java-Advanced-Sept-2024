package core;


import entities.user.User;

public class SessionManagerImpl implements SessionManager {

    private User activeUser = null;

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User user) {
        this.activeUser = user;
    }

    public boolean hasActiveSession() {
        return activeUser != null;
    }

    public void terminateActiveSession() {
        this.activeUser = null;
    }
}
