package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    String formno;
    JRadioButton rb1,rb2,rb3,rb4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton next,reset, prev;
    JLabel label5;
    Signup3(String formno){
        super("NEW REGISTRATION");
        this.formno = formno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel labelf = new JLabel("APPLICATION FORM No. :"+formno);
        labelf.setFont(new Font("Cambria", Font.BOLD, 26));
        labelf.setBounds(240, 30, 600,40);
        add(labelf);

        label5 = new JLabel("⫸ℬℴⅈ");
        label5.setForeground(new Color(255,51,51));//set color of our text
        label5.setFont(new Font("Cambria", Font.BOLD, 20));
        label5.setBounds(780,10,100,20);//dist from x,y axis of the frame border
        add(label5);

        //JLabel labelfo = new JLabel(formno);
        //labelfo.setFont(new Font("Ariel", Font.BOLD, 14));
        //labelfo.setBounds(700, 10, 200,30);
        //add(labelfo);

        JLabel label1 = new JLabel("Page 3/3");
        label1.setBounds(5,640,600,30);
        label1.setFont(new Font("Cambria", Font.BOLD, 14));
        add(label1);

        JLabel label2 = new JLabel("ACCOUNT DETAILS");
        label2.setBounds(320,90,600,30);
        label2.setFont(new Font("Cambria", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Account type : ");
        label3.setFont(new Font("Cambria", Font.BOLD, 22));
        label3.setBounds(120, 180, 200,30);
        add(label3);

        rb1 = new JRadioButton("Saving account");
        rb1.setFont(new Font("Cambria", Font.BOLD, 14));
        rb1.setBackground(new Color(252,208,76));
        rb1.setBounds(120,210,200,30);
        add(rb1);

        rb2 = new JRadioButton("Fixed deposit");
        rb2.setFont(new Font("Cambria", Font.BOLD, 14));
        rb2.setBackground(new Color(252,208,76));
        rb2.setBounds(320,210,200,30);
        add(rb2);

        rb3 = new JRadioButton("Current account");
        rb3.setFont(new Font("Cambria", Font.BOLD, 14));
        rb3.setBackground(new Color(252,208,76));
        rb3.setBounds(120,240,200,30);
        add(rb3);

        rb4 = new JRadioButton("Recurring deposit account");
        rb4.setFont(new Font("Cambria", Font.BOLD, 14));
        rb4.setBackground(new Color(252,208,76));
        rb4.setBounds(320,240,300,30);
        add(rb4);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);

        JLabel label4 = new JLabel("Card Number : ");
        label4.setFont(new Font("Cambria", Font.BOLD, 22));
        label4.setBounds(120, 290, 200,30);
        add(label4);

        JLabel label5 = new JLabel("(Your 16-digit card Number)");
        label5.setFont(new Font("Cambria", Font.BOLD, 12));
        label5.setBounds(120, 315, 400,30);
        add(label5);

        JLabel label6 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        label6.setFont(new Font("Cambria", Font.BOLD, 22));
        label6.setBounds(320, 290, 400,30);
        add(label6);

        JLabel label7 = new JLabel("(Would appear in passbook and chequebook)");
        label7.setFont(new Font("Cambria", Font.BOLD, 12));
        label7.setBounds(320, 315, 400,30);
        add(label7);

        JLabel label8 = new JLabel("PIN : ");
        label8.setFont(new Font("Cambria", Font.BOLD, 22));
        label8.setBounds(120, 355, 200,30);
        add(label8);
        JLabel label9 = new JLabel("****");
        label9.setFont(new Font("Cambria", Font.BOLD, 22));
        label9.setBounds(320, 355, 200,30);
        add(label9);
        JLabel label10 = new JLabel("(4-digit password)");
        label10.setFont(new Font("Cambria", Font.BOLD, 12));
        label10.setBounds(120, 380, 200,30);
        add(label10);

        JLabel label11 = new JLabel("Services : ");
        label11.setFont(new Font("Cambria", Font.BOLD, 22));
        label11.setBounds(120, 415, 200,30);
        add(label11);

        c1 = new JCheckBox("ATM card");
        c1.setBackground(new Color(200,200,200));
        c1.setFont(new Font("Cambria",Font.BOLD, 16));
        c1.setBounds(120,450,200,30);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(200,200,200));
        c2.setFont(new Font("Cambria",Font.BOLD, 16));
        c2.setBounds(320,450,200,30);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(200,200,200));
        c3.setFont(new Font("Cambria",Font.BOLD, 16));
        c3.setBounds(520,450,200,30);
        add(c3);
        c4 = new JCheckBox("Chequebook");
        c4.setBackground(new Color(200,200,200));
        c4.setFont(new Font("Cambria",Font.BOLD, 16));
        c4.setBounds(120,480,200,30);
        add(c4);
        c5 = new JCheckBox("email Alerts");
        c5.setBackground(new Color(200,200,200));
        c5.setFont(new Font("Cambria",Font.BOLD, 16));
        c5.setBounds(320,480,200,30);
        add(c5);
        c6 = new JCheckBox("E-statement");
        c6.setBackground(new Color(200,200,200));
        c6.setFont(new Font("Cambria",Font.BOLD, 16));
        c6.setBounds(520,480,200,30);
        add(c6);
        c7 = new JCheckBox("I hereby declare that the above entered details are true to the best of my knowledge",true);//true taaki hamesha checked rahe
        c7.setBackground(new Color(200,200,200));
        c7.setFont(new Font("Cambria",Font.BOLD, 12));
        c7.setBounds(120,540,1000,30);
        add(c7);


        next = new JButton("Submit");
        next.setFont(new Font("Cambria", Font.BOLD, 16));
        next.setBounds(270, 600, 100,30);
        next.setOpaque(true);
        next.setBackground(Color.GRAY);
        next.addActionListener(this);
        add(next);

        reset = new JButton("Cancel");
        reset.setFont(new Font("Cambria", Font.BOLD, 16));
        reset.setBounds(390, 600, 100,30);
        reset.setOpaque(true);
        reset.setBackground(Color.GRAY);
        reset.addActionListener(this);
        add(reset);

        prev = new JButton("Previous");
        prev.setFont(new Font("Cambria", Font.BOLD, 16));
        prev.setBounds(510, 600, 100,30);
        prev.setOpaque(true);
        prev.setBackground(Color.GRAY);
        prev.addActionListener(this);
        add(prev);

        setLayout(null);
        getContentPane().setBackground(new Color(252, 243, 230));
        setSize(850,700);
        setLocation(320,60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (rb1.isSelected()){atype = "Saving account";}
        else if (rb2.isSelected()){atype = "Fixed deposit";}
        else if (rb3.isSelected()){atype = "Current account";}
        else if (rb4.isSelected()){atype = "Recurring deposit account";}
        Random ran = new Random();
        long first = (ran.nextLong()%90000000L)+4591263000000000L;
        String cardno = "" + Math.abs(first);

        long first3 = (ran.nextLong()%9000L)+1000L;
        String pin = "" + Math.abs(first3);

        String fac = "";
        if(c1.isSelected()){fac += "ATM Card";}
        else if (c2.isSelected()){fac += "Internet Banking";}
        else if (c3.isSelected()){fac += "Mobile Banking";}
        else if (c4.isSelected()){fac += "Chequebook";}
        else if (c5.isSelected()){fac += "email Alerts";}
        else if (c6.isSelected()){fac += "E-statement";}

        try{
            if (e.getSource()==next){
                if (atype.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else{
                    Con c1 = new Con();
                    String q1 = "insert into signup3 values('"+formno+"', '"+atype+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String q2 = "insert into login values('"+formno+"', '"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card number :"+cardno+ "\n Pin:"+pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            }
            else if (e.getSource()==reset){
                System.exit(0);//exit from system
            }else if (e.getSource()==prev){
                new Signup2(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3(" ");
    }
}
