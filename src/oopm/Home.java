package oopm;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b1,b3,b4,b5;

	public static void main(String[] args) {
            new Home().setVisible(true);
	}
        
        public Home() {
	
            setBounds(400, 150, 622, 605);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
            menuBar.setBackground(Color.WHITE);
            menuBar.setBounds(0, 0, 116, 35);
            contentPane.add(menuBar);

            JMenu mnExit = new JMenu("Exit");
            mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            
            
            JMenuItem mntmLogout = new JMenuItem("Logout");
            mntmLogout.setBackground(new Color(211, 211, 211));
            mntmLogout.setForeground(new Color(105, 105, 105));
            mntmLogout.addActionListener(this);
            mnExit.add(mntmLogout);
            
            JMenuItem mntmExit = new JMenuItem("Exit");
            mntmExit.setForeground(new Color(105, 105, 105));
            mntmExit.setBackground(new Color(211, 211, 211));
            mntmExit.addActionListener(this);
            mnExit.add(mntmExit);

            JMenu mnRecord = new JMenu("Record");
            mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            

            JMenuItem bookdetails = new JMenuItem("Book Details");
            bookdetails.addActionListener(this);
            bookdetails.setBackground(new Color(211, 211, 211));
            bookdetails.setForeground(Color.DARK_GRAY);
            mnRecord.add(bookdetails);

            JMenuItem studentdetails = new JMenuItem("Student Details");
            studentdetails.setBackground(new Color(211, 211, 211));
            studentdetails.setForeground(Color.DARK_GRAY);
            studentdetails.addActionListener(this);
            mnRecord.add(studentdetails);
            
            JMenuItem Statistics = new JMenuItem("Statistics");
            Statistics.addActionListener(this);
            Statistics.setBackground(new Color(211, 211, 211));
            Statistics.setForeground(Color.DARK_GRAY);
            mnRecord.add(Statistics);
            
            menuBar.add(mnRecord);
            menuBar.add(mnExit);

            JLabel l2 = new JLabel("");
            l2.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/book.png"));
            Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l2 = new JLabel(i3);
            l2.setBounds(60, 62, 159, 152);
            contentPane.add(l2);

            JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/third.png"));
            Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);

            JLabel l4 = new JLabel("");
            ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("icons/add.png"));
            Image i8 = i7.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            l4 = new JLabel(i9);
            l4.setBounds(325, 62, 225, 152);
            contentPane.add(l4);

            b1 = new JButton("Add Books");
            b1.addActionListener(this);
            b1.setBackground(Color.WHITE);
            b1.setForeground(Color.BLACK);
            b1.setFocusable(false);
            b1.setBounds(70, 225, 159, 44);
            contentPane.add(b1);

            b3 = new JButton("Add Student");
            b3.addActionListener(this);
            b3.setBackground(Color.WHITE);
            b3.setForeground(Color.BLACK);
            b3.setBounds(348, 225, 167, 44);
            contentPane.add(b3);

            b4 = new JButton("Issue Book");
            b4.addActionListener(this);
            b4.setBackground(Color.WHITE);
            b4.setForeground(Color.BLACK);
            b4.setBounds(76, 486, 143, 41);
            contentPane.add(b4);

            b5 = new JButton("Return Book");
            b5.addActionListener(this);
            b5.setBackground(Color.WHITE);
            b5.setForeground(Color.BLACK);
            b5.setBounds(361, 486, 159, 41);
            contentPane.add(b5);

            JLabel l5 = new JLabel("");
            ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("icons/book (2).png"));
            Image i11 = i10.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i12 = new ImageIcon(i11);
            l5 = new JLabel(i12);
            l5.setBounds(70, 299, 159, 163);
            contentPane.add(l5);

            JLabel l6 = new JLabel("");
            ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/return.png"));
            Image i14 = i13.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i15 = new ImageIcon(i14);
            l6 = new JLabel(i15);
            l6.setBounds(361, 299, 139, 152);
            contentPane.add(l6);

            JLabel l7 = new JLabel("");
            ImageIcon i16  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.png"));
            Image i17 = i16.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i18 = new ImageIcon(i17);
            
            getContentPane().setBackground(Color.WHITE);
            contentPane.setBackground(Color.WHITE);
	}
        
        
        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            if(msg.equals("Logout")){
                setVisible(false);
		new Login_user().setVisible(true);
            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            
            }else if(msg.equals("Read Me")){
            
            }else if(msg.equals("About Us")){
                setVisible(false);
		new aboutUs().setVisible(true);
            
            }else if(msg.equals("Book Details")){
                setVisible(false);
		new BookDetails().setVisible(true);
            }else if(msg.equals("Student Details")){
                setVisible(false);
                new StudentDetails().setVisible(true);
            }else if(msg.equals("Statistics")){
                setVisible(false);
                new Statistics().setVisible(true);
            }
            
            
            if(ae.getSource() == b1){
                this.setVisible(false);
                new AddBook().setVisible(true);
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new AddStudent().setVisible(true);
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new IssueBook().setVisible(true);
            }
            if(ae.getSource() == b5){
                this.setVisible(false);
                new ReturnBook().setVisible(true);
            
            }
            
        }
}
