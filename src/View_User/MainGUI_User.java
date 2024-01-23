package View_User;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import View_Manager.Login;
import View_Manager.MainGUI;

import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class MainGUI_User extends JFrame {
	public MainGUI_User() {
		Container con = getContentPane();
		
		JPanel pnmain = new JPanel();
		pnmain.setBounds(80, 100, 1100, 600);
		FlowLayout fl_pnmain = new FlowLayout();
		fl_pnmain.setVgap(30);
		fl_pnmain.setHgap(120);
		pnmain.setLayout(fl_pnmain);
		pnmain.setOpaque(false);
		
		
		JButton jbcauthu = new JButton();
		jbcauthu.setBackground(new Color(255, 255, 255));
		jbcauthu.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/players.png")));
		jbcauthu.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		Dimension buttonSize = new Dimension(200, 200);
		jbcauthu.setPreferredSize(buttonSize);
		
		JButton jbdoibong = new JButton();
		jbdoibong.setBackground(new Color(255, 255, 255));
		jbdoibong.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/team.png")));
		jbdoibong.setPreferredSize(buttonSize);
		jbdoibong.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jblich_ketqua = new JButton();
		jblich_ketqua.setBackground(new Color(255, 255, 255));
		jblich_ketqua.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/schedule.png")));
		jblich_ketqua.setPreferredSize(buttonSize);
		jblich_ketqua.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jbxephang = new JButton();
		jbxephang.setBackground(new Color(255, 255, 255));
		jbxephang.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/rank.png")));
		jbxephang.setPreferredSize(buttonSize);
		jbxephang.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jblogout = new JButton();
		jblogout.setBackground(new Color(255, 255, 255));
		jblogout.setIcon(new ImageIcon(MainGUI_User.class.getResource("/iconbutton/lg3.png")));
		jblogout.setPreferredSize(buttonSize);
		jblogout.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JLabel lbimage = new JLabel();
		lbimage.setIcon(new ImageIcon(MainGUI_User.class.getResource("/background/background4.jpg")));
		
		JMenuBar mbar = new JMenuBar();
		JMenu cauthu = new JMenu("Cầu thủ");
		JMenu doibong = new JMenu("Đội bóng");
		JMenu lichthidau_ketqua = new JMenu("Lịch thi đấu và kết quả");
		JMenu xephang = new JMenu("Bảng xếp hạng");
		JMenu taitro = new JMenu("Tài trợ");
		
		
		JMenuItem itemdscauthu = new JMenuItem("Danh sách");
		
		JMenuItem itemdsdoibong = new JMenuItem("Danh sách");
		
		JMenuItem itemdsltdkq = new JMenuItem("Danh sách");
		
		JMenuItem itemtaitro = new JMenuItem("Tài trợ");
		
		JMenuItem itemrank = new JMenuItem("Bảng xếp hạng");
		
		jbcauthu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PlayerList();
				setVisible(false);
			}
		});
		
		jbdoibong.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new TeamList();
			}
		});
		
		jblich_ketqua.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new schedule_result_user();
				setVisible(false);
			}
		});
		
		jbxephang.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Rank_User();
			}
		});
		
		itemtaitro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Sponsor();
			}
		});
		
		itemdsltdkq.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new schedule_result_user();
			}
		});
		
		itemrank.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Rank_User();
			}
		});
		
		jblogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login();
				setVisible(false);
			}
		});
		
		cauthu.add(itemdscauthu);
		
		doibong.add(itemdsdoibong);
		
		taitro.add(itemtaitro);
		
		lichthidau_ketqua.add(itemdsltdkq);
		
		xephang.add(itemrank);
		
		mbar.add(cauthu);
		mbar.add(doibong);
		mbar.add(lichthidau_ketqua);
		mbar.add(xephang);
		mbar.add(taitro);
		
		pnmain.add(jbcauthu);
		pnmain.add(jbdoibong);
		pnmain.add(jblich_ketqua);
		pnmain.add(jbxephang);
		pnmain.add(jblogout);
		
		con.add(pnmain);
		con.add(lbimage);
		
		
	
		setJMenuBar(mbar);
		
		setTitle("VLEAGUE");
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public static void main(String[] args) {
		new MainGUI_User();
	}
}
