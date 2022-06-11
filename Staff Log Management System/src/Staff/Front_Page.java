package Staff;

import Admin.Admin_Login;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Front_Page implements ActionListener {

    JFrame f; //declaration
    JLabel id, l1;
    JButton b, b1;

    public Front_Page() {

        f = new JFrame("Staff Logs Management System");
        f.setBounds(0, 0, 1600, 900);
        f.setSize(1600, 900);
        f.setBackground(Color.red);
        f.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0, 0, 1600, 900);
        f.add(l1);

        b = new JButton("Admin");
        b.setBounds(600, 200, 300, 70);
        b.setFont(new Font("serif", Font.BOLD, 15));
        b.addActionListener(this);

        b1 = new JButton("Staff");
        b1.setBounds(600, 300, 300, 70);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);

        id = new JLabel();
        id.setBounds(0, 0, 1600, 900);
        id.setLayout(null);

        JLabel lid = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(80, 30, 1500, 100);
        lid.setFont(new Font("calibri", Font.PLAIN, 70));
        lid.setForeground(Color.BLACK);
        id.add(lid);
        l1.add(b);
        l1.add(b1);
        f.add(id);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1360, 750);
        f.setLocation(50, 50);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b) {
            f.setVisible(false);
            new Admin_Login();
        }
        if (ae.getSource() == b1) {
            f.setVisible(false);
            new Staff_Login();
        }
    }

    public static void main(String[] arg) {
        Front_Page f = new Front_Page();
        
    }
}
