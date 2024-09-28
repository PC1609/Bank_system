package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin_change extends JFrame implements ActionListener {
    String pin;
    JButton b1,b2;
    JPasswordField pf1,pf2;

    Pin_change(String pin){
        super("Pin change");
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

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("Cambria",Font.BOLD, 16));
        l1.setBounds(170,220,400,35);
        i4.add(l1); //to add it above the image

        JLabel l2 = new JLabel("New PIN");
        l2.setFont(new Font("Cambria",Font.BOLD, 16));
        l2.setBounds(165,260,150,35);
        i4.add(l2); //to add it above the image

        pf1 = new JPasswordField(15);
        pf1.setBackground(new Color(65,125,128));
        //tf1.setBackground(new Color(255,255,204));
        pf1.setForeground(Color.WHITE);
        pf1.setFont(new Font("Cambria", Font.BOLD, 14));
        pf1.setBounds(340, 260, 150, 25);
        i4.add(pf1);

        JLabel l3 = new JLabel("Re-enter New PIN");
        l3.setFont(new Font("Cambria",Font.BOLD, 16));
        l3.setBounds(165,290,400,35);
        i4.add(l3); //to add it above the image

        pf2 = new JPasswordField(15);
        pf2.setBackground(new Color(65,125,128));
        //tf1.setBackground(new Color(255,255,204));
        pf2.setForeground(Color.WHITE);
        pf2.setFont(new Font("Cambria", Font.BOLD, 14));
        pf2.setBounds(340, 290, 150, 25);
        i4.add(pf2);

        b1 = new JButton("PIN CHANGE");
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
        setLocation(320,60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = pf1.getText();
            String pin2 = pf2.getText();
            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null, "Entered pin do not match");
                return;
            }
            if (e.getSource()==b1){
                if (pf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter a pin");
                    return;
                }
                if (pf2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-enter the pin");
                    return; //else code aage chala jayega
                }
                Con c = new Con();
                //we have stored pin in 3tables
                String q1 = "update bank set pin= '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin= '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signup3 set pin= '"+pin1+"' where pin = '"+pin+"'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Pin changed successfully");
                setVisible(false);
                new Login();
            }else if (e.getSource()==b2){
                new Login();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin_change(" ");
    }
}
