package View_Manager;

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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import View_User.MainGUI_User;
import View_User.Schedule_result_user;

import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class MainGUI extends JFrame {
	public MainGUI() {
		Container con = getContentPane();
		
		JPanel pnmain = new JPanel();
		pnmain.setBounds(80, 100, 1100, 600);
		FlowLayout fl_pnmain = new FlowLayout();
		fl_pnmain.setVgap(30);
		fl_pnmain.setHgap(100);
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
		
		JButton jbschedule = new JButton();
		jbschedule.setBackground(new Color(255, 255, 255));
		jbschedule.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/schedule.png")));
		jbschedule.setPreferredSize(buttonSize);
		jbschedule.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jbresult = new JButton();
		jbresult.setBackground(new Color(255, 255, 255));
		jbresult.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/result.png")));
		jbresult.setPreferredSize(buttonSize);
		jbresult.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
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
		lbimage.setIcon(new ImageIcon(MainGUI.class.getResource("/background/background4.jpg")));
		
		JMenuBar mbar = new JMenuBar();
		JMenu player = new JMenu("Cầu thủ");
		JMenu team = new JMenu("Đội bóng");
		JMenu schedule = new JMenu("Lịch thi đấu");
		JMenu result = new JMenu("Kết quả");
		JMenu rank = new JMenu("Bảng xếp hạng");
		JMenu sponsor = new JMenu("Tài trợ");
		
		JMenuItem itemqlplayer = new JMenuItem("Quản lý");
		
		JMenuItem itemdsplayer = new JMenuItem("Danh sách");
		
		JMenuItem itemqlteam = new JMenuItem("Quản lý");
		
		JMenuItem itemdsteam = new JMenuItem("Danh sách");
		
		JMenuItem itemqlschedule = new JMenuItem("Quản lý");
		
		JMenuItem itemdsschedule = new JMenuItem("Danh sách");
		
		JMenuItem itemqlresult = new JMenuItem("Quản lý");
		
		JMenuItem itemdsresult = new JMenuItem("Danh sách");
		
		JMenuItem itemrank = new JMenuItem("Bảng xếp hạng");
		
		JMenuItem itemtaitro = new JMenuItem("Tài trợ");
		
		jbplayer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FootballPlayer();
				setVisible(false);
			}
		});
		itemqlplayer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FootballPlayer();
				setVisible(false);
			}
		});
		
		itemdsplayer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PlayerList();
				setVisible(false);
			}
		});
		
		jbteam.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FootBallTeam();
				setVisible(false);
			}
		});
		
		itemqlteam.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FootBallTeam();
				setVisible(false);
			}
		});
		
		itemtaitro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Sponsor();
			}
		});
		
		jbschedule.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Schedule();
				setVisible(false);
			}
		});
		
		jbresult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Result();
				setVisible(false);
			}
		});
		
		jbrank.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Rank();
				setVisible(false);
			}
		});
		
		jblogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login();
				setVisible(false);
			}
		});
		
		itemqlschedule.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Schedule();
				setVisible(false);
			}
		});
		
		itemdsschedule.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Schedule_result();
				setVisible(false);
			}
		});
		
		itemqlresult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Result();
				setVisible(false);
			}
		});
		
		itemdsresult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Schedule_result();
				setVisible(false);
			}
		});
		
		itemdsteam.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TeamList();
				setVisible(false);
			}
		});		
		itemrank.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Rank();
				setVisible(false);
			}
		});
		
		player.add(itemdsplayer);
		player.add(itemqlplayer);
		
		team.add(itemqlteam);
		team.add(itemdsteam);
		
		schedule.add(itemqlschedule);
		schedule.add(itemdsschedule);
		
		result.add(itemqlresult);
		result.add(itemdsresult);
		
		sponsor.add(itemtaitro);
		
		rank.add(itemrank);
		
		mbar.add(player);
		mbar.add(team);
		mbar.add(schedule);
		mbar.add(result);
		mbar.add(rank);
		mbar.add(sponsor);
		
		pnmain.add(jbplayer);
		pnmain.add(jbteam);
		pnmain.add(jbschedule);
		pnmain.add(jbresult);
		pnmain.add(jbrank);
		pnmain.add(jblogout);
		
		con.add(pnmain);
		con.add(lbimage);
	
		setJMenuBar(mbar);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("VLEAGUE");
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public static void main(String[] args) {
		new MainGUI();
	}
}
