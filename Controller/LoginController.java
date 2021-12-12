package Controller;

import Model.*;

import java.sql.SQLException;
import java.util.List;

public class LoginController {
    String dbsUser = "tom";
    String dbsPass = "password";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/test";

    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    public static String USER;

    public List<RRenter> rentList = model.getRegistRenters();
    public List<Landlord> landList = model.getLandlords();

    public boolean rLogin(String username, String password) { //might not even need to be static
        boolean valid = false;
        for (int i = 0; i < rentList.size(); i++) {
            if (username.equals(rentList.get(i).getUsername())  && password.equals(rentList.get(i).getPassword()))
                valid = true;
        }
        if (valid) {
            this.USER = username;
            System.out.println("valid renter");
        } else {
            System.out.println("invalid renter");
        }
        return valid;
    }

    public boolean mLogin(String username, String password) {
        List<Manager> mgrList = model.getManagers();
        boolean valid = false;
        for (int i = 0; i < mgrList.size(); i++) {
            if (username.equals(mgrList.get(i).getUsername()) && password.equals(mgrList.get(i).getPassword()))
                valid = true;
        }
        if (valid) {
            this.USER = username;
            System.out.println("valid manager");
        } else {
            System.out.println("invalid manager");
        }
        return valid;
    }

    public boolean lLogin(String username, String password) {
        List<Landlord> landList = model.getLandlords();
        boolean valid = false;
        for (int i = 0; i < landList.size(); i++) {
            if (username.equals(landList.get(i).getUsername()) && password.equals(landList.get(i).getPassword()))
                valid = true;
        }
        if (valid) {
            this.USER = username;
            System.out.println("valid landlord");
        } else {
            System.out.println("invalid landlord");
        }
        return valid;
    }

    public boolean rRegister(String name, String username, String password, String email) throws SQLException {
        boolean reg = true;
        for (int i = 0; i < rentList.size(); i++) {
            if (username.equals(rentList.get(i).getUsername())) {
                reg = false;
                System.out.println("username already exists");
                return reg;
            }
        }
        String renter[] = {name, username, password, email};
        Update.renterAdd("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", renter);
        System.out.println("registered!");
        return reg;
    }

    public boolean lRegister(String name, String username, String password) throws SQLException {
        boolean reg = true;
        for (int i = 0; i < landList.size(); i++) {
            if (username.equals(landList.get(i).getUsername())) {
                reg = false;
                System.out.println("username already exists");
                return reg;
            }
        }
        String landlord[] = {name, username, password};
       Update.landlordAdd("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", landlord);
        System.out.println("registered!");
        return reg;
    }

}