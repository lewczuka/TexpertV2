package main.model;

import java.util.ArrayList;

public class User {
    private final int ID;
    private String name;
    private ArrayList<Search> searches;

    public User(int ID, String name){
        this.ID = UserManager.getInstance().nextID;
        this.name = name;
        searches = new ArrayList<>();
        UserManager.getInstance().nextID++;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumSearches(){
        return searches.size();
    }

    public void addSearch(Search search){
        searches.add(search);
    }

    public void clearSearches(){
        searches.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return ID == user.ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }
}

