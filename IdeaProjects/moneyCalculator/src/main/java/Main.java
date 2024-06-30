import javax.swing.SwingUtilities;
import swing.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
