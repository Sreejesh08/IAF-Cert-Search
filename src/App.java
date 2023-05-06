import java.util.Scanner;


public class App {

    static Scanner sc = new Scanner(System.in);

    static void IAFinfo(){
        System.out.println("");
        System.out.println("ABOUT IAF");
        System.out.println("The International Accreditation Forum (IAF) is a worldwide association of accreditation bodies and other bodies interested in conformity assessment in the fields of management systems, products, processes, services, personnel, validation and verification and other similar programmes of conformity assessment.");
        System.out.println("Our primary function is to develop a single worldwide program of conformity assessment which reduces risk for businesses and their customers by assuring them that accredited certificates and validation and verification statements may be relied upon.");
        System.out.println("");
    }

    static int ToDo(){
        System.out.println("1. Search \n2. Login \n3. Know about IAF.\n4. Exit");
        System.out.print("What would you like to do?? ");
        int ch = Integer.parseInt(sc.nextLine());
        return ch;
    }

    static int LoginPage(){
        System.out.println("\nLOGIN PAGE");
        System.out.println("1. Login as Admin (1).");
        System.out.println("2. Login as Controller (2).");
        System.out.println("3. Back");
        System.out.print("Login as: ");
        int option = Integer.parseInt(sc.nextLine());
        return option;
    }

    static void Login(int login) throws Exception{

            switch (login) {
                case 1:
                Admin admin = new Admin();
                admin.adminPage();
                    break;
                case 2:
                Controller controller = new Controller();
                controller.controllerPage();
                    break;
            }

    }


    static void HomePage() throws Exception{
        boolean con2 = true;
        do{
            System.out.println("\nINTERNATIONAL ACCREDIATION FORUM");
            System.out.println("Celebrating 30 Years\n");

            int todo = ToDo();
            switch(todo){
                case 1:
                User use = new User();
                    try {
                        use.search1(true);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    int log = LoginPage();
                    Login(log);
                    break;
                case 3:
                    IAFinfo();
                    break;
                case 4:
                    System.out.println("SEE YOU NEXT TIME AROUND.\n");
                    con2 = false;
                    break;
                default:
                    System.out.println("\nInvalid Choice.\n");
                    break;
            }
    }
    while(con2);
    }



    public static void main(String[] args) throws Exception {
        HomePage();    
        sc.close();}
}


