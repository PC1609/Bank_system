package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JDateChooser dateChooser; //import upar wala Jdatechooser and should have a jar file in library
    Random ran = new Random(); //for random applictn no
    long first4 = (ran.nextLong()% 9000L) + 1000L; //9000L tak ka produces a random integer btw 0 to 8999, +1000 se btw 1000 and 9999
    //ran.nextLong produces a random long integer value using ran object
    String first = " " + Math.abs(first4);

    JTextField tfname, tffname, tmail, tadd, tcity, tpin, tstate; //declare globally as need to later on extract data from here and store
    JRadioButton rb1, rb2, rb3; // for gender box
    JRadioButton m1, m2, m3, m4;// for marital status
    JButton next, reset;
    JLabel label5;
    ButtonGroup bgm,bg;

    Signup(){
        super("NEW REGISTRATION");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        label5 = new JLabel("⫸ℬℴⅈ");
        label5.setForeground(new Color(255,51,51));//set color of our text
        label5.setFont(new Font("Cambria", Font.BOLD, 20));
        label5.setBounds(780,10,100,20);//dist from x,y axis of the frame border
        add(label5);

        JLabel label1 = new JLabel("APPLICATION FORM NO. :" + first);
        label1.setBounds(240,30,600,40);
        label1.setFont(new Font("Cambria", Font.BOLD, 26));
        add(label1);

        JLabel label2 = new JLabel("Page 1/3");
        label2.setBounds(5,640,600,30);
        label2.setFont(new Font("Cambria", Font.BOLD, 14));
        add(label2);

        JLabel label3 = new JLabel("PERSONAL DETAILS");
        label3.setBounds(320,90,600,30);
        label3.setFont(new Font("Cambria", Font.BOLD, 22));
        add(label3);

        JLabel labelname = new JLabel("Name : ");
        labelname.setFont(new Font("Cambria", Font.BOLD, 22));
        labelname.setBounds(100, 190, 200,30);
        add(labelname);

        tfname = new JTextField();
        tfname.setFont(new Font("Cambria", Font.BOLD, 14));
        tfname.setBounds(300,190,450,30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name : ");
        labelfname.setFont(new Font("Cambria", Font.BOLD, 22));
        labelfname.setBounds(100, 230, 200,30);
        add(labelfname);

        tffname = new JTextField();
        tffname.setFont(new Font("Cambria", Font.BOLD, 14));
        tffname.setBounds(300,230,450,30);
        add(tffname);

        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Cambria", Font.BOLD, 22));
        dob.setBounds(100, 270, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,270,430,30);
        add(dateChooser);

        JLabel g = new JLabel("Gender : ");
        g.setFont(new Font("Cambria", Font.BOLD, 22));
        g.setBounds(100,310, 200, 30);
        add(g);

        rb1 = new JRadioButton("Male");
        rb1.setFont(new Font("Cambria", Font.BOLD, 14));
        rb1.setBounds(300,310,100,30);
        add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setFont(new Font("Cambria", Font.BOLD, 14));
        rb2.setBounds(400,310,100,30);
        add(rb2);

        rb3 = new JRadioButton("Other");
        rb3.setFont(new Font("Cambria", Font.BOLD, 14));
        rb3.setBounds(500,310,100,30);
        add(rb3);

        bg = new ButtonGroup(); //so that when select 2nd, the 1st se automatically deselected
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        JLabel lmail = new JLabel("Email Address : ");
        lmail.setBounds(100, 350,200,30);
        lmail.setFont(new Font("Cambria", Font.BOLD, 22));
        add(lmail);

        tmail = new JTextField();
        tmail.setBounds(300,350,450,30);
        tmail.setFont(new Font("Cambria", Font.BOLD, 14));
        add(tmail);

        JLabel married = new JLabel("Marital Status : ");
        married.setBounds(100, 390,200,30);
        married.setFont(new Font("Cambria", Font.BOLD, 22));
        add(married);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Cambria", Font.BOLD, 14));
        m1.setBounds(300,390,100,30);
        add(m1);

        m2 = new JRadioButton("Single");
        m2.setFont(new Font("Cambria", Font.BOLD, 14));
        m2.setBounds(400,390,100,30);
        add(m2);

        m3 = new JRadioButton("Widow");
        m3.setFont(new Font("Cambria", Font.BOLD, 14));
        m3.setBounds(500,390,100,30);
        add(m3);

        m4 = new JRadioButton("Divorced");
        m4.setFont(new Font("Cambria", Font.BOLD, 14));
        m4.setBounds(600,390,100,30);
        add(m4);

        bgm = new ButtonGroup(); //so that when select 2nd, the 1st se automatically deselected
        bgm.add(m1);
        bgm.add(m2);
        bgm.add(m3);
        bgm.add(m4);

        JLabel ladd = new JLabel("Address : ");
        ladd.setBounds(100, 430,200,30);
        ladd.setFont(new Font("Cambria", Font.BOLD, 22));
        add(ladd);

        tadd = new JTextField();
        tadd.setBounds(300,430,450,30);
        tadd.setFont(new Font("Cambria", Font.BOLD, 14));
        add(tadd);

        JLabel city = new JLabel("City : ");
        city.setBounds(100, 470,200,30);
        city.setFont(new Font("Cambria", Font.BOLD, 22));
        add(city);

        tcity = new JTextField();
        tcity.setBounds(300,470,450,30);
        tcity.setFont(new Font("Cambria", Font.BOLD, 14));
        add(tcity);

        JLabel pin = new JLabel("Pin Code : ");
        pin.setBounds(100, 510,200,30);
        pin.setFont(new Font("Cambria", Font.BOLD, 22));
        add(pin);

        tpin = new JTextField();
        tpin.setBounds(300,510,450,30);
        tpin.setFont(new Font("Cambria", Font.BOLD, 14));
        add(tpin);

        JLabel state = new JLabel("State : ");
        state.setBounds(100, 550,200,30);
        state.setFont(new Font("Cambria", Font.BOLD, 22));
        add(state);

        tstate = new JTextField();
        tstate.setBounds(300,550,450,30);
        tstate.setFont(new Font("Cambria", Font.BOLD, 14));
        add(tstate);

        next = new JButton("Submit");
        next.setFont(new Font("Cambria", Font.BOLD, 16));
        next.setBounds(340, 620, 100,30);
        next.setOpaque(true);
        next.setBackground(Color.GRAY);
        next.addActionListener(this);
        add(next);

        reset = new JButton("Reset");
        reset.setFont(new Font("Cambria", Font.BOLD, 16));
        reset.setBounds(460, 620, 100,30);
        reset.setOpaque(true);
        reset.setBackground(Color.GRAY);
        reset.addActionListener(this);
        add(reset);

        //getContentPane().setBackground(new Color(222,255,228)); //set color of bckgrnd than image this time
        getContentPane().setBackground(new Color(252, 243, 230));
        setLayout(null);
        setSize(850,700);
        setLocation(320, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first; //if etc needed as only button is next toh ye sab jab select next
        String name = tfname.getText();
        String fname = tffname.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (rb1.isSelected()){gender = "Male";}
        else if(rb2.isSelected()){gender = "Female";}
        else if (rb3.isSelected()){gender = "Third gender";}
        String email = tmail.getText();
        String marital = null;
        if (m1.isSelected()){marital = "Married";}
        else if (m2.isSelected()){marital = "Single";}
        else if (m3.isSelected()){marital = "Widow";}
        else if (m4.isSelected()){marital = "Divorced";}
        String address = tadd.getText();
        String city = tcity.getText();
        String pin = tpin.getText();
        String state = tstate.getText();


        try{
            if (e.getSource()==reset){
                tfname.setText("");
                tffname.setText("");
                tpin.setText("");
                tmail.setText("");
                tadd.setText("");
                tcity.setText("");
                tstate.setText("");
                bg.clearSelection();
                bgm.clearSelection();
            }
            else if (tfname.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else {
                Con con1 = new Con();
                String q = "insert into signup values('"+formno+"','"+name+"', '"+fname+"', '"+dob+"','"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                //we have made a query, now need to execute it: make in order of columns in mysql
                con1.statement.executeUpdate(q); //executeUpdate when add data into table
                new Signup2(formno); //new class will be open
                setVisible(false); //to close present class
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Signup();
    }
}
