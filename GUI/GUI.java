import javax.swing.*;

public class GUI {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                formMain mainForm = new formMain();
                mainForm.setVisible(true);
            }
        });
    }
}
