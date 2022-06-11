package Staff;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AddLog implements ActionListener {

    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id15, lab, lab1;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JButton b, b1, b2, b3;
    String staffid;

    AddLog(String staffid) {
        this.staffid = staffid;
        f = new JFrame("Enter Log");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setResizable(false);
        f.pack();
        id15 = new JLabel();
        id15.setBounds(0, 0, 1366, 768);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(900, 1000, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
        id15.setIcon(img);

        id8 = new JLabel("Enter Log");
        id8.setBounds(350, 30, 500, 50);
        id8.setFont(new Font("serif", Font.BOLD, 25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id1 = new JLabel("Staff Id");
        id1.setBounds(50, 150, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id1);

        t1 = new JTextField(staffid);
        t1.setEditable(false);
        t1.setBounds(200, 150, 150, 30);
        id15.add(t1);

        id2 = new JLabel("Job ID");
        id2.setBounds(400, 150, 200, 30);
        id2.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id2);

        t2 = new JTextField();
        t2.setBounds(600, 150, 150, 30);
        id15.add(t2);

        id3 = new JLabel("Duration");
        id3.setBounds(50, 200, 100, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id3);

        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 30);
        id15.add(t3);

        id4 = new JLabel("Date");
        id4.setBounds(400, 200, 200, 30);
        id4.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id4);

        t4 = new JTextField("yyyy/mm/dd");
        t4.setBounds(600, 200, 150, 30);
        id15.add(t4);

        id5 = new JLabel("Description");
        id5.setBounds(50, 250, 100, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id5);

        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 30);
        id15.add(t5);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250, 350, 150, 40);

        id15.add(b);

        b1 = new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450, 350, 150, 40);

        id15.add(b1);

        b.addActionListener(this);
        b1.addActionListener(this);

        f.setVisible(true);
        f.setSize(800, 700);
        f.setLocation(400, 150);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String a = staffid;
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        if (ae.getSource() == b) {
            try {
                conn cc = new conn();
                String q = "insert into onduty(staffid,jobid,duration,date,description) values('" + a +"','"+bb+ "','" + c + "','" + d + "','" + e + "');";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Log Updated");
                f.setVisible(false);
                new Staff_Dashboard(staffid);
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        } else if (ae.getSource() == b1) {
            f.setVisible(false);
            new Staff_Dashboard(staffid);
        }
    }

    public static void main(String args[]) {
        new AddLog("stafftrial");
    }

}
