import controller.UserManagement;
import db.DbBasketOperations;
import db.DbProductsOperations;
import db.DbUsersOperations;
import entity.*;
import mytests.MyTestProducts;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        boolean existentUser=false;
//        do {
//             existentUser=false;
//            System.out.println("Salut , hai sa ne inregistram ");
//            Scanner sc = new Scanner(System.in);
//            System.out.print("New User:");
//            String username = sc.nextLine();
//            System.out.print("Pwd:");
//            String pwd = sc.nextLine();
//            User u = new User(username, pwd);
//
//            DbUsersOperations db = new DbUsersOperations();
//            try {
//                db.insert(u);
//            } catch (SQLException e) {
//                existentUser=true;
//                System.out.println("nu se poate cu acest user, reincearca");
//            }
//        }
//        while(existentUser);



 Long idUser=null;
do {
    Scanner sc = new Scanner(System.in);
    System.out.print("Login User:");
    String username = sc.nextLine();
    System.out.print("Pwd:");
    String pwd = sc.nextLine();
    User u = new User(username, pwd);
    UserManagement um = new UserManagement();
    idUser=um.login(u);
}
while(idUser==null);

System.out.println("salut usere cu id:"+idUser);


// list products
        DbProductsOperations db = new DbProductsOperations();
        List<ProductDisplay> lp = db.readAllProducts();

        for(ProductDisplay p: lp) {
            System.out.println(p);
        }


        // simulam add in cos a produselor
        Scanner sc = new Scanner(System.in);
        System.out.print("ce id pui in cos:");
        Long idprod = sc.nextLong();

        Basket b = new Basket(idUser,idprod );

        DbBasketOperations dbBasketOperations = new DbBasketOperations();
        dbBasketOperations.insert(b);


        System.out.print("ce id pui in cos:");
         idprod = sc.nextLong();
         b = new Basket(idUser,idprod );
        dbBasketOperations.insert(b);


        // afisez cosului userului logat

        DbBasketOperations dbb = new DbBasketOperations();
        List<BasketDisplay> lb = dbb.readBasketOfAUser(12L);
        for(BasketDisplay bask: lb) {
            System.out.println(bask);
        }


        // sterg din cos
        System.out.print("ce id sterg din cos:");
        Scanner sca = new Scanner(System.in);
        Long idcoosdesters=sca.nextLong();
        dbb.deleteBasketItem(idcoosdesters);

        // cer din nou cosul de la db
        lb = dbb.readBasketOfAUser(12L);
        for(BasketDisplay bask: lb) {
            System.out.println(bask);
        }


    }
}