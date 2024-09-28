package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField tf1;
    JButton b1,b2;
    JLabel label5, label1;
    Deposit(String pin){
        super("Deposit");
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 690, Image.SCALE_DEFAULT);
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

        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("Cambria",Font.BOLD, 16));
        l1.setBounds(170,220,400,35);
        i4.add(l1); //to add it above the image

        tf1 = new TextField();
        tf1.setBackground(new Color(65,125,128));
        //tf1.setBackground(new Color(255,255,204));
        tf1.setForeground(Color.WHITE);
        tf1.setBounds(170,260,320,25);
        tf1.setFont(new Font("Cambria",Font.BOLD,16));
        i4.add(tf1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(380,350,150,25);
        //b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBackground(new Color(65,125,128));
        b1.addActionListener(this);
        i4.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(380,380,150,25);
        b2.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.addActionListener(this);
        i4.add(b2);

        setLayout(null);
        setSize(850,700);
        setLocation(320,60);//full screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = tf1.getText();
        Date date = new Date();
        try{
            if (e.getSource()==b1){
                if (tf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
                }
                else{
                    Con c1 = new Con();
                    c1.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Deposit', '"+amount+"')");
                    //deposit will be stored as it is in type column
                    JOptionPane.showMessageDialog(null,"Rs."+amount+" deposited successfully");
                    setVisible(false);
                    new Transaction(pin);
                }
            }else if (e.getSource()==b2){
                setVisible(false); //will now go to main screen
                new Transaction(pin);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
