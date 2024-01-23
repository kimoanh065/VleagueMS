package View_User;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connection.DBController;
import View_Manager.Rank;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class TeamList extends JFrame {
	Vector vD, vT;
	
	public static Vector getvD() {
		Connection con = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.footballteam";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Vector vtemp = new Vector();
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
	
	public TeamList() {
		Container con = getContentPane();
		JLabel lbbackground = new JLabel();
		lbbackground.setIcon(new ImageIcon(TeamList.class.getResource("/background/san2.jpg")));
		
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
		pnmain.setBounds(250, 100, 800, 400);
		
		
		JPanel pnname = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnname.getLayout();
		flowLayout.setVgap(20);
		pnname.setBackground(new Color(255, 250, 250,150));
		
		JLabel lbname = new JLabel("Các đội bóng tham gia VLEAGUE");
		lbname.setForeground(new Color(138, 43, 226));
		lbname.setFont(new Font("Arial", Font.BOLD, 20));
		
		JPanel pnbutton = new JPanel();
		pnbutton.setOpaque(false);
		
		JButton jbback = new JButton("Trang chủ");
        jbback.setIcon(new ImageIcon(Rank.class.getResource("/iconbutton/home.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		Dimension scrollsize = new Dimension(700,300);
		scrollPane.setPreferredSize(scrollsize);
		
		vT = new Vector();
		//vT.add("Mã đội bóng");
		vT.add("Tên đội bóng");
		vT.add("Số thành viên");
		vT.add("Ngày thành lập");
		vT.add("Mã image");
		
		vD = getvD();
		
		JTable tb = new JTable();
		tb.setModel(new DefaultTableModel(vD, vT));
		
		scrollPane.setViewportView(tb);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        // Đặt renderer cho mỗi cột trong JTable
        for (int i = 0; i < tb.getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new MainGUI_User();
			}
		});
		
		pnname.add(lbname);
		
		pnbutton.add(jbback);
		
		pnmain.add(pnname, BorderLayout.NORTH);
		pnmain.add(scrollPane, BorderLayout.CENTER);
		pnmain.add(pnbutton, BorderLayout.SOUTH);
		
		con.add(pnmain);
		con.add(lbbackground);
		
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("Danh sách đội bóng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,750);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	public static void main(String[] args) {
		new TeamList();
	}
}
