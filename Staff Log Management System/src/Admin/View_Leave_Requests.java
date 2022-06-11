package Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class View_Leave_Requests extends JFrame implements ActionListener{
    JButton b1;
    String adminid;
    public View_Leave_Requests(String adminid) {
        this.adminid=adminid;
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        String sql = "select * from staffleave";
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
         if (ae.getSource() == b1) {
            this.setVisible(false);
            new Admin_Dashboard(adminid);
        }
    }    

    public static void main(String[] args) {
        View_Leave_Requests frame = new View_Leave_Requests("adminid001");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
