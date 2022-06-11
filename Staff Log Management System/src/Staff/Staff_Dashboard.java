package Staff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Staff_Dashboard implements ActionListener {

    JFrame f;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6,b7;
    public String staffid;

    Staff_Dashboard(String staffid) {
        this.staffid = staffid;
        f = new JFrame("Staff Account" + staffid);
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setResizable(false);

        l1 = new JLabel();
        l1.setBounds(0, 0, 800, 800);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("Welcome " + staffid);
        l2.setBounds(250, 20, 200, 40);
        l2.setFont(new Font("serif", Font.BOLD, 25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1 = new JButton("Request for leave");
        b1.setBounds(250, 80, 210, 40);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("view Leave Status");
        b2.setBounds(250, 140, 210, 40);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.addActionListener(this);
        l1.add(b2);
        
        b7 = new JButton("Add Log");
        b7.setBounds(250, 200, 210, 40);
        b7.setFont(new Font("serif", Font.BOLD, 15));
        b7.addActionListener(this);
        l1.add(b7);

        b3 = new JButton("Search Logs");
        b3.setBounds(250, 260, 210, 40);
        b3.setFont(new Font("serif", Font.BOLD, 15));
        b3.addActionListener(this);
        l1.add(b3);

        b4 = new JButton("View Logs");
        b4.setBounds(250, 320, 210, 40);
        b4.setFont(new Font("serif", Font.BOLD, 15));
        b4.addActionListener(this);
        l1.add(b4);

        b5 = new JButton("Update Details");
        b5.setBounds(250, 380, 210, 40);
        b5.setFont(new Font("serif", Font.BOLD, 15));
        b5.addActionListener(this);
        l1.add(b5);

        b6 = new JButton("Logout");
        b6.setBounds(250, 440, 210, 40);
        b6.setFont(new Font("serif", Font.BOLD, 15));
        b6.addActionListener(this);
        l1.add(b6);

        f.setVisible(true);
        f.setSize(700,600);
        f.setLocation(450, 200);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            new Request_Leave(staffid);
        }
        if (ae.getSource() == b2) {
            f.setVisible(false);
            View_Leaves frame = new View_Leaves(staffid);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        }
        if (ae.getSource() == b3) {
            f.setVisible(false);
            new Search_Logs(staffid);
        }
        if (ae.getSource() == b4) {
            f.setVisible(false);
            JFrame frame=new View_Logs(staffid);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
        if (ae.getSource() == b5) {
            f.setVisible(false);
            new Update_Staff(staffid);
        }
        if (ae.getSource() == b6) {
            f.setVisible(false);
            new Front_Page();
        }
        if (ae.getSource() == b7) {
            f.setVisible(false);
            new AddLog(staffid);
        }
    }

    public static void main(String[] arg) {
        Staff_Dashboard d = new Staff_Dashboard("stafftrial");
    }
}
