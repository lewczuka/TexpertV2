package main.model;

import main.exception.InvalidUserException;

import java.util.HashSet;
import java.util.Iterator;

public class UserManager implements Iterable<User> {
    private static UserManager instance;
    private HashSet<User> users;
    protected int nextID;

    private UserManager() {
        users = new HashSet<>();
        nextID = 0;
    }

    public static UserManager getInstance() {
        if (instance == null)
            instance = new UserManager();

        return instance;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void clearUsers(){
        users.clear();
    }

    public User getUser(int ID) throws InvalidUserException {
        for (User next : users) {
            if (next.getID() == ID)
                return next;
        }
        throw new InvalidUserException("User ID is invalid");
    }

    public int getNextID(){
        return nextID;
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}

