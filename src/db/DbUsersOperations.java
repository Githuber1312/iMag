package db;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUsersOperations {

    public Long login(User user){
        Long idUser = null;

        // Read all users from DB
        try {
            // Connect to DB
            final String URLDB = "jdbc:postgresql://localhost:5432/imag";
            final String USERNAMEDB ="postgres";
            final String PWDDB ="1234";
            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // SQL stuff
            String q;
            q = "select id from users where username=? and password=?";

            PreparedStatement pSt = conn.prepareStatement(q);

            pSt.setString(1, user.getUsername());
            pSt.setString(2, user.getPassword());

            ResultSet rs = pSt.executeQuery();

            while (rs.next()){
                idUser = rs.getLong(("id"));
                System.out.println("Login successful!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (idUser == null)
            System.out.println("Login failed.");
        return idUser;
    }


    public boolean insert (User u) {
        int val = 0;
        try {
            // Connect to DB
            final String URLDB = "jdbc:postgresql://localhost:5432/imag";
            final String USERNAMEDB ="postgres";
            final String PWDDB ="1234";

            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // SQL stuff
            PreparedStatement pSt = conn.prepareStatement("insert into users(username, password, isverified, isbuyer) values(?, ?, ?, ?)");
            pSt.setString(1, u.getUsername());
            pSt.setString(2, u.getPassword());
            pSt.setBoolean(3, u.isVerified());
            pSt.setBoolean(4, u.isBuyer());
            val = pSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean ok = false;
        if(val!=0)
            ok=true;
        return ok;
    }

    public List<User> readAllUsers (boolean allDespiteStatus){
        List<User> lu = new ArrayList<>();

        // Read DB users and return list
        try {
            // Connect to DB
            final String URLDB = "jdbc:postgresql://localhost:5432/imag";
            final String USERNAMEDB ="postgres";
            final String PWDDB ="1234";
            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // SQL stuff
            String q;
            if (allDespiteStatus)
                q = "select * from users order by username asc";
            else
                q = "select * from users where isVerified = true order by username asc";
            PreparedStatement pSt = conn.prepareStatement(q);

            ResultSet rs = pSt.executeQuery();

            while (rs.next()) {
                String user = rs.getString("username").trim();
                String p = rs.getString("password").trim();
                boolean isv = rs.getBoolean("isverified");
                boolean isb = rs.getBoolean("isbuyer");

                long id = rs.getLong("id");

                User u = new User(user, p, isv, isb);
                u.setId(id);
                lu.add(u);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return lu;
    }
}
