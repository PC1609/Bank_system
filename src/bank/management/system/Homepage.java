package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame implements ActionListener {
    String name, email, pin;
    JLabel label5;
    JMenuBar iProducts;
    JMenu iDeposit, iPayment, iAccount, iServices;
    Homepage(String name, String email, String pin){
        super("Bank Of India Online");
        this.name = name;
        this.email =email;
        this.pin = pin;

        label5 = new JLabel("⫸ℬℴⅈ");
        label5.setForeground(new Color(255,51,51));//set color of our text
        label5.setFont(new Font("Cambria", Font.BOLD, 20));
        label5.setBounds(20,5,100,20);//dist from x,y axis of the frame border
        add(label5);

        iProducts = new JMenuBar();
        add(iProducts);
        iDeposit = new JMenu("Deposit");
        iProducts.add(iDeposit);
        //getContentPane().setBackground(new Color(252, 243, 230));
        setLayout(null);
        setSize(850,700);
        setLocation(320,60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Homepage("","","");
    }
}
