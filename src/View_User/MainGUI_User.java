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
		
		
		JButton jbplayer = new JButton();
		jbplayer.setBackground(new Color(255, 255, 255));
		jbplayer.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/players.png")));
		jbplayer.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		Dimension buttonSize = new Dimension(200, 200);
		jbplayer.setPreferredSize(buttonSize);
		
		JButton jbteam = new JButton();
		jbteam.setBackground(new Color(255, 255, 255));
		jbteam.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/team.png")));
		jbteam.setPreferredSize(buttonSize);
		jbteam.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jbschedule_result = new JButton();
		jbschedule_result.setBackground(new Color(255, 255, 255));
		jbschedule_result.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/schedule.png")));
		jbschedule_result.setPreferredSize(buttonSize);
		jbschedule_result.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jbrank = new JButton();
		jbrank.setBackground(new Color(255, 255, 255));
		jbrank.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/rank.png")));
		jbrank.setPreferredSize(buttonSize);
		jbrank.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jblogout = new JButton();
		jblogout.setBackground(new Color(255, 255, 255));
		jblogout.setIcon(new ImageIcon(MainGUI_User.class.getResource("/iconbutton/lg3.png")));
		jblogout.setPreferredSize(buttonSize);
		jblogout.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JLabel lbimage = new JLabel();
		lbimage.setIcon(new ImageIcon(MainGUI_User.class.getResource("/background/background4.jpg")));
		
		JMenuBar mbar = new JMenuBar();
		JMenu player = new JMenu("Cầu thủ");
		JMenu team = new JMenu("Đội bóng");
		JMenu schedule_result = new JMenu("Lịch thi đấu và kết quả");
		JMenu rank = new JMenu("Bảng xếp hạng");
		JMenu sponsor = new JMenu("Tài trợ");
		
		
		JMenuItem itemdscauthu = new JMenuItem("Danh sách");
		
		JMenuItem itemdsdoibong = new JMenuItem("Danh sách");
		
		JMenuItem itemdsltdkq = new JMenuItem("Danh sách");
		
		JMenuItem itemtaitro = new JMenuItem("Tài trợ");
		
		JMenuItem itemrank = new JMenuItem("Bảng xếp hạng");
		
		jbplayer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PlayerList();
				setVisible(false);
			}
		});
		
		jbteam.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new TeamList();
			}
		});
		
		jbschedule_result.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Schedule_result_user();
				setVisible(false);
			}
		});
		
		jbrank.addActionListener(new ActionListener() {
			
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
				new Schedule_result_user();
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
		
		player.add(itemdscauthu);
		
		team.add(itemdsdoibong);
		
		sponsor.add(itemtaitro);
		
		schedule_result.add(itemdsltdkq);
		
		rank.add(itemrank);
		
		mbar.add(player);
		mbar.add(team);
		mbar.add(schedule_result);
		mbar.add(rank);
		mbar.add(sponsor);
		
		pnmain.add(jbplayer);
		pnmain.add(jbteam);
		pnmain.add(jbschedule_result);
		pnmain.add(jbrank);
		pnmain.add(jblogout);
		
		con.add(pnmain);
		con.add(lbimage);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
	
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
