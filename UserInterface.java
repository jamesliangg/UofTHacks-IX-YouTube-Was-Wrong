import javax.swing.JOptionPane;

public class UserInterface {
    public static String searchOption(){
        String search;
        search = JOptionPane.showInputDialog(null, "What do you want to restore?");
        return search;
    }
}
