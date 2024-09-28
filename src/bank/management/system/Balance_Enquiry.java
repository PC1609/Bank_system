package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance_Enquiry extends JFrame implements ActionListener {
    String pin;
    JLabel l2;
    JButton b1;
    Balance_Enquiry(String pin){
        super("Balance Enquiry");
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,850,700);
        add(i4);

        JLabel label1 = new JLabel("ATM");
        label1.setForeground(Color.BLACK);//set color of our text
        label1.setFont(new Font("Impact", Font.BOLD, 35));
        label1.setBounds(320,90,100,35);//dist from x,y axis of the frame border
        i4.add(label1);

        JLabel label5 = new JLabel("⫸ℬℴⅈ");
        label5.setForeground(new Color(255,51,51));//set color of our text
        label5.setFont(new Font("Cambria", Font.BOLD, 20));
        label5.setBounds(780,10,100,20);//dist from x,y axis of the frame border
        i4.add(label5);

        JLabel l1 = new JLabel("YOUR CURRENT BALANCE IS : ");
        l1.setFont(new Font("Cambria",Font.BOLD, 16));
        l1.setBounds(170,220,700,35);
        i4.add(l1); //to add it above the image

        l2 = new JLabel(); //used to store curr balance
        l2.setFont(new Font("Cambria",Font.ITALIC, 16));
        l2.setBounds(190,250,400,35);
        i4.add(l2); //to add it above the image

        b1 = new JButton("BACK");
        b1.setBounds(380,360,150,25);
        //b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBackground(new Color(65,125,128));
        b1.addActionListener(this);
        i4.add(b1);

        int balance = 0;

        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        l2.setText("Rs." + balance);//convert into string

        setLayout(null);
        setSize(850,700);
        setLocation(320,60);//no full screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pin);
    }

    public static void main(String[] args) {
        new Balance_Enquiry("");
    }
}
