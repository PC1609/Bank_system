package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    JLabel label1, label5;
    Transaction(String pin){
        super("Welcome to ATM");
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,850,700);
        add(i4);
        label1 = new JLabel("ATM");
        label1.setForeground(Color.BLACK);//set color of our text
        label1.setFont(new Font("Impact", Font.BOLD, 35));
        label1.setBounds(320,90,100,35);//dist from x,y axis of the frame border
        i4.add(label1);

        label5 = new JLabel("⫸ℬℴⅈ");
        label5.setForeground(new Color(255,51,51));//set color of our text
        label5.setFont(new Font("Cambria", Font.BOLD, 20));
        label5.setBounds(780,10,100,20);//dist from x,y axis of the frame border
        i4.add(label5);

        JLabel l1 = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        l1.setFont(new Font("Cambria",Font.BOLD, 16));
        l1.setBounds(170,220,700,35);
        i4.add(l1);

        b1 = new JButton("Deposit");
        b1.setBounds(160,300,150,25);
        //b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBackground(new Color(65,125,128));
        b1.addActionListener(this);
        i4.add(b1);

        b2 = new JButton("Cash Withdrawal");
        b2.setBounds(380,300,150,25);
        b2.setOpaque(true);
        b2.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        i4.add(b2);

        b3 = new JButton("Fast Cash");
        b3.setBounds(160,325,150,25);
        //b1.setForeground(Color.WHITE);
        b3.setOpaque(true);
        b3.setBackground(new Color(65,125,128));
        b3.addActionListener(this);
        i4.add(b3);

        b4 = new JButton("Mini statement");
        b4.setBounds(380,325,150,25);
        b4.setOpaque(true);
        b4.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b4.addActionListener(this);
        i4.add(b4);

        b5 = new JButton("Pin change");
        b5.setBounds(160,350,150,25);
        //b1.setForeground(Color.WHITE);
        b5.setOpaque(true);
        b5.setBackground(new Color(65,125,128));
        b5.addActionListener(this);
        i4.add(b5);

        b6 = new JButton("Balance enquiry");
        b6.setBounds(380,350,150,25);
        b6.setOpaque(true);
        b6.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b6.addActionListener(this);
        i4.add(b6);

        b7 = new JButton("Exit");
        b7.setBounds(380,375,150,25);
        b7.setOpaque(true);
        b7.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b7.addActionListener(this);
        i4.add(b7);


        setLayout(null);
        setSize(850,700);
        setLocation(320,60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
                new Deposit(pin);
                setVisible(false);
            }
            else if (e.getSource()==b7){
                System.exit(0); //to exit the program
            }else if (e.getSource()==b2){
                new Withdrawal(pin);
                setVisible(false);
            }else if (e.getSource()==b6){
                new Balance_Enquiry(pin);
                setVisible(false);
            }else if (e.getSource()==b3){
                new Fast_Cash(pin);
                setVisible(false);
            }else if (e.getSource()==b5){
                new Pin_change(pin);
                setVisible(false);
            }else if (e.getSource()==b4){
                new Mini_statement(pin);
                setVisible(false);

            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
