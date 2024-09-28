package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    String formno;
    JTextField tfr;
    JComboBox rel,cat,inc,edu,oc;
    JTextField tfpn,tfn;
    JRadioButton rb1,rb2,rb3,rb4;
    JButton next,reset, prev;
    JLabel label5;
    ButtonGroup bg, bg2;
    Signup2(String formno){
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

        this.formno = formno;
        JLabel labelf = new JLabel("APPLICATION FORM No. :"+formno);
        labelf.setFont(new Font("Cambria", Font.BOLD, 26));
        labelf.setBounds(240, 30, 600,40);
        add(labelf);

        //JLabel labelff = new JLabel(formno);
        //labelff.setFont(new Font("Cambria", Font.BOLD, 22));
        //labelff.setBounds(700, 10, 200,30);
        //add(labelff);

        JLabel label1 = new JLabel("Page 2/3");
        label1.setBounds(5,640,600,30);
        label1.setFont(new Font("Cambria", Font.BOLD, 14));
        add(label1);
        JLabel label2 = new JLabel("ADDITIONAL DETAILS");
        label2.setBounds(320,90,600,30);
        label2.setFont(new Font("Cambria", Font.BOLD, 22));
        add(label2);

        JLabel labelr = new JLabel("Religion : ");
        labelr.setFont(new Font("Cambria", Font.BOLD, 22));
        labelr.setBounds(100, 190, 200,30);
        add(labelr);

        String religion[] = {"Hindu", "Muslim", "Sikh","Christian","Other"}; //use combobox for dropdown
        rel = new JComboBox(religion);
        rel.setBackground(new Color(255,255,204));
        rel.setFont(new Font("Cambria",Font.BOLD,14));
        rel.setBounds(300,190,450,22);
        add(rel);

        JLabel labelc = new JLabel("Category : ");
        labelc.setFont(new Font("Cambria", Font.BOLD, 22));
        labelc.setBounds(100, 230, 200,30);
        add(labelc);

        String category[] = {"General", "OBC", "SC","ST","Other"}; //use combobox for dropdown
        cat = new JComboBox(category);
        cat.setBackground(new Color(255,255,204));
        cat.setFont(new Font("Cambria",Font.BOLD,14));
        cat.setBounds(300,230,450,22);
        add(cat);

        JLabel labeli = new JLabel("Income : ");
        labeli.setFont(new Font("Cambria", Font.BOLD, 22));
        labeli.setBounds(100, 270, 200,30);
        add(labeli);

        String income[] = {"Null", "<1,50,000", "<2,50,000","<5,00,000","<10,00,000","Above 10,00,000"}; //use combobox for dropdown
        inc = new JComboBox(income);
        inc.setBackground(new Color(255,255,204));
        inc.setFont(new Font("Cambria",Font.BOLD,14));
        inc.setBounds(300,270,450,22);
        add(inc);

        JLabel labele = new JLabel("Education : ");
        labele.setFont(new Font("Cambria", Font.BOLD, 22));
        labele.setBounds(100, 310, 200,30);
        add(labele);

        String education[] = {"12th pass/Diploma", "Graduate", "Post Graduate","Doctorate","Other"}; //use combobox for dropdown
        edu = new JComboBox(education);
        edu.setBackground(new Color(255,255,204));
        edu.setFont(new Font("Cambria",Font.BOLD,14));
        edu.setBounds(300,310,450,22);
        add(edu);

        JLabel labelo = new JLabel("Occupation : ");
        labelo.setFont(new Font("Cambria", Font.BOLD, 22));
        labelo.setBounds(100, 350, 200,30);
        add(labelo);

        String occ[] = {"Salaried", "Self Employed", "Business","Student","Retired", "Other"}; //use combobox for dropdown
        oc = new JComboBox(occ);
        oc.setBackground(new Color(255,255,204));
        oc.setFont(new Font("Cambria",Font.BOLD,14));
        oc.setBounds(300,350,450,22);
        add(oc);

        JLabel labelp = new JLabel("PAN Number : ");
        labelp.setFont(new Font("Cambria", Font.BOLD, 22));
        labelp.setBounds(100, 390, 200,30);
        add(labelp);

        tfpn = new JTextField();
        tfpn.setFont(new Font("Cambria", Font.BOLD, 14));
        tfpn.setBounds(300,390,445,30);
        add(tfpn);

        JLabel labeln = new JLabel("Aadhar Number: ");
        labeln.setFont(new Font("Cambria", Font.BOLD, 22));
        labeln.setBounds(100, 430, 200,30);
        add(labeln);

        tfn = new JTextField();
        tfn.setFont(new Font("Cambria", Font.BOLD, 14));
        tfn.setBounds(300,430,445,30);
        add(tfn);

        JLabel labelage = new JLabel("Senior Citizen: ");
        labelage.setFont(new Font("Cambria", Font.BOLD, 22));
        labelage.setBounds(100, 470, 200,30);
        add(labelage);

        rb1 = new JRadioButton("Yes");
        rb1.setFont(new Font("Cambria", Font.BOLD, 14));
        rb1.setBackground(new Color(252,208,76));
        rb1.setBounds(300,470,100,30);
        add(rb1);

        rb2 = new JRadioButton("No");
        rb2.setFont(new Font("Cambria", Font.BOLD, 14));
        rb2.setBackground(new Color(252,208,76));
        rb2.setBounds(400,470,100,30);
        add(rb2);
        bg = new ButtonGroup(); //so that when select 2nd, the 1st se automatically deselected
        bg.add(rb1);
        bg.add(rb2);

        JLabel labelacc = new JLabel("Existing Account: ");
        labelacc.setFont(new Font("Cambria", Font.BOLD, 22));
        labelacc.setBounds(100, 510, 200,30);
        add(labelacc);

        rb3 = new JRadioButton("Yes");
        rb3.setFont(new Font("Cambria", Font.BOLD, 14));
        rb3.setBackground(new Color(252,208,76));
        rb3.setBounds(300,510,100,30);
        add(rb3);

        rb4 = new JRadioButton("No");
        rb4.setFont(new Font("Cambria", Font.BOLD, 14));
        rb4.setBackground(new Color(252,208,76));
        rb4.setBounds(400,510,100,30);
        add(rb4);

        bg2 = new ButtonGroup(); //so that when select 2nd, the 1st se automatically deselected
        bg2.add(rb4);
        bg2.add(rb3);


        next = new JButton("Submit");
        next.setFont(new Font("Cambria", Font.BOLD, 16));
        next.setBounds(270, 600, 100,30);
        next.setOpaque(true);
        next.setBackground(Color.GRAY);
        next.addActionListener(this);
        add(next);

        reset = new JButton("Reset");
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
        String religion = (String)rel.getSelectedItem();
        String category = (String)cat.getSelectedItem();
        String income = (String)inc.getSelectedItem();
        String education = (String)edu.getSelectedItem();
        String occupation = (String)oc.getSelectedItem();
        String pan = tfpn.getText();
        String aad = tfn.getText();
        String sc = null;
        if (rb1.isSelected()){sc= "Yes";}
        else if (rb2.isSelected()){sc=  "No"; }
        String ec = null;
        if (rb3.isSelected()){ec= "Yes";}
        else if (rb4.isSelected()){ec=  "No"; }
        try{
            if (e.getSource()==reset){
                rel.setSelectedIndex(0);
                cat.setSelectedIndex(0);
                inc.setSelectedIndex(0);
                edu.setSelectedIndex(0);
                oc.setSelectedIndex(0);
                tfpn.setText("");
                tfn.setText("");
                bg.clearSelection();
                bg2.clearSelection();
            }
            else if (e.getSource()==prev){
                new Signup();
                setVisible(false);
            }
            else if (tfpn.getText().equals("") || tfn.getText().equals("")){ //use empty string not " "
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else{
                Con c1 = new Con();
                String q = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aad+"','"+sc+"','"+ec+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2(""); //object created
    }
}
