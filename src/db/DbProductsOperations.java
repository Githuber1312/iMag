package db;

import entity.ProductDisplay;
import entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbProductsOperations {

    public boolean insert (Product u) {
        int val =0;
        try {
            // Connect to DB
            final String URLDB = "jdbc:postgresql://localhost:5432/imag";
            final String USERNAMEDB ="postgres";
            final String PWDDB ="1234";

            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // SQL stuff
            PreparedStatement pSt = conn.prepareStatement("insert into products(name, description, price, iduser, idcategory) values(?, ?, ?, ?, ?)");
            pSt.setString(1, u.getName());
            pSt.setString(2, u.getDescription());
            pSt.setDouble(3, u.getPrice());
            pSt.setLong(4, u.getIdUser());
            pSt.setLong(5, u.getIdCategory());
            val = pSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean ok = false;
        if(val!=0)
            ok=true;
        return ok;
    }

    public List<ProductDisplay> readAllProducts (){
        List<ProductDisplay> lp = new ArrayList<>();

        // Read DB products and return list
        try {
            // Connect to DB
            final String URLDB = "jdbc:postgresql://localhost:5432/imag";
            final String USERNAMEDB ="postgres";
            final String PWDDB ="1234";
            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // SQL stuff

            String q = "select products.id as id, products.name as name, products.description as description, products.price as price, products.iduser as iduser, users.username as vendorname, categories.name as categoryname \n" +
                    "    from products, users, categories\n" +
                    "    where products.iduser=users.id \n" +
                    "    and products.idcategory=categories.id \n" +
                    "    order by users.username asc ";

            PreparedStatement pSt = conn.prepareStatement(q);

            ResultSet rs = pSt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name").trim();
                String desc = rs.getString("description").trim();
                double price = rs.getDouble("price");

                String vendorname = rs.getString("vendorname").trim();
                String categoryname = rs.getString("categoryname").trim();

                // Get the iduser value
                long idu = rs.getLong("iduser");

                ProductDisplay p = new ProductDisplay(name, desc, String.valueOf(price), vendorname, categoryname);
                lp.add(p);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return lp;
    }

}
