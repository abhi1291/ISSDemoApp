package model;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Library extends RealmObject {

    @PrimaryKey
    private long id;
    @LinkingObjects("library")
    private final RealmResults<Book> employees = null;

    public RealmResults<Book> getEmployees() {
        return employees;
    }

    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




}

