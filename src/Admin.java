import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin extends Controller {
    static dbConnection dbcon = new dbConnection();

    static Scanner scan = new Scanner(System.in);
    public void adminPage() throws Exception {
        logIn log = new logIn();
        log.takeInput();
        int choice;
        do {
            System.out.println("Press 1 to View Employee Info");
            System.out.println("Press 2 to Add a new Employee");
            System.out.println("Press 3 to remove an Employee");
            System.out.println("Press 9 to log out");
            System.out.print("Choice: ");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                viewDetail();
                break;
                case 2:
                addEmp();
                break;
                case 3:
                removeEmp();
                break;
                case 9:
                dbcon.disconnectFromDatabase();
                System.out.println("Good Bye");
                break;
                default:
                System.out.println("Wrong Input");

            }
            
        }
        while(choice != 9);
    }

    protected void addEmp() throws SQLException {
        System.out.print("Enter the Employee ID: ");
        int emp_id = Integer.parseInt(scan.nextLine());
        System.out.print("Enter the Employees Name: ");
        String emp_name = scan.nextLine();
        System.out.print("Enter Employees Address: ");
        String emp_add = scan.nextLine();
        System.out.print("Enter Employees Type: ");
        String emp_type = scan.nextLine();        
        String query = "insert into employees values(" + emp_id + ",'" + emp_name + "','"
        + emp_add + "','" + emp_type + "');";
        dbcon.insetInto(query);
        System.out.println("New Employee Added!");
    }

    protected void removeEmp() throws SQLException {
        System.out.print("Enter Employees ID: ");
        int emp_id = Integer.parseInt(scan.nextLine());
        String query = "delete from login where emp_id = " + emp_id;
        dbcon.drop(query);
        System.out.println("Employees Log In deleted");

    }

    protected void viewDetail() throws SQLException {
        String query = "select * from employees where not emp_type = 'Admin';";
        ResultSet result = dbcon.select(query);
        while (result.next()) {
            System.out.println("Employee ID: " + result.getInt(1));
            System.out.println("Employees Name: " + result.getString(2));
            System.out.println("Employees Address: " + result.getString(3));
            System.out.println("Employees Type: " + result.getString(4));
            System.out.println();
        }
        

        
        
        
    }
    
}
