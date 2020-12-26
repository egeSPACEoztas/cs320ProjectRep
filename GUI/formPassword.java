import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formPassword extends JFrame {
    private JPanel panel_password;
    private JPasswordField passwordField1;
    private JButton button_password;
    private JLabel label_password;
    private JButton mainScreenButton;

    public formPassword(){
        add(panel_password);
        setSize(600,600);
        setTitle("MMS");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        button_password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password_manager, password_field;

                password_manager = String.valueOf(Management.password);
                password_field = new String(passwordField1.getPassword());

                if(password_field.equals(password_manager)){
                    setVisible(false);
                    formManager manager = new formManager();
                    manager.setVisible(true);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Password \nTry Again");
                    passwordField1.setText("");
                }
            }
        });

        mainScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                formMain main = new formMain();
                main.setVisible(true);
            }
        });
    }
}
