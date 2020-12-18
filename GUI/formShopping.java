import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class formShopping extends JFrame {

    private JTable table1;
    private JPanel panel_shopping;
    private JTextField textField_id;
    private JTextField textField_quantity;
    private JButton addButton;
    private JTable table2;
    private JButton buyButton;
    private JLabel label_price;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private double totPrice;


    public formShopping() {
        add(panel_shopping);
        setSize(600, 600);
        setTitle("MMS");
        createTable();
        createTable2();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField_id.getText();
                String quantity = textField_quantity.getText();

                int quantityInt = Integer.parseInt(textField_quantity.getText());
                int stockQuantity = Database.getQuantity(Integer.parseInt(id));

                if (quantityInt > stockQuantity) {
                    JOptionPane.showMessageDialog(null, "There is no enough quantity of that product");
                    textField_id.setText("");
                    textField_quantity.setText("");
                } else {
                    int intQuantity = Integer.parseInt(quantity);
                    int pid = Integer.parseInt(id);
                    double price = Database.getPrice(pid);
                    double basketPrice = price * intQuantity;
                    totPrice += basketPrice;

                    Object shoppingBasket[] = new Object[]{id, quantity, basketPrice};
                    model2.addRow(shoppingBasket);
                    Product newProduct = new Product(pid, intQuantity);
                    Customer.shoppingBasket.add(newProduct);
                    textField_id.setText("");
                    textField_quantity.setText("");

                    Object currentQuantity = model.getValueAt((pid - 1), 4);
                    model.setValueAt(((int) currentQuantity - intQuantity), pid - 1, 4);

                    String totP = Double.toString(totPrice);
                    label_price.setText(totP);
                }
            }
        });
    }
}
