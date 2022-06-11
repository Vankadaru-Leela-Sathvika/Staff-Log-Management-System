package Admin;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Update_Staff implements ActionListener {

    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13, id15, lab, lab1;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    JButton b, b1, b2, b3;
    String staffid;
    String fname, lname, gender, age, address, phoneno, email, password, jobid, jobtitle, deptid;
    String adminid;
    Update_Staff(String staffid,String adminid) {
        this.adminid=adminid;
        this.staffid = staffid;
        try {
            conn con = new conn();
            String str = "select * from staff right join jobtitle on staff.staffid=jobtitle.staffid where staff.staffid='" + staffid + "';";
            ResultSet rs = con.s.executeQuery(str);

            if (rs.next()) {
                fname = rs.getString(2);
                lname = rs.getString(3);
                gender = rs.getString(4);
                age = rs.getString(5);
                address = rs.getString(6);
                phoneno = rs.getString(7);
                email = rs.getString(8);
                password = rs.getString(9);
                jobid = rs.getString(10);
                jobtitle = rs.getString(11);
                deptid = rs.getString(12);
                System.out.print(fname);
            }

        } catch (Exception ex) {
            System.out.print(ex);
        }
        f = new JFrame("Update staff " + staffid);
        f.setBackground(Color.white);
        f.setLayout(null);
        f.pack();
        id15 = new JLabel();
        id15.setBounds(0, 0, 1366, 768);
        id15.setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(800, 1000, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        id15.setIcon(imageIcon);

        id8 = new JLabel("Update Staff Details");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id1 = new JLabel("staffid");
        id1.setBounds(50, 150, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id1);

        t1 = new JTextField(this.staffid);
        t1.setEditable(false);
        t1.setBounds(200, 150, 150, 30);
        id15.add(t1);

        id3 = new JLabel("First Name");
        id3.setBounds(50, 200, 100, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id3);

        t3 = new JTextField(fname);
        t3.setBounds(200, 200, 150, 30);
        id15.add(t3);

        id4 = new JLabel("Last Name");
        id4.setBounds(400, 200, 200, 30);
        id4.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id4);

        t4 = new JTextField(lname);
        t4.setBounds(600, 200, 150, 30);
        id15.add(t4);

        id5 = new JLabel("Gender");
        id5.setBounds(50, 250, 100, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id5);

        t5 = new JTextField(gender);
        t5.setBounds(200, 250, 150, 30);
        id15.add(t5);

        id6 = new JLabel("Age");
        id6.setBounds(400, 250, 100, 30);
        id6.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id6);

        t6 = new JTextField(age);
        t6.setBounds(600, 250, 150, 30);
        id15.add(t6);

        id7 = new JLabel("Address");
        id7.setBounds(50, 300, 100, 30);
        id7.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id7);

        t7 = new JTextField(address);
        t7.setBounds(200, 300, 150, 30);
        id15.add(t7);

        id8 = new JLabel("Phone No");
        id8.setBounds(400, 300, 100, 30);
        id8.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id8);

        t8 = new JTextField(phoneno);
        t8.setBounds(600, 300, 150, 30);
        id15.add(t8);

        id9 = new JLabel("Email ID");
        id9.setBounds(50, 350, 100, 30);
        id9.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id9);

        t9 = new JTextField(email);
        t9.setBounds(200, 350, 150, 30);
        id15.add(t9);

        id10 = new JLabel("Password");
        id10.setBounds(400, 350, 100, 30);
        id10.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id10);

        t10 = new JPasswordField(password);
        t10.setBounds(600, 350, 150, 30);
        id15.add(t10);

        id11 = new JLabel("Job ID");
        id11.setBounds(50, 400, 150, 30);
        id11.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id11);

        t11 = new JTextField(jobid);
        t11.setEditable(false);
        t11.setBounds(200, 400, 150, 30);
        id15.add(t11);

        id12 = new JLabel("Job Title");
        id12.setBounds(400, 400, 150, 30);
        id12.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id12);

        t12 = new JTextField(jobtitle);
        t12.setBounds(600, 400, 150, 30);
        id15.add(t12);

        id13 = new JLabel("Department ID");
        id13.setBounds(50, 450, 150, 30);
        id13.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id13);

        t13 = new JTextField(deptid);
        t13.setBounds(200, 450, 150, 30);
        id15.add(t13);

        b = new JButton("Update");
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
        staffid = this.staffid;
        fname = t3.getText();
        lname = t4.getText();
        gender = t5.getText();
        age = t6.getText();
        address = t7.getText();
        phoneno = t8.getText();
        email = t9.getText();
        password = t10.getText();
        jobid = t11.getText();
        jobtitle = t12.getText();
        deptid = t13.getText();
        if (ae.getSource() == b) {
            try {
                conn cc = new conn();
                String q = "update staff set fname='" + fname + "',lname='" + lname + "',gender='" + gender + "',age='" + age + "',address='" + address + "',phoneno='" + phoneno + "',email='" + email + "',password='" + password + "' where staffid='" + staffid + "';";
                String q1 = "update jobtitle set jobrole='" + jobtitle + "',deptid='" + deptid + "' where staffid='" + staffid + "';";
                cc.s.executeUpdate(q);
                cc.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Successfully Updates");
                f.setVisible(false);
                new Manage_Staff(adminid);
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        }
        if (ae.getSource() == b1) {
            f.setVisible(false);
            Admin_Dashboard d = new Admin_Dashboard(adminid);
        }
    }

    public static void main(String[] args) {
        new Update_Staff("staffid002","adminid001");
    }
}
