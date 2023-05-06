import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class logIn {

    static Scanner scan = new Scanner(System.in);

    // public static void main(String[] args) throws SQLException {
    public void takeInput() throws SQLException { 
        boolean loggedin = false;
        while (loggedin == false) {
        System.out.println("Welcome");
        System.out.print("Enter your email: ");
        String email = scan.nextLine();
        if (credCheck("email", email)) {
            System.out.println("Enter your Password");
            String password = scan.nextLine();
            if (credCheck("password", password)) {
                loggedin = true;
                System.out.println("You are Logged in");
            }
            else {
                System.out.println("Wrong Password");
                continue;}
        }
        else {
            System.out.println("Wrong Username");
            continue;}

        }
        

    }

    protected boolean credCheck(String col, String call) throws SQLException {
        boolean found = false;
        dbConnection dbcon = new dbConnection();
        String query = "select " + col + " from login";
        ResultSet res = dbcon.select(query);
        while (res.next()) {
            if (res.getString(1).equals(call)) {
                found = true;
                break;
            }
        }

        dbcon.disconnectFromDatabase();
        return found;
    }
    
}
