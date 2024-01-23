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
import View_User.schedule_result_user;

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
		
		JButton jblich = new JButton();
		jblich.setBackground(new Color(255, 255, 255));
		jblich.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/schedule.png")));
		jblich.setPreferredSize(buttonSize);
		jblich.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton jbketqua = new JButton();
		jbketqua.setBackground(new Color(255, 255, 255));
		jbketqua.setIcon(new ImageIcon(MainGUI.class.getResource("/iconbutton/result.png")));
		jbketqua.setPreferredSize(buttonSize);
		jbketqua.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
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
		lbimage.setIcon(new ImageIcon(MainGUI.class.getResource("/background/background4.jpg")));
		
		JMenuBar mbar = new JMenuBar();
		JMenu cauthu = new JMenu("Cầu thủ");
		JMenu doibong = new JMenu("Đội bóng");
		JMenu lichthidau = new JMenu("Lịch thi đấu");
		JMenu ketqua = new JMenu("Kết quả");
		JMenu xephang = new JMenu("Bảng xếp hạng");
		JMenu taitro = new JMenu("Tài trợ");
		
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
		
		jbcauthu.addActionListener(new ActionListener() {
			
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
		
		jbdoibong.addActionListener(new ActionListener() {
			
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
		
		jblich.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new schedule();
				setVisible(false);
			}
		});
		
		jbketqua.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new result();
				setVisible(false);
			}
		});
		
		jbxephang.addActionListener(new ActionListener() {
			
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
				new schedule();
				setVisible(false);
			}
		});
		
		itemdsschedule.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new schedule_result();
				setVisible(false);
			}
		});
		
		itemqlresult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new result();
				setVisible(false);
			}
		});
		
		itemdsresult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new schedule_result();
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
		
		cauthu.add(itemdsplayer);
		cauthu.add(itemqlplayer);
		
		doibong.add(itemqlteam);
		doibong.add(itemdsteam);
		
		lichthidau.add(itemqlschedule);
		lichthidau.add(itemdsschedule);
		
		ketqua.add(itemqlresult);
		ketqua.add(itemdsresult);
		
		taitro.add(itemtaitro);
		
		xephang.add(itemrank);
		
		mbar.add(cauthu);
		mbar.add(doibong);
		mbar.add(lichthidau);
		mbar.add(ketqua);
		mbar.add(xephang);
		mbar.add(taitro);
		
		pnmain.add(jbcauthu);
		pnmain.add(jbdoibong);
		pnmain.add(jblich);
		pnmain.add(jbketqua);
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
		new MainGUI();
	}
}
