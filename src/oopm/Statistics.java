package oopm;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class Statistics extends JFrame{

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        new Statistics().setVisible(true);
    }

    public void issueBook() {
	try {
            conn con =  new conn();
            String sql = "select * from issueBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(new DefaultTableModel(
            	new Object[][] {
            		{null, null, null, null, null},
            	},
            	new String[] {
            		"BookId", "StudentId", "Name", "Branch", "IssueDate"
            	}
            ));

	} catch (Exception e) {
			// TODO: handle exception
	}
    }

    public void returnBook() {
        try {
            conn con = new conn();
            String sql = "select * from returnBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
	} catch (Exception e) {
			// TODO: handle exception
	}
    }

    public Statistics() {
        setBounds(400, 200, 774, 313);
	contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 31, 717, 217);
	contentPane.add(scrollPane);

        table = new JTable();
	table.setBackground(Color.WHITE);
	table.setForeground(Color.BLACK);
	table.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
	scrollPane.setViewportView(table);

	JLabel l1 = new JLabel("Back");
	l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
		setVisible(false);
		Home home = new Home();
		home.setVisible(true);
            }
	});
	l1.setForeground(new Color(204, 0, 102));
	l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
	l1.setBounds(662, 0, 96, 27);
	contentPane.add(l1);
        

	issueBook();
	returnBook();
    }
}
