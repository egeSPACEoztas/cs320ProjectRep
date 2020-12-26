import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formMain extends JFrame {


    private JButton button_manager;
    private JButton button_customer;
    private JPanel panel_main;

    public formMain(){
        add(panel_main);
        setSize(600,600);
        setTitle("MMS");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button_manager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                formPassword password = new formPassword();
                password.setVisible(true);
            }
        });

        button_customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                formShopping shopping = new formShopping();
                shopping.setVisible(true);
            }
        });

    }
}
