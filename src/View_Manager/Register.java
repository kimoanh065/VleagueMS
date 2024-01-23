package View_Manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Connection.DBController;

import java.awt.Color;
import java.awt.SystemColor;

public class Register extends JFrame {
	
	
	public Register() {
		Container con = getContentPane();
		JLabel lbbg = new JLabel();
		lbbg.setIcon(new ImageIcon(Register.class.getResource("/background/pastel2.jpg")));
		lbbg.setSize(1000,505);
		
		JPanel pnmain = new JPanel();
		pnmain.setBounds(380, 200, 500, 300);
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
		pnmain.setBorder(new LineBorder(new Color(255, 250, 250), 8));
		
		JPanel pn1 = new JPanel();
		//pn1.setBackground(SystemColor.window);
		//pn1.setForeground(new Color(255, 255, 255));
		FlowLayout flpn1 = new FlowLayout();
		flpn1.setVgap(20);
		pn1.setLayout(flpn1);
		pn1.setBackground(new Color(255, 255, 255, 150));
		   
		
		JPanel pn2 = new JPanel();
		//pn2.setBackground(SystemColor.window);
		GridLayout grpn2 = new GridLayout(3,2);
		grpn2.setHgap(-200);
		grpn2.setVgap(30);
		pn2.setLayout(grpn2);  
		pn2.setBackground(new Color(255, 255, 255, 150));
		
		JPanel pn3 = new JPanel();
		FlowLayout flpn3 = new FlowLayout();
		flpn3.setHgap(20);
		flpn3.setVgap(20);
		pn3.setLayout(flpn3);
		//pn3.setBackground(SystemColor.window);  
		pn3.setBackground(new Color(255, 255, 255, 150));
		
		Dimension sizelabel = new Dimension(140,20);
		
		JLabel lbregisnow = new JLabel("REGISTER NOW");
		lbregisnow.setFont(new Font("Consolas", Font.BOLD, 21));
		lbregisnow.setForeground(new Color(51, 204, 0));
		lbregisnow.setPreferredSize(sizelabel);
		
		JLabel lbuser = new JLabel("Username");
		lbuser.setForeground(new Color(51, 153, 255));
		lbuser.setFont(new Font("Consolas", Font.BOLD, 15));
		lbuser.setPreferredSize(sizelabel);
		
		JLabel lbpass = new JLabel("Password");
		lbpass.setForeground(new Color(255, 204, 51));
		lbpass.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lbconfirm = new JLabel("Confirm Password");
		lbconfirm.setForeground(new Color(220, 20, 60));
		lbconfirm.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lbregis = new JLabel("New User? Register here");
		lbregis.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lbregis.setForeground(new Color(153, 204, 102));

		final JTextField tfuser = new JTextField();
		final JPasswordField tfpass = new JPasswordField();
		final JPasswordField tfconfirm = new JPasswordField();
		
		JButton jbback = new JButton("Back");
		jbback.setBackground(new Color(255, 255, 240));
		jbback.setFont(new Font("Courier New", Font.BOLD, 13));
		JButton jbregis = new JButton("Register");
		jbregis.setBackground(new Color(245, 255, 250));
		jbregis.setFont(new Font("Courier New", Font.BOLD, 13));
		jbregis.setFocusable(false);
		
		jbregis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfuser.getText().isEmpty() || tfpass.getText().isEmpty() || tfconfirm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
					return; 
				}
				if (tfpass.getText().equals(tfconfirm.getText())) {
					String sql = "INSERT INTO vleague.account_user VALUES (?, ?)";
					try {
						Connection con = new DBController().getConnection();
						PreparedStatement stm = con.prepareStatement(sql);
						stm.setString(1, tfuser.getText());
						stm.setString(2, tfpass.getText());
						stm.execute();
						JOptionPane.showMessageDialog(null, "Đăng ký thành công");
						tfuser.setText(null);
						tfpass.setText(null);
						tfconfirm.setText(null);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu chưa nhập");
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Hai mật khẩu không giống nhau");
				}
			}
		});
		
		jbback.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login();
				setVisible(false);
			}
		});
		
		pn1.add(lbregisnow);
		pn2.add(lbuser);
		pn2.add(tfuser);
		pn2.add(lbpass);
		pn2.add(tfpass);
		pn2.add(lbconfirm);
		pn2.add(tfconfirm);
		
		pn3.add(jbregis);
		pn3.add(jbback);
		
		
		pnmain.add(pn1, BorderLayout.NORTH);
		pnmain.add(pn2, BorderLayout.CENTER);
		pnmain.add(pn3, BorderLayout.SOUTH);
		con.add(pnmain);
		con.add(lbbg);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/register.png"));
		this.setIconImage(logo.getImage());
		
		setSize(1280,750);
		setTitle("Register");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Register();
	}

}
