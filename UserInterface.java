import java.util.Scanner;

public class UserInterface {
    public static String searchOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to restore?");
        String search = sc.nextLine();
        return search;
    }
    public static String getAPIKey(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Google API Key");
        String key = sc.nextLine();
        return key;
    }
}
