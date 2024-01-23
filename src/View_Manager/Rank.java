package View_Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connection.DBController;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class Rank extends JFrame {
	Vector vT, vD;
	
	public static Vector getvD() {
		Connection con = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT footballname, ST, Win, Draw, Lose, Point FROM vleague.rank join vleague.footballteam on rank.ID = footballteam.ID ORDER BY Point DESC";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Vector vtemp = new Vector();
				vtemp.add(rs.getString(1));
				vtemp.add(rs.getString(2));
				vtemp.add(rs.getString(3));
				vtemp.add(rs.getString(4));
				vtemp.add(rs.getString(5));
				vtemp.add(rs.getString(6));
				vD.add(vtemp);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}
	
	public Rank() {
		Container con = getContentPane();
		
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
		pnmain.setBounds(250, 100, 800, 400);
		
		JPanel pnname = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnname.getLayout();
		flowLayout.setVgap(20);
		pnname.setBackground(new Color(255, 250, 250,100));
		
		JLabel lbname = new JLabel("BẢNG XẾP HẠNG");
		lbname.setForeground(new Color(255, 255, 0));
		lbname.setFont(new Font("Arial", Font.BOLD, 20));
		
		JPanel pnbutton = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnbutton.getLayout();
		flowLayout_1.setVgap(10);
		pnbutton.setOpaque(false);
		
		JButton jbback = new JButton("Trang chủ");
        jbback.setFont(new Font("Courier New", Font.BOLD, 14));
        jbback.setIcon(new ImageIcon(Rank.class.getResource("/iconbutton/home.png")));
        
        JButton jbchart = new JButton("Biểu đồ");
        jbchart.setFont(new Font("Courier New", Font.BOLD, 14));
        jbchart.setIcon(new ImageIcon(Rank.class.getResource("/iconbutton/bar_chart.png")));
        

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(Rank.class.getResource("/background/background3.png")));
        imageLabel.setSize(1280, 750);
        
		JScrollPane scrollPane = new JScrollPane();
		Dimension scrollsize = new Dimension(700,260);
        scrollPane.setPreferredSize(scrollsize);
        
        //scrollPane.setOpaque(false); // Đặt thuộc tính không đục lỗ cho JScrollPane
        //scrollPane.getViewport().setOpaque(false);
        
        
        
        vT = new Vector();
		vT.add("Mã đội");
		vT.add("Số trận đấu");
		vT.add("Số trận thắng");
		vT.add("Số trận hòa");
		vT.add("Số trận thua");
		vT.add("Điểm xếp hạng"); 
		
		vD = getvD();
		
		final JTable tb = new JTable();
		tb.setBackground(new Color(255, 250, 250));
		tb.setFont(new Font("Tahoma", Font.BOLD, 10));
		tb.setForeground(SystemColor.infoText);
		tb.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(tb);
		
		// Tạo một TableCellRenderer để căn giữa dữ liệu trong cột
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        // Đặt renderer cho mỗi cột trong JTable
        for (int i = 0; i < tb.getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
		
		jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainGUI();
				setVisible(false);
			}
		});
		
		jbchart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Chart();
				setVisible(false);
			}
		});
		
		//ADD thanh phan
		
		pnbutton.add(jbback);
		pnbutton.add(jbchart);
		pnname.add(lbname);
		
		pnmain.add(pnname, BorderLayout.NORTH);
		pnmain.add(scrollPane, BorderLayout.CENTER);
		pnmain.add(pnbutton, BorderLayout.SOUTH);
		
		con.add(pnmain);
		con.add(imageLabel);
		
		
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("Bảng xếp hạng");
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static void main(String[] args) {
		new Rank();
	}
}
