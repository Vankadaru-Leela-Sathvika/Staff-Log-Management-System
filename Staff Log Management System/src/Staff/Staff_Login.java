package Staff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Staff_Login implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;

    Staff_Login() {

        f = new JFrame("Staff Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        f.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        f.add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        f.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        f.add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/avatar1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 20, 150, 150);
        f.add(l3);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);

        l3 = new JLabel("Don't have an accout?");
        l3.setBounds(110, 170, 200, 30);
        f.add(l3);

        b3 = new JButton("Register");
        b3.setBounds(110, 200, 120, 30);
        b3.setFont(new Font("serif", Font.BOLD, 15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        f.add(b3);

        b3.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(550, 300);
        f.setResizable(false);
        f.setLocation(400, 300);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                conn c1 = new conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from staff where email='" + u + "' and password='" + v + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    new Staff_Dashboard(rs.getString(1)).f.setVisible(true);
                    f.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    f.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            f.setVisible(false);
            new Front_Page();
        } else if (ae.getSource() == b3) {
            f.setVisible(false);
            new Register_Staff();
        }
    }

    public static void main(String[] arg) {
        Staff_Login l = new Staff_Login();
    }
}
