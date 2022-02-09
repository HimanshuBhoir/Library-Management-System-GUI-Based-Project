package oopm;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    JButton b1,b2;

    public static void main(String[] args) {
        new AddStudent().setVisible(true);
    } 

    public void random() {
        Random rd = new Random();
    }

    public AddStudent() {
        super("Add Student");
	setBounds(700, 200, 309, 218);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Student_id");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(10, 11, 102, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(10, 44, 102, 22);
	contentPane.add(l2);

	JLabel l4 = new JLabel("Branch");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(10, 77, 102, 22);
	contentPane.add(l4);

	t1 = new JTextField();
	t1.setBackground(Color.WHITE);
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(122, 13, 156, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(122, 46, 156, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(122, 79, 156, 20);
	contentPane.add(t3);

	b1 = new JButton("ADD");
	b1.addActionListener(this);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b1.setBounds(18, 128, 111, 33);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(139, 128, 111, 33);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
	contentPane.add(b2);
        
        contentPane.setBackground(Color.WHITE);
	random();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn con = new conn();
                String sql = "insert into student(student_id, name, branch) values(?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		st.setString(2, t2.getText());
		st.setString(3, t3.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                    this.setVisible(false);
                    new Home().setVisible(true);
                }
		else
                    JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Home().setVisible(true);		
            }
        }catch(Exception e){
            
        }
    }
}

