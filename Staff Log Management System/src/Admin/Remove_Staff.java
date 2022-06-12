package Admin;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Remove_Staff implements ActionListener {

    JFrame f;
    JTextField t;
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8;
    JButton b, b1, b2, b3;
    String staffid;
    String adminid;
    Remove_Staff(String staffid,String adminid) {
        this.adminid=adminid;
        f = new JFrame("Remove Staff");
        f.setBackground(Color.green);
        f.setLayout(null);
        this.staffid = staffid;
        l5 = new JLabel();
        l5.setBounds(0, 0, 500, 500);
        l5.setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        l5.setIcon(imageIcon);
        f.add(l5);

        l1 = new JLabel("Are you sure you want to remove employee");
        l1.setBounds(30, 50, 500, 30);
        l1.setForeground(Color.black);
        Font f2 = new Font("serif", Font.BOLD, 25);
        l1.setFont(f2);
        l5.add(l1);

        l2 = new JLabel(staffid);
        l2.setBounds(150, 80, 500, 30);
        l2.setForeground(Color.black);
        l2.setFont(f2);
        l5.add(l2);

        b1 = new JButton("Confirm");
        b1.setBounds(200, 130, 100, 30);
        b1.addActionListener(this);
        l5.add(b1);

        b3 = new JButton("Cancel");
        b3.setBounds(200, 200, 100, 30);
        b3.addActionListener(this);
        l5.add(b3);

        f.setSize(500, 500);
        f.setLocation(500, 250);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                conn con = new conn();
                String str = "delete from staff where staffid = '" + this.staffid + "';";
                String str1 = "delete from jobtitle where staffid = '" + this.staffid + "';";
                con.s.executeUpdate(str1);
                con.s.executeUpdate(str);

                l2.setVisible(false);
                b1.setVisible(false);
                JOptionPane.showMessageDialog(null, "deleted successfully");
                f.setVisible(false);
                Manage_Staff d = new Manage_Staff(adminid);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Exception occured while delting record " + ex);
            }
        }

        if (ae.getSource() == b3) {
            f.setVisible(false);
            Manage_Staff d = new Manage_Staff(adminid);
        }
    }

    public static void main(String[] arg) {
        new Remove_Staff("trials","adminid001");
    }
}
