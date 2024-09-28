package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_Cash extends JFrame implements ActionListener {
    String pin;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JLabel label5,label1;
    Fast_Cash(String pin){
        super("Fast Cash");
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

        JLabel l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setFont(new Font("Cambria",Font.BOLD, 16));
        l1.setBounds(170,220,700,35);
        i4.add(l1);

        b1 = new JButton("Rs. 100");
        b1.setBounds(160,300,150,25);
        //b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBackground(new Color(65,125,128));
        b1.addActionListener(this);
        i4.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setBounds(380,300,150,25);
        b2.setOpaque(true);
        b2.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        i4.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setBounds(160,325,150,25);
        //b1.setForeground(Color.WHITE);
        b3.setOpaque(true);
        b3.setBackground(new Color(65,125,128));
        b3.addActionListener(this);
        i4.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setBounds(380,325,150,25);
        b4.setOpaque(true);
        b4.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b4.addActionListener(this);
        i4.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setBounds(160,350,150,25);
        //b1.setForeground(Color.WHITE);
        b5.setOpaque(true);
        b5.setBackground(new Color(65,125,128));
        b5.addActionListener(this);
        i4.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setBounds(380,350,150,25);
        b6.setOpaque(true);
        b6.setBackground(new Color(65,125,128));
        //b2.setForeground(Color.WHITE);
        b6.addActionListener(this);
        i4.add(b6);

        b7 = new JButton("BACK");
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
        if (e.getSource()==b7){
            new Transaction(pin);
            setVisible(false);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Con c = new Con();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin ='"+pin+"'"); //to fetch data frm table
                int balance = 0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                String num = "17";
                if(e.getSource()!=b7 && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                //to store data in table now
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" debited successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new Transaction(pin);
        }
    }

    public static void main(String[] args) {
        new Fast_Cash("");
    }
}
