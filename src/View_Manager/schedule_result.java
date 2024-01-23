package View_Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import View_Manager.result;
import java.awt.SystemColor;

public class schedule_result extends JFrame {
	
	Vector vD, vT;
	
	public static Vector getvD() {
		Connection con = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT result.ID, team1.footballname AS team1_name, result.Score, team2.footballname AS team2_name, result.stadium, result.day, result.time FROM vleague.result JOIN vleague.footballteam AS team1 ON result.team1 = team1.ID JOIN vleague.footballteam AS team2 ON result.team2 = team2.ID";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Vector vtemp = new Vector();
				vtemp.add(rs.getString(1));
				vtemp.add(rs.getString(2));
				vtemp.add(rs.getString(3));
				vtemp.add(rs.getString(4));
				vtemp.add(rs.getString(5));
				vtemp.add(rs.getString(6));
				vtemp.add(rs.getString(7));
				vD.add(vtemp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return vD;
	}
	

	public schedule_result() {
		Container con = getContentPane();
		
		JLabel lbbackground = new JLabel();
		lbbackground.setIcon(new ImageIcon(schedule_result.class.getResource("/background/background2.jpg")));
		
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
		pnmain.setBounds(200, 100, 900, 400);
		
		JPanel pnname = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnname.getLayout();
		flowLayout.setVgap(20);
		pnname.setBackground(new Color(255, 250, 250,150));
		
		JLabel lbname = new JLabel("LỊCH THI ĐẤU VÀ KẾT QUẢ");
		lbname.setForeground(new Color(255, 0, 0));
		lbname.setFont(new Font("Arial", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTable tb = new JTable();
		tb.setForeground(SystemColor.infoText);
		
		vT = new Vector();
		vT.add("Mã trận đấu");
		vT.add("Đội 1");
		vT.add("Tỉ số");
		vT.add("Đội 2");
		vT.add("Sân vận động");
		vT.add("Ngày diễn ra");
		vT.add("Giờ diễn ra");
		vD = getvD();
		tb.setModel(new DefaultTableModel(vD, vT));
		
		scrollPane.setViewportView(tb);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		for (int i = 0; i < tb.getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
		
		JPanel pnbutton = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnbutton.getLayout();
		flowLayout_1.setVgap(30);
		pnbutton.setOpaque(false);
		
        JButton jbback = new JButton("Trang chủ");
        jbback.setFont(new Font("Courier New", Font.BOLD, 14));
        jbback.setIcon(new ImageIcon(Rank.class.getResource("/iconbutton/home.png")));
        
        Dimension buttonSize = new Dimension(150, 30);
		jbback.setPreferredSize(buttonSize);
		
		
		jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new MainGUI();
			}
		});
		
		pnname.add(lbname);
		
		pnmain.add(pnname, BorderLayout.NORTH);
		pnmain.add(scrollPane, BorderLayout.CENTER);
		pnmain.add(pnbutton, BorderLayout.SOUTH);
		
		pnbutton.add(jbback);
		
		con.add(pnmain);
		con.add(lbbackground);
		
		setTitle("Lịch thi đấu và kết quả");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,750);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new schedule_result();
	}
}
