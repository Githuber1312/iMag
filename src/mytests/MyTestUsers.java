package mytests;

import db.DbUsersOperations;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class MyTestUsers {
    public static void main(String[] args) {

        //new MyTestUsers().testInsert();
        new MyTestUsers().testSelect(false);

    }

    private void testInsert(){
        User u = new User("testerdoi", "pws", true, true);
        User u1 = new User("celalalttester", "pws", true, true);

        User um = new User("imag", "pws", true, false);
        User um1 = new User("lidl", "pws", true, false);

        DbUsersOperations db = new DbUsersOperations();
        db.insert(u);
        db.insert(u1);
        db.insert(um);
        db.insert(um1);
    }

    private void testSelect(boolean b){
        DbUsersOperations db = new DbUsersOperations();
        List<User> lu = db.readAllUsers(b);

        for(User u: lu) {
            System.out.println(u);
        }
    }
}
