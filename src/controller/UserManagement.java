package controller;

import db.DbUsersOperations;
import entity.User;

public class UserManagement {

    // Register User
    public Long login(User u) {

        DbUsersOperations dbUsersOperations = new DbUsersOperations();
        return dbUsersOperations.login(u);
    }
}