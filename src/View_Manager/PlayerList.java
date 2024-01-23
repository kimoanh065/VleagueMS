package View_Manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connection.DBController;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class PlayerList extends JFrame {
	
	Vector vT, vD;
	
	final static JTextField tfsearch = new JTextField();
	
	public static Vector getvD() {
		Connection con = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT footballplayer.ID, Name, Age, Position, Footballname FROM vleague.footballplayer LEFT JOIN vleague.footballteam ON footballplayer.IDFootballTeam = footballteam.ID";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Vector vtemp = new Vector();
				vtemp.add(rs.getString(1));
				vtemp.add(rs.getString(2));
				vtemp.add(rs.getString(3));
				vtemp.add(rs.getString(4));
				vtemp.add(rs.getString(5));
				vD.add(vtemp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vD;
	}
	
	
	public static Vector getTDB() {
		Vector v = new Vector();
		
		Connection conn = new DBController().getConnection();
		String sql = "SELECT * FROM vleague.footballteam";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				v.add(rs.getString(2));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return v;
	}

	public PlayerList() {
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setBounds(0,10, 1280, 750);
		pnmain.setOpaque(false);
		pnmain.setLayout(new BorderLayout());
		
		JPanel pnnorth = new JPanel();
		pnnorth.setLayout(new BorderLayout());
		pnnorth.setOpaque(false);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 250, 250,50));
		pn1.setLayout(new FlowLayout());
		
		
		JPanel pn2 = new JPanel();
		FlowLayout flpn2 = new FlowLayout();
		flpn2.setHgap(30);
		flpn2.setVgap(20);
		pn2.setLayout(flpn2);
		pn2.setBackground(new Color(255, 250, 250,50));
		
		
		JPanel pncenter = new JPanel();
		pncenter.setOpaque(false);
		
		
		JLabel lbbackground = new JLabel();
		lbbackground.setIcon(new ImageIcon(PlayerList.class.getResource("/background/san5.jpg")));
		
		JLabel lbsearch = new JLabel("Tìm kiếm");
		lbsearch.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lbsearch.setHorizontalAlignment(SwingConstants.CENTER);
		lbsearch.setForeground(new Color(0, 0, 0));
		
		tfsearch.setColumns(50);
		
		JLabel lbfilter = new JLabel("Lọc theo đội bóng");
		lbfilter.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lbfilter.setForeground(new Color(0, 0, 0));
		
		final JComboBox jcbfilter = new JComboBox(getTDB());
		jcbfilter.setSelectedItem(null);
		
		JButton jbback = new JButton("Trang chủ");
		jbback.setIcon(new ImageIcon(PlayerList.class.getResource("/iconbutton/home.png")));
		jbback.setPreferredSize(new Dimension(120,25));
		
		JButton jbsearch = new JButton("Tìm kiếm");
		jbsearch.setIcon(new ImageIcon(PlayerList.class.getResource("/iconbutton/search.png")));
		jbsearch.setPreferredSize(new Dimension(120,25));
		JScrollPane scrollPane = new JScrollPane();
		
		vT = new Vector();
		vT.add("Mã cầu thủ");
		vT.add("Tên cầu thủ");
		vT.add("Tuổi");
		vT.add("Chức vụ");
		vT.add("Tên đội bóng");
		
		vD = getvD();
		
		final JTable tb = new JTable();
		tb.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(tb);
		
		Dimension scrollsize = new Dimension(700,600);
		scrollPane.setPreferredSize(scrollsize);
		
		
		DefaultTableCellRenderer centerrenderer = new DefaultTableCellRenderer();
		centerrenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		for (int i = 0; i<tb.getColumnCount();i++) {
			tb.getColumnModel().getColumn(i).setCellRenderer(centerrenderer);
		}
		
		jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainGUI();
				setVisible(false);
			}
		});
		
		jbsearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector vS = new Vector();
				Connection con = new DBController().getConnection();
				String sql = "SELECT footballplayer.ID, Name, Age, Position, Footballname FROM vleague.footballplayer JOIN vleague.footballteam ON footballplayer.IDFootballTeam = footballteam.ID WHERE footballplayer.Name LIKE ? "; 
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, "%" +tfsearch.getText()+"%");

					ResultSet rs = stm.executeQuery();
					while (rs.next()) {
						Vector vtemp = new Vector();
						vtemp.add(rs.getString(1));
						vtemp.add(rs.getString(2));
						vtemp.add(rs.getString(3));
						vtemp.add(rs.getString(4));
						vtemp.add(rs.getString(5));
						vS.add(vtemp);
						
					}
					tb.setModel(new DefaultTableModel(vS, vT));
					DefaultTableCellRenderer centerrenderer = new DefaultTableCellRenderer();
					centerrenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
					
					for (int i = 0; i<tb.getColumnCount();i++) {
						tb.getColumnModel().getColumn(i).setCellRenderer(centerrenderer);
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
			}
			}});
		
		jcbfilter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector vS = new Vector();
				Connection con = new DBController().getConnection();
				String sql = "SELECT footballplayer.ID, Name, Age, Position, Footballname FROM vleague.footballplayer JOIN vleague.footballteam ON footballplayer.IDFootballTeam = footballteam.ID WHERE Footballname = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, (String)jcbfilter.getSelectedItem());
					ResultSet rs = stm.executeQuery();
					while (rs.next()) {
						Vector vtemp = new Vector();
						vtemp.add(rs.getString(1));
						vtemp.add(rs.getString(2));
						vtemp.add(rs.getString(3));
						vtemp.add(rs.getString(4));
						vtemp.add(rs.getString(5));
						vS.add(vtemp);
						
					}
					
					tb.setModel(new DefaultTableModel(vS, vT));
					DefaultTableCellRenderer centerrenderer = new DefaultTableCellRenderer();
					centerrenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
					
					for (int i = 0; i<tb.getColumnCount();i++) {
						tb.getColumnModel().getColumn(i).setCellRenderer(centerrenderer);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		//Add component
		
		
		pn1.add(lbsearch);
		pn1.add(tfsearch);
		
		pn2.add(lbfilter);
		pn2.add(jcbfilter);
		pn2.add(jbsearch);
		pn2.add(jbback);
		
		pncenter.add(scrollPane);
		
		
		pnnorth.add(pn1, BorderLayout.NORTH);
		pnnorth.add(pn2, BorderLayout.CENTER);
		
		pnmain.add(pnnorth, BorderLayout.NORTH);
		pnmain.add(pncenter, BorderLayout.CENTER);
		
		con.add(pnmain);
		con.add(lbbackground);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("Danh sách cầu thủ");
		setVisible(true);
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	public static void main(String[] args) {
		new PlayerList();
	}
}
