package Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class Manage_Leave_Requests extends JFrame implements ActionListener {
    
    JTextField t;
    JButton l, l5;
    JButton b,b1, b2;
    String adminid;
    public Manage_Leave_Requests(String adminid) {
        this.adminid=adminid;
        l = new JButton("Manage Leave Requests");
        l.setVisible(true);
        l.setBounds(50, 20, 400, 30);
        l.addActionListener(this);
        getContentPane().add(l, BorderLayout.NORTH);

        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        String sql = "select * from staffleave where status='pending'";

        try {
            conn cc = new conn();
            ResultSet rs = cc.s.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }

            while (rs.next()) {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesVector.add(columnNames.get(i));
        }

        JTable table = new JTable(dataVector, columnNamesVector) {
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        b1 = new JButton("Cancel");
        b1.setBounds(200, 200, 100, 30);
        b1.addActionListener(this);
        buttonPanel.add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == l) {
            try {
                new Leave_A_R("adminid001");
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }

        }

    }

    public static void main(String[] args) {
        Manage_Leave_Requests frame = new Manage_Leave_Requests("adminid001");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
