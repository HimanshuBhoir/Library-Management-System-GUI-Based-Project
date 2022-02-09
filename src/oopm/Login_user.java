package oopm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2;


	public Login_user() {
            
	setBackground(new Color(169, 169, 169));	
        setBounds(600, 300, 299, 187);
		
        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);
	panel.setLayout(null); 

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(10, 21, 95, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(10, 56, 95, 24);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(115, 23, 157, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(115, 58, 157, 20);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(Color.BLACK);
	b1.setBackground(Color.WHITE);
	b1.setBounds(22, 109, 83, 24);
	panel.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(Color.BLACK);
	b2.setBackground(Color.WHITE);
	b2.setBounds(157, 109, 83, 24);
	panel.add(b2);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    conn con = new conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading().setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login_user().setVisible(true);
	}

}
