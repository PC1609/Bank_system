package bank.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini_statement extends JFrame implements ActionListener {
    String pin;
    JButton b1;
    JLabel label1, label5;
    Mini_statement(String pin){
        super("Mini statement");
        this.pin = pin;

        label5 = new JLabel("⫸ℬℴⅈ");
        label5.setForeground(new Color(255,51,51));//set color of our text
        label5.setFont(new Font("Cambria", Font.BOLD, 20));
        label5.setBounds(330,10,100,20);//dist from x,y axis of the frame border
        add(label5);

        JLabel l1 = new JLabel();
        l1.setBounds(20,140,400,100);
        add(l1);
        JLabel l2 = new JLabel();
        l2.setFont(new Font("Cambria ",Font.BOLD, 15));
        l2.setBounds(150,20,200,20);
        add(l2);
        JLabel l3 = new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);
        JLabel l4 = new JLabel();
        l4.setBounds(20,400,300,20);
        add(l4);

        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from login where Pin = '"+pin+"'");
            //ResultSet rs = c.statement.executeQuery("select * from signup where form_no = '"+resultSet.getString("form_no")+"'");
            //if (rs.next()){
                //l2.setText(rs.getString("Name"));
            //}
            while (resultSet.next()){
                l3.setText("Card Number : "+ resultSet.getString("Card_no").substring(0,4)+"XXXXXXXX"+resultSet.getString("Card_no").substring(12));
            }

        }catch (Exception E){
            E.printStackTrace();
        }
        try{
            int balance = 0;
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                l1.setText(l1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount")+"<br><br><html>");
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            l4.setText("Your total balance is Rs. "+balance);
        }catch (Exception E){
            E.printStackTrace();
        }

        b1 = new JButton("Exit");
        b1.setBounds(20,600,100,25);
        //b1.setForeground(Color.WHITE);
        //b1.setBackground(Color.BLACK);
        b1.setOpaque(true);
        b1.setBackground(new Color(65,125,128));
        b1.addActionListener(this);
        add(b1);

        setLayout(null);
        setSize(400,700);
        setLocation(20,20);
        getContentPane().setBackground(new Color(255,204,204));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini_statement("");
    }
}
