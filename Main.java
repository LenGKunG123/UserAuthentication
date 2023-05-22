import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String username, password , ask;
        UserManager userManager = new UserManager();
        User user;
        Scanner scan = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            System.out.println("Welcome to User Management System");
            System.out.println(" ");
            System.out.println("Select your option");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Delete your account");
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("enter username : ");
                    username = scan.nextLine();
                    System.out.println("enter password : ");
                    password = scan.nextLine();
                    user = new User(username, password);
                    userManager.registerUser(user);
                    break;
                case 2:
                    System.out.println("enter username : ");
                    username = scan.nextLine();
                    System.out.println("enter password : ");
                    password = scan.nextLine();
                    if (userManager.loginUser(username, password)) {
                        System.out.println("Login success");
                    } else {
                        System.out.println("Login fail");
                    }
                    break;
                case 3:
                    System.out.println("enter username : ");
                    username = scan.nextLine();
                    userManager.delectUser(username);
            }
        }
    }
}