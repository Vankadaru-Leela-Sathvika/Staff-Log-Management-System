package Admin;

import Staff.Front_Page;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Admin_Dashboard implements ActionListener {

    JFrame f;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;

    Admin_Dashboard() {
        f = new JFrame("Admin Dashboard");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 1600, 900);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);
        f.setResizable(false);

        l2 = new JLabel("Staff Details");
        l2.setBounds(290, 20, 200, 40);
        l2.setFont(new Font("serif", Font.BOLD, 25));
        l2.setForeground(Color.white);
        l1.add(l2);

        b1 = new JButton("Create Staff Account");
        b1.setBounds(100, 80, 210, 40);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("Manage Staff Account");
        b2.setBounds(100, 140, 210, 40);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.addActionListener(this);
        l1.add(b2);

        b3 = new JButton("Add Salary Details");
        b3.setBounds(100, 200, 210, 40);
        b3.setFont(new Font("serif", Font.BOLD, 15));
        b3.addActionListener(this);
        l1.add(b3);

        b4 = new JButton("View Leave Requests");
        b4.setBounds(420, 80, 210, 40);
        b4.setFont(new Font("serif", Font.BOLD, 15));
        b4.addActionListener(this);
        l1.add(b4);

        b5 = new JButton("Manage Leave Requests");
        b5.setBounds(420, 140, 210, 40);
        b5.setFont(new Font("serif", Font.BOLD, 15));
        b5.addActionListener(this);
        l1.add(b5);

        b6 = new JButton("View All Staff Logs");
        b6.setBounds(420, 200, 210, 40);
        b6.setFont(new Font("serif", Font.BOLD, 15));
        b6.addActionListener(this);
        l1.add(b6);

        b7 = new JButton("logout");
        b7.setBounds(275, 300, 150, 40);
        b7.setFont(new Font("serif", Font.BOLD, 15));
        b7.addActionListener(this);
        l1.add(b7);

        f.setVisible(true);
        f.setSize(700, 500);
        f.setLocation(450, 200);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            new Add_Staff();
        }
        if (ae.getSource() == b2) {
            f.setVisible(false);
            new Manage_Staff();
        }
        if (ae.getSource() == b3) {
            f.setVisible(false);
            new Search_Staff();
        }
        if (ae.getSource() == b4) {
            f.setVisible(false);
            View_Leave_Requests frame = new View_Leave_Requests();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
        if (ae.getSource() == b5) {
            f.setVisible(false);
            Manage_Leave_Requests frame = new Manage_Leave_Requests();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
        if (ae.getSource() == b6) {
            f.setVisible(false);
            View_Staff_Logs frame = new View_Staff_Logs();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
        if (ae.getSource() == b7) {
            f.setVisible(false);
            new Front_Page();
        }
    }

    public static void main(String[] arg) {
        Admin_Dashboard d = new Admin_Dashboard();
    }
}
