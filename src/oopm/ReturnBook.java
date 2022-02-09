package oopm;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton b1,b2,b3;
    private JTextField returndat;

    public static void main(String[] args) {
	new ReturnBook().setVisible(true);
    }

    public void delete() {
        try { 
            conn con = new conn();
            String sql = "delete from issueBook where book_id=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, textField.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
	}
    }

    
    public ReturnBook() {
        setBounds(450, 300, 362, 382);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel lblNewLabel = new JLabel("Book_id");
	lblNewLabel.setForeground(new Color(0, 0, 0));
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel.setBounds(10, 11, 87, 24);
	contentPane.add(lblNewLabel);

	JLabel lblStudentid = new JLabel("Student_id");
	lblStudentid.setForeground(Color.BLACK);
	lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblStudentid.setBounds(10, 40, 87, 24);
	contentPane.add(lblStudentid);

	JLabel lblBook = new JLabel("Book");
	lblBook.setForeground(Color.BLACK);
	lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblBook.setBounds(10, 94, 71, 24);
	contentPane.add(lblBook);

	JLabel lblName = new JLabel("Name");
	lblName.setForeground(Color.BLACK);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(10, 124, 71, 24);
	contentPane.add(lblName);

        JLabel lblBranch = new JLabel("Branch");
	lblBranch.setForeground(Color.BLACK);
	lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblBranch.setBounds(10, 159, 68, 24);
	contentPane.add(lblBranch);

	JLabel lblDateOfIssue = new JLabel("Date of Issue");
	lblDateOfIssue.setForeground(Color.BLACK);
	lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfIssue.setBounds(10, 209, 105, 29);
	contentPane.add(lblDateOfIssue);

	JLabel lblDateOfReturn = new JLabel("Date of Return");
	lblDateOfReturn.setForeground(Color.BLACK);
	lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfReturn.setBounds(10, 248, 118, 29);
	contentPane.add(lblDateOfReturn);

        textField = new JTextField();
	textField.setForeground(new Color(105, 105, 105));
	textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	textField.setBounds(91, 14, 105, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setForeground(new Color(105, 105, 105));
	textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	textField_1.setBounds(101, 43, 93, 20);
	contentPane.add(textField_1);
	textField_1.setColumns(10);

	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBounds(231, 26, 105, 29);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
	contentPane.add(b1);

	textField_2 = new JTextField();
	textField_2.setEditable(false);
	textField_2.setForeground(new Color(0, 100, 0));
	textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_2.setBounds(88, 96, 179, 21);
	contentPane.add(textField_2);
	textField_2.setColumns(10);

	textField_3 = new JTextField();
	textField_3.setEditable(false);
	textField_3.setForeground(new Color(0, 100, 0));
	textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_3.setColumns(10);
	textField_3.setBounds(88, 127, 179, 20);
	contentPane.add(textField_3);

	textField_5 = new JTextField();
	textField_5.setForeground(new Color(0, 100, 0));
	textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_5.setEditable(false);
	textField_5.setColumns(10);
	textField_5.setBounds(88, 162, 179, 20);
	contentPane.add(textField_5);

	textField_6 = new JTextField();
	textField_6.setForeground(new Color(0, 100, 0));
	textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	textField_6.setEditable(false);
	textField_6.setColumns(10);
	textField_6.setBounds(125, 214, 162, 20);
	contentPane.add(textField_6);

	b2 = new JButton("Return");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	b2.setBounds(10, 302, 149, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);

	contentPane.add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
	b3.setBounds(187, 302, 149, 30);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
	contentPane.add(b3);
	
	returndat = new JTextField();
	returndat.setBounds(125, 254, 162, 20);
	contentPane.add(returndat);
	returndat.setColumns(10);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from issueBook where student_id = ? and book_id =?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, textField_1.getText());
		st.setString(2, textField.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    textField_2.setText(rs.getString("bname"));
                    textField_3.setText(rs.getString("sname"));
                    textField_5.setText(rs.getString("branch"));
                    textField_6.setText(rs.getString("dateOfIssue"));
		}
		st.close();
		rs.close();
		
            }
            if(ae.getSource() == b2){
                String sql = "insert into returnBook(book_id, student_id, bname, sname, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, textField.getText());
		st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		st.setString(4, textField_3.getText());
		st.setString(5, textField_5.getText());
		st.setString(6, textField_6.getText());
		st.setString(7, returndat+"");
		int i = st.executeUpdate();
		if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Processing..");
                    delete();
		} else
                    JOptionPane.showMessageDialog(null, "error");
		
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Home().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }
}
