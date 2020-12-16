import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formManager extends JFrame{
    private JPanel panel_Manager;
    private JTextField addproduct_pid_textfield;
    private JTextField addproduct_name_textfield;
    private JTextField addproduct_price_textfield;
    private JTextField addproduct_brand_textfield;
    private JTextField addproduct_quantity_textfield;
    private JButton ADDButton;
    private JButton REMOVEButton;
    private JTextField remove_pid_textfield;
    private JTextField changequantity_pid_textfield;
    private JTextField changequantity_quantity_textfield;
    private JButton CHANGEQUANTITYButton;
    private JTextField changeprice_pid_textfield;
    private JTextField changeprice_price_textfield;
    private JButton CHANGEPRICEButton;


    public formManager()
    {
       add(panel_Manager);
       setSize(900,800);
       setTitle("MMS");
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p_id,name,brand,price,quantity;
                p_id = addproduct_pid_textfield.getText();
                name = addproduct_name_textfield.getText();
                brand =addproduct_brand_textfield.getText();
                price = addproduct_price_textfield.getText();
                quantity = addproduct_quantity_textfield.getText();

                int id = Integer.parseInt(p_id);
                double price2 =Double.parseDouble(price);
                int quantity2 = Integer.parseInt(quantity);

                Management.addNewProduct(id,quantity2,brand,price2,name);

                addproduct_pid_textfield.setText("");
                addproduct_name_textfield.setText("");
                addproduct_brand_textfield.setText("");
                addproduct_price_textfield.setText("");
                addproduct_quantity_textfield.setText("");

            }
        });
        
       
    }
}
