package Admin;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class Add_Staff implements ActionListener {

    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13, id14, id15, id16, id17, lab, lab1;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    JButton b, b1, b2, b3;

    Add_Staff(int i) {
    }

    Add_Staff() {
        f = new JFrame("ADD STAFF");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setResizable(false);
        f.pack();
        id15 = new JLabel();
        id15.setBounds(0, 0, 1366, 768);
        id15.setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(800, 1000, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        id15.setIcon(imageIcon);

        id8 = new JLabel("New Staff Details");
        id8.setBounds(350, 30, 500, 50);
        id8.setFont(new Font("serif", Font.BOLD, 25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id1 = new JLabel("staffid");
        id1.setBounds(50, 150, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id1);

        t1 = new JTextField();
        t1.setBounds(200, 150, 150, 30);
        id15.add(t1);

        id3 = new JLabel("First Name");
        id3.setBounds(50, 200, 100, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id3);

        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 30);
        id15.add(t3);

        id4 = new JLabel("Last Name");
        id4.setBounds(400, 200, 200, 30);
        id4.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id4);

        t4 = new JTextField();
        t4.setBounds(600, 200, 150, 30);
        id15.add(t4);

        id5 = new JLabel("Gender");
        id5.setBounds(50, 250, 100, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id5);

        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 30);
        id15.add(t5);

        id6 = new JLabel("Age");
        id6.setBounds(400, 250, 100, 30);
        id6.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id6);

        t6 = new JTextField();
        t6.setBounds(600, 250, 150, 30);
        id15.add(t6);

        id7 = new JLabel("Address");
        id7.setBounds(50, 300, 100, 30);
        id7.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id7);

        t7 = new JTextField();
        t7.setBounds(200, 300, 150, 30);
        id15.add(t7);

        id8 = new JLabel("Phone No");
        id8.setBounds(400, 300, 100, 30);
        id8.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id8);

        t8 = new JTextField();
        t8.setBounds(600, 300, 150, 30);
        id15.add(t8);

        id9 = new JLabel("Email ID");
        id9.setBounds(50, 350, 100, 30);
        id9.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id9);

        t9 = new JTextField();
        t9.setBounds(200, 350, 150, 30);
        id15.add(t9);

        id10 = new JLabel("Password");
        id10.setBounds(400, 350, 100, 30);
        id10.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id10);

        t10 = new JPasswordField();
        t10.setBounds(600, 350, 150, 30);
        id15.add(t10);

        id11 = new JLabel("Job ID");
        id11.setBounds(50, 400, 150, 30);
        id11.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id11);

        t11 = new JTextField();
        t11.setBounds(200, 400, 150, 30);
        id15.add(t11);

        id12 = new JLabel("Job Title");
        id12.setBounds(400, 400, 150, 30);
        id12.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id12);

        t12 = new JTextField();
        t12.setBounds(600, 400, 150, 30);
        id15.add(t12);

        id13 = new JLabel("Department ID");
        id13.setBounds(50, 450, 150, 30);
        id13.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id13);

        t13 = new JTextField();
        t13.setBounds(200, 450, 150, 30);
        id15.add(t13);

        lab = new JLabel();
        lab.setBounds(200, 450, 250, 200);
        id15.add(lab);

        lab1 = new JLabel("");
        lab1.setBounds(600, 450, 250, 200);
        id15.add(lab1);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250, 550, 150, 40);

        id15.add(b);

        b1 = new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450, 550, 150, 40);

        id15.add(b1);

        b.addActionListener(this);
        b1.addActionListener(this);

        f.setVisible(true);
        f.setSize(800, 700);
        f.setLocation(400, 150);
    }

    public void actionPerformed(ActionEvent ae) {

        String staffid = t1.getText();
        String fname = t3.getText();
        String lname = t4.getText();
        String gender = t5.getText();
        String age = t6.getText();
        String address = t7.getText();
        String phoneno = t8.getText();
        String email = t9.getText();
        String password = t10.getText();
        String jobid = t11.getText();
        String jobtitle = t12.getText();
        String deptid = t13.getText();
        if (ae.getSource() == b) {
            try {
                conn cc = new conn();
                String q = "insert into staff(staffid,fname,lname,gender,age,address,phoneno,email,password) values('" + staffid + "','" + fname + "','" + lname + "','" + gender + "','" + age + "','" + address + "','" + phoneno + "','" + email + "','" + password + "')";
                String q1 = "insert into jobtitle(jobid,jobrole,deptid,staffid)values('" + jobid + "','" + jobtitle + "','" + deptid + "','" + staffid + "');";
                cc.s.executeUpdate(q);
                cc.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                f.setVisible(false);
                new Admin_Dashboard();
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        } else if (ae.getSource() == b1) {
            f.setVisible(false);
            new Admin_Dashboard();
        }
    }

    public static void main(String[] arg) {
        new Add_Staff();
    }
}
