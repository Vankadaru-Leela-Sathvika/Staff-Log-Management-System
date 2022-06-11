package Admin;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Add_Salary_Details implements ActionListener {

    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id15, lab, lab1;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JButton b, b1, b2, b3;
    String staffid;
    String dailywage, bonus;
    String adminid;
    public Add_Salary_Details(String staffid,String adminid) {
        this.staffid = staffid;
        this.adminid=adminid;
        try {
            conn con = new conn();
            String str = "select * from salary where staffid = '" + staffid + "'";
            ResultSet rs = con.s.executeQuery(str);

            if (rs.next()) {
                this.dailywage = String.valueOf(rs.getInt(2));
                this.bonus = String.valueOf(rs.getInt(3));
            }
        } catch (Exception ex) {
        }
        f = new JFrame("Add Salary Details");
        f.setIconImage(new ImageIcon("icons/icon.png").getImage());
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setResizable(false);
        f.pack();
        id15 = new JLabel();
        id15.setBounds(0, 0, 1366, 768);
        id15.setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        id15.setIcon(imageIcon);

        id8 = new JLabel("Add Salary Details");
        id8.setBounds(350, 30, 500, 50);
        id8.setFont(new Font("serif", Font.BOLD, 25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id3 = new JLabel("Staff ID");
        id3.setBounds(50, 100, 100, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id3);

        t3 = new JTextField(staffid);
        t3.setEditable(false);
        t3.setBounds(200, 100, 150, 30);
        id15.add(t3);

        id1 = new JLabel("Daily Wage");
        id1.setBounds(50, 200, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id1);

        t1 = new JTextField(this.dailywage);
        t1.setBounds(200, 200, 150, 30);
        id15.add(t1);

        id2 = new JLabel("Bonus");
        id2.setBounds(400, 200, 200, 30);
        id2.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id2);

        t2 = new JTextField(this.bonus);
        t2.setBounds(600, 200, 150, 30);
        id15.add(t2);

        b = new JButton("update");
        b.setBounds(250, 400, 100, 30);
        b.addActionListener(this);
        id15.add(b);

        b1 = new JButton("Cancel");
        b1.setBounds(450, 400, 100, 30);
        b1.addActionListener(this);
        id15.add(b1);

        f.setVisible(true);
        f.setSize(900, 700);
        f.setLocation(400, 150);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
            try {
                conn con = new conn();
                String str1 = "insert into salary values('" + staffid + "',0,0);";
                con.s.executeUpdate(str1);
                String str = "update salary set dailywage='" + t1.getText() + "',bonus='" + t2.getText() + "' where staffid='" + staffid + "'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "successfully updated");
                f.setVisible(false);
                new Admin_Dashboard(adminid);
            } catch (Exception e) {
                System.out.println("The error is:" + e);
            }
        }
        if (ae.getSource() == b1) {
            f.setVisible(false);
            Admin_Dashboard d = new Admin_Dashboard(adminid);
        }
    }

    public static void main(String[] arg) {
        new Add_Salary_Details("stafftrial","adminid001");
    }
}
