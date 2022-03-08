package Admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Manage_Staff implements ActionListener {

    JFrame f;
    JTextField t;
    JLabel l, l5;
    JButton b, b1, b2;

    Manage_Staff() {
        f = new JFrame("Manage Staff");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5 = new JLabel();
        l5.setBounds(0, 0, 500, 270);
        l5.setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        l5.setIcon(imageIcon);

        l = new JLabel("Staff Id");
        l.setVisible(true);
        l.setBounds(40, 50, 250, 30);
        l.setForeground(Color.BLACK);
        Font F1 = new Font("serif", Font.BOLD, 25);
        l.setFont(F1);
        l5.add(l);
        f.add(l5);

        t = new JTextField();
        t.setBounds(240, 50, 220, 30);
        l5.add(t);

        b = new JButton("Update");
        b.setBounds(100, 150, 100, 30);
        b.addActionListener(this);
        l5.add(b);

        b1 = new JButton("Remove");
        b1.setBounds(200, 150, 100, 30);
        b1.addActionListener(this);
        l5.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(300, 150, 100, 30);
        b2.addActionListener(this);
        l5.add(b2);

        f.setSize(500, 270);
        f.setLocation(450, 250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b) {
            new Update_Staff(t.getText());
            f.setVisible(false);
        }
        if (ae.getSource() == b1) {
            new Remove_Staff(t.getText());
            f.setVisible(false);
        }
        if (ae.getSource() == b2) {
            f.setVisible(false);
            Admin_Dashboard d = new Admin_Dashboard();
        }
    }

    public static void main(String[] ar) {
        new Manage_Staff();
    }
}
