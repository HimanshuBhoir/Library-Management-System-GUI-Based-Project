package oopm;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener{

    private JPanel date;
    private JTextField t1,t2,t6,t8,t9,t12;
    private JButton b1,b2,b3,b4;
    private JTextField dat;

    public static void main(String[] args) {
	new IssueBook().setVisible(true);
			
    }

    public IssueBook() { 
        setBounds(300, 200, 359, 423);
	date = new JPanel();
	date.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(date);
        date.setBackground(Color.WHITE);
	date.setLayout(null);

	JLabel l1 = new JLabel("Book_id");
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setForeground(new Color(47, 79, 79));
	l1.setBounds(10, 150, 100, 23);
	date.add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(10, 192, 100, 23);
	date.add(l2);

	JLabel l6 = new JLabel("Price");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(10, 226, 100, 23);
	date.add(l6);

	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(120, 152, 86, 20);
	date.add(t1);
	
	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b1.setBounds(233, 147, 100, 30);
        
	date.add(b1);

	t2 = new JTextField();
	t2.setEditable(false);
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setBounds(120, 194, 208, 20);
	date.add(t2);
	t2.setColumns(10);

	t6 = new JTextField();
	t6.setEditable(false);
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(120, 225, 208, 20);
	date.add(t6);

	JLabel l8 = new JLabel("Student_id");
	l8.setForeground(new Color(47, 79, 79));
	l8.setFont(new Font("Tahoma", Font.BOLD, 14));
	l8.setBounds(10, 11, 100, 23);
	date.add(l8);

	JLabel l9 = new JLabel("Name");
	l9.setForeground(new Color(47, 79, 79));
	l9.setFont(new Font("Tahoma", Font.BOLD, 14));
	l9.setBounds(10, 45, 100, 23);
	date.add(l9);

	JLabel l12 = new JLabel("Branch");
	l12.setForeground(new Color(47, 79, 79));
	l12.setFont(new Font("Tahoma", Font.BOLD, 14));
	l12.setBounds(10, 79, 100, 23);
	date.add(l12);

	t8 = new JTextField();
	t8.setForeground(new Color(47, 79, 79));
	t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t8.setColumns(10);
	t8.setBounds(120, 11, 86, 20);
	date.add(t8);

	b2 = new JButton("Search");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b2.setBounds(233, 4, 100, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
	date.add(b2);

	t9 = new JTextField();
	t9.setForeground(new Color(47, 79, 79));
	t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t9.setEditable(false);
	t9.setColumns(10);
	t9.setBounds(120, 47, 208, 20);
	date.add(t9);

	t12 = new JTextField();
	t12.setForeground(new Color(47, 79, 79));
	t12.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t12.setEditable(false);
	t12.setColumns(10);
	t12.setBounds(120, 81, 208, 20);
	date.add(t12);
        
	JLabel l15 = new JLabel(" Date of Issue :");
	l15.setForeground(new Color(105, 105, 105));
	l15.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	l15.setBounds(10, 260, 118, 26);
	date.add(l15);

	b3 = new JButton("Issue");
	b3.addActionListener(this);
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b3.setBounds(31, 334, 118, 33);
	b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        date.add(b3);

	b4 = new JButton("Back");
	b4.addActionListener(this);
	b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b4.setBounds(173, 334, 100, 33);
	b4.setBackground(Color.WHITE);
        b4.setForeground(Color.BLACK);
        date.add(b4);
        
        dat = new JTextField();
        dat.setBounds(130, 265, 124, 20);
        date.add(dat);
        dat.setColumns(10);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from book where book_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t6.setText(rs.getString("price"));
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b2){
                String sql = "select * from student where student_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t8.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    t9.setText(rs.getString("name"));
                    t12.setText(rs.getString("branch"));
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b3){
                    try{
                String sql = "insert into issueBook(book_id, student_id, bname, sname, branch, dateOfIssue) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		st.setString(2, t8.getText());
		st.setString(3, t2.getText());
		st.setString(4, t9.getText());
		st.setString(5, t12.getText());
		st.setString(6, dat.getText());
		int i = st.executeUpdate();
		if (i > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
		else
                    JOptionPane.showMessageDialog(null, "error");
                    }catch(Exception e){
                        e.printStackTrace();
                                }
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
		new Home().setVisible(true);
			
            }
            
            con.c.close();
        }catch(Exception e){
            
        }
    }
}
