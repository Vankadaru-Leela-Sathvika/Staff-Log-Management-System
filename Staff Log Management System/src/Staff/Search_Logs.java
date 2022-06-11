package Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Search_Logs implements ActionListener {

    JFrame f;
    JTextField t;
    JLabel l, l5;
    JButton b, b2;
    String staffid;

    Search_Logs(String Staffid) {
        this.staffid = staffid;
        f = new JFrame("Search Log");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5 = new JLabel();
        l5.setBounds(0, 0, 500, 270);
        l5.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        l5.setIcon(img);

        l = new JLabel("Date");
        l.setVisible(true);
        l.setBounds(40, 50, 250, 30);
        l.setForeground(Color.BLACK);
        Font F1 = new Font("serif", Font.BOLD, 25);
        l.setFont(F1);
        l5.add(l);
        f.add(l5);

        t = new JTextField("yyyy/mm/dd");
        t.setBounds(240, 50, 220, 30);
        l5.add(t);

        b = new JButton("Search");
        b.setBounds(240, 150, 100, 30);
        b.addActionListener(this);
        l5.add(b);

        b2 = new JButton("Cancel");
        b2.setBounds(360, 150, 100, 30);
        b2.addActionListener(this);
        l5.add(b2);

        f.setSize(500, 270);
        f.setLocation(450, 250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            f.setVisible(false);
            Staff_Dashboard d = new Staff_Dashboard(staffid);
        }
        if (ae.getSource() == b) {
            f.setVisible(false);
            Get_Logs frame = new Get_Logs(t.getText(), staffid);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

    }

    public static void main(String[] ar) {
        new Search_Logs("stafftrial");
    }
}
