package bank .management.system;

import javax.swing.*;//jframe comes in swing package
import java.awt.*; //imported for image use
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //for putting events on buttons implement ActionListener in this package
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5; //declared globally
    JTextField tf2;
    JPasswordField pf3;
    JButton button1, button2, button3;
    Login(){
        super("Bank Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Login.png")); //give url of image since already in src give icon ke baad ka address, now image is stored in i1
        Image i2 = i1.getImage().getScaledInstance(415,470, Image.SCALE_DEFAULT); //to scale image i1
        ImageIcon i3 = new ImageIcon(i2); //to make image visible on frame but cant directly take image to frame, need label
        JLabel image = new JLabel(i3);
        image.setBounds(5,5,415, 470);
        add(image); 


        label1 = new JLabel("\uD83C\uDFE6 BANK OF INDIA"); //to show any text on our frame
        label1.setForeground(new Color(51,153,255));//set color of our text
        label1.setFont(new Font("Cambria", Font.BOLD, 30));
        label1.setBounds(490,60,400,40);//dist from x,y axis of the frame border
        add(label1);

        label4 = new JLabel("INTERNET BANKING"); //to show any text on our frame
        label4.setForeground(new Color(51,153,255));//set color of our text
        label4.setFont(new Font("Cambria", Font.BOLD, 20));
        label4.setBounds(540,115,400,40);//dist from x,y axis of the frame border
        add(label4);

        label5 = new JLabel("⫸ℬℴⅈ");
        label5.setForeground(new Color(255,51,51));//set color of our text
        label5.setFont(new Font("Cambria", Font.BOLD, 20));
        label5.setBounds(780,10,100,20);//dist from x,y axis of the frame border
        add(label5);


        label2 = new JLabel("CARD NUMBER");
        label2.setFont(new Font("Cambria", Font.BOLD, 20));
        label2.setForeground(new Color(51,153,255));
        label2.setBounds(450,190,170,30);
        add(label2);

        tf2 = new JTextField(15); //text infront of label2/cardno
        tf2.setBounds(630,190,210,30);//by default color is black
        tf2.setFont(new Font("Cambria", Font.BOLD, 14));
        tf2.setForeground(Color.BLACK);
        //tf2.setBackground(new Color(255,253,208));
        add(tf2);

        label3 = new JLabel("4-DIGIT PIN");
        label3.setForeground(new Color(51,153,255));
        label3.setFont(new Font("Cambria", Font.BOLD, 20));
        label3.setBounds(450,250,170,30);
        add(label3);

        pf3 = new JPasswordField(15);//when type then dot dot visible not actually password so not use text field
        pf3.setFont(new Font("Ariel", Font.BOLD, 14));
        pf3.setBounds(630, 250, 210, 30);
        pf3.setForeground(Color.BLACK);
        //pf3.setBackground(new Color(255,253,208));
        add(pf3);

        button1 = new JButton("LOGIN");
        button1.setFont(new Font("Cambria", Font.BOLD, 15));
        button1.setBounds(540,350,100,30);
        button1.setBackground(new Color(255,253,208)); //bckgrnd of button
        button1.setForeground(new Color(51,153,255));
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("RESET");
        button2.setFont(new Font("Cambria", Font.BOLD, 15));
        button2.setBounds(650,350,100,30);
        button2.setForeground(new Color(51,153,255));
        button2.setBackground(new Color(255,253,208));
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("NEW USER? REGISTER HERE");
        button3.setFont(new Font("Cambria", Font.BOLD, 15));
        button3.setBounds(510,400,280,30);
        button3.setForeground(new Color(51,153,255));
        button3.setBackground(new Color(255,253,208));
        button3.addActionListener(this);
        add(button3);


        //getContentPane().setBackground(new Color(255,253,208));
        getContentPane().setBackground(new Color(252, 243, 230));
        setLayout(null); //to remove default setup and put our own
        setSize(850,480); //of our frame
        setLocation(300,200); //shift from left and top kitne points
        setUndecorated(true); //remove full screen , X ka option etc
        setVisible(true); //as by default the frame is not visible, should be sabse neeche, jo visible karvana hai wo sab iske upar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == button1){ //whichever button the user clicks gets stored in ActionEvent e now check kaunsa button
                Con c = new Con();
                String cardno = tf2.getText();
                String pin = pf3.getText();
                String q = "select * from login where Card_no='"+cardno+"' and Pin = '"+pin+"' ";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new Transaction(pin);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
                }
            }
            else if (e.getSource()==button2){
                tf2.setText(""); //pass empty string to clear both fields
                pf3.setText("");
            }
            else if (e.getSource()==button3){
                new Signup();
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace(); //to make error visible
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
