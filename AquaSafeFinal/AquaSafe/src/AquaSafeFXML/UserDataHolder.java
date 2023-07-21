package AquaSafeFXML;

import model.User;

public class UserDataHolder {

    private static UserDataHolder instance;
    private User user;

    private UserDataHolder() {
    }

    public static UserDataHolder getInstance() {
        if (instance == null) {
            instance = new UserDataHolder();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
