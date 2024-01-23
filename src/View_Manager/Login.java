package View_Manager;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Connection.DBController;
import View_User.MainGUI_User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Login extends JFrame {

	public Login() {
		Container con = getContentPane();
		JLabel lbbg = new JLabel();
		lbbg.setIcon(new ImageIcon(Login.class.getResource("/background/pastel3.jpg")));
		lbbg.setSize(1000,505);
		
		JPanel pnmain = new JPanel();
		pnmain.setBounds(380, 200, 500, 300);
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
		
		pnmain.setBorder(new LineBorder(new Color(255, 250, 250), 8));
		
		
		final JPanel pncard = new JPanel();
		pncard.setLayout(new CardLayout(0, 0));
		pncard.setOpaque(false);
		//pncard.setBackground(new Color(255, 255, 255, 100));
		
		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new GridLayout(1,2));
		//pnmain3.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt
		
		final JPanel pncard1 = new JPanel();
		pncard1.setLayout(new BorderLayout());
        //pnmain1.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt
		pncard1.setBackground(new Color(255, 255, 255, 100));
		
        final JPanel pncard2 = new JPanel();
		pncard2.setLayout(new BorderLayout());
        //pnmain1.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt
		pncard2.setBackground(new Color(255, 255, 255, 100));
		
		JPanel pnregister = new JPanel();
		//pnmain2.setBackground(SystemColor.window);
		FlowLayout flpn2 = new FlowLayout();
		flpn2.setHgap(10);
		pnregister.setLayout(flpn2);
		pnregister.setBackground(new Color(255, 255, 255, 150));;
        //pnmain2.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt
		
		
		JPanel pn1 = new JPanel();
		//pn1.setBackground(SystemColor.window);
		pn1.setForeground(new Color(255, 255, 255));
		FlowLayout flpn1 = new FlowLayout();
		flpn1.setVgap(20);
		pn1.setLayout(flpn1);
		pn1.setBackground(new Color(255, 255, 255, 100));
        
		
		
		JPanel pn2 = new JPanel();
		//pn2.setBackground(SystemColor.window);
		GridLayout gl_pn2 = new GridLayout(2,2);
		gl_pn2.setHgap(-300);
		gl_pn2.setVgap(30);
		pn2.setLayout(gl_pn2);
		pn2.setBackground(new Color(255, 255, 255, 100));
        
		
		JPanel pn3 = new JPanel();
		//pn3.setBackground(SystemColor.window);
		FlowLayout flpn3 = new FlowLayout();
		flpn3.setVgap(30);
		pn3.setLayout(flpn3);
		pn3.setBackground(new Color(255, 255, 255, 100));
		
		
		JPanel pn1_1 = new JPanel();
		FlowLayout flpn1_1 = new FlowLayout();
		flpn1_1.setVgap(20);
		pn1_1.setLayout(flpn1_1);
		pn1_1.setBackground(new Color(255, 255, 255, 100));
        
		
		
		JPanel pn2_1 = new JPanel();
		//pn2_1.setBackground(SystemColor.window);
		GridLayout gl_pn2_1 = new GridLayout(2,2);
		gl_pn2_1.setHgap(-300);
		gl_pn2_1.setVgap(30);
		pn2_1.setLayout(gl_pn2_1);
		pn2_1.setBackground(new Color(255, 255, 255, 100));
        
		
		JPanel pn3_1 = new JPanel();
		//pn3_1.setBackground(SystemColor.window);
		FlowLayout flpn3_1 = new FlowLayout();
		flpn3_1.setVgap(30);
		pn3_1.setLayout(flpn3_1);
		pn3_1.setBackground(new Color(255, 255, 255, 100));
		
		
		
		
		JButton jbuser = new JButton("Guess");
		jbuser.setBackground(new Color(255, 228, 225));
		jbuser.setForeground(new Color(255, 20, 147));
		jbuser.setFont(new Font("Courier New", Font.BOLD, 15));
		jbuser.setFocusable(false);
		//jbuser.setOpaque(false);
		
		JButton jbmanager = new JButton("Manager");
		jbmanager.setBackground(new Color(255, 228, 225));
		jbmanager.setForeground(new Color(255, 20, 147));
		jbmanager.setFont(new Font("Courier New", Font.BOLD, 15));
		jbmanager.setFocusable(false);
		//jbmanager.setOpaque(false);
        
		
		Dimension sizelabeluser = new Dimension(125,20);
		Dimension sizelabelmanager = new Dimension(150,20);
		
		JLabel lbloginnow = new JLabel("GUESS LOGIN");
		lbloginnow.setFont(new Font("Consolas", Font.BOLD, 21));
		lbloginnow.setForeground(new Color(102, 102, 255));
		lbloginnow.setPreferredSize(sizelabeluser);
		
		JLabel lbloginmanager = new JLabel("MANAGER LOGIN");
		lbloginmanager.setFont(new Font("Consolas", Font.BOLD, 21));
		lbloginmanager.setForeground(new Color(153, 102, 255));
		lbloginmanager.setPreferredSize(sizelabelmanager);
		
		JLabel lbuser = new JLabel("Username");
		lbuser.setForeground(new Color(255, 0, 0));
		lbuser.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lbmanager = new JLabel("Username");
		lbmanager.setForeground(new Color(255, 0, 0));
		lbmanager.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lbpass1 = new JLabel("Password");
		lbpass1.setForeground(new Color(102, 255, 0));
		lbpass1.setFont(new Font("Consolas", Font.BOLD, 15));
		
		JLabel lbpass2 = new JLabel("Password");
		lbpass2.setForeground(new Color(102, 255, 0));
		lbpass2.setFont(new Font("Consolas", Font.BOLD, 15));
		
		
		JLabel lbregis = new JLabel("New User? Register here");
		lbregis.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 12));
		lbregis.setForeground(new Color(0, 191, 255));

		final JTextField tfuser = new JTextField();
		final JPasswordField tfpass1 = new JPasswordField();
		
		final JTextField tfmanager = new JTextField();
		final JPasswordField tfpass2 = new JPasswordField();
		
		JButton jblogin = new JButton("Login");
		jblogin.setBackground(new Color(255, 240, 245));
		jblogin.setFont(new Font("Courier New", Font.BOLD, 14));
		jblogin.setFocusable(false);
		
		
		JButton jblogin1 = new JButton("Login");
		jblogin1.setBackground(new Color(255, 240, 245));
		jblogin1.setFont(new Font("Courier New", Font.BOLD, 14));
		jblogin1.setFocusable(false);
		
		JButton jbregis = new JButton("Register");
		jbregis.setBackground(new Color(240, 248, 255));
		jbregis.setFont(new Font("Courier New", Font.BOLD, 13));
		jbregis.setFocusable(false);
		
		
		pn1.add(lbloginnow);
		pn2.add(lbuser);
		pn2.add(tfuser);
		pn2.add(lbpass1);
		pn2.add(tfpass1);
		
		pn3.add(jblogin);
		
		pn1_1.add(lbloginmanager);
		pn2_1.add(lbmanager);
		pn2_1.add(tfmanager);
		pn2_1.add(lbpass2);
		pn2_1.add(tfpass2);
		
		pn3_1.add(jblogin1);
		
		pncard1.add(pn1, BorderLayout.NORTH);
		pncard1.add(pn2, BorderLayout.CENTER);
		pncard1.add(pn3, BorderLayout.SOUTH);
		
		pncard2.add(pn1_1, BorderLayout.NORTH);
		pncard2.add(pn2_1, BorderLayout.CENTER);
		pncard2.add(pn3_1, BorderLayout.SOUTH);
		
		
		
		pnregister.add(lbregis);
		pnregister.add(jbregis);
		
		pnbutton.add(jbuser);
		pnbutton.add(jbmanager);
		
		pncard.add(pncard1, "t1");
		pncard.add(pncard2, "t2");
		
		pnmain.add(pncard, BorderLayout.CENTER);
		pnmain.add(pnregister, BorderLayout.SOUTH);
		pnmain.add(pnbutton, BorderLayout.NORTH);
		con.add(pnmain);
		con.add(lbbg);
		
		
		
		jbuser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c1 = (CardLayout)(pncard.getLayout());
				c1.show(pncard, "t1");
				//pnmain4.setOpaque(false);
			}
		});
		
		jbmanager.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout c2 = (CardLayout)(pncard.getLayout());
				c2.show(pncard, "t2");
				//pnmain1.setOpaque(false);
			}
		});
		
		jblogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql2 = "Select * from vleague.account_user WHERE user_name = ? AND password = ?";
				
				if(tfuser.getText().isEmpty() || tfpass1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
					return; 
				}
				
				try {
					PreparedStatement stm = con.prepareStatement(sql2);
					stm.setString(1, tfuser.getText());
					stm.setString(2, tfpass1.getText());
					
					ResultSet rs = stm.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						setVisible(false);
						new MainGUI_User();
					}
					else
						JOptionPane.showMessageDialog(null, "Tài khoản và mật khẩu không chính xác");
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		
		jblogin1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql1 = "Select * from vleague.account_manager WHERE manager_name = ? AND password = ?";
				
				if(tfmanager.getText().isEmpty() || tfpass2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
					return; 
				}
				
				try {
					PreparedStatement stm = con.prepareStatement(sql1);
					stm.setString(1, tfmanager.getText());
					stm.setString(2, tfpass2.getText());
					ResultSet rs = stm.executeQuery();
					
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						setVisible(false);
						new MainGUI();
					}
					else
						JOptionPane.showMessageDialog(null, "Tài khoản và mật khẩu không chính xác");
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		
		
		jbregis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Register();
				setVisible(false);
			}
		});
		
		
		setSize(1280,750);
		setTitle("Log in VLEAGUE");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login();
	}
}
