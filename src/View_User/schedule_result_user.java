package View_User;

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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

import com.toedter.calendar.JDateChooser;

import Connection.DBController;
import View_Manager.Rank;
import View_Manager.Result;
import java.awt.SystemColor;

public class Schedule_result_user extends JFrame {
	
	Vector vD, vT;
	
	JDateChooser datePicker1, datePicker2;
	
	public static Vector getvD() {
		Connection con = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT result.ID, team1.footballname AS team1_name, result.Score, team2.footballname AS team2_name, result.stadium, result.day, result.time FROM vleague.result JOIN vleague.footballteam AS team1 ON result.team1 = team1.ID JOIN vleague.footballteam AS team2 ON result.team2 = team2.ID ORDER BY Day DESC, Time DESC";
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
	

	public Schedule_result_user() {
		Container con = getContentPane();
		
		JLabel lbbackground = new JLabel();
		lbbackground.setIcon(new ImageIcon(Schedule_result_user.class.getResource("/background/background2.jpg")));
		
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
		pnmain.setBounds(200, 100, 900, 400);
		
		JPanel pnmain1 = new JPanel();
		FlowLayout fl_pnmain1 = new FlowLayout();
		fl_pnmain1.setHgap(20);
		fl_pnmain1.setVgap(30);
		pnmain1.setLayout(fl_pnmain1);
		pnmain1.setBackground(new Color(255, 250, 250,200));
		
		
		JPanel pnmain2 = new JPanel();
		pnmain2.setLayout(new BorderLayout());
		pnmain2.setOpaque(false);
		
		
		JLabel lbfrom = new JLabel("Từ ngày");
		lbfrom.setForeground(new Color(0, 255, 255));
		lbfrom.setFont(new Font("Constantia", Font.BOLD, 15));
		JLabel lbto = new JLabel("Đến ngày");
		lbto.setForeground(new Color(255, 255, 51));
		lbto.setFont(new Font("Constantia", Font.BOLD, 15));
		
		JButton jbfilter = new JButton("Lọc");
		jbfilter.setIcon(new ImageIcon(Schedule_result_user.class.getResource("/iconbutton/filter.png")));
		
		datePicker1 = new JDateChooser();
		datePicker1.setPreferredSize(new Dimension(150,30));
        datePicker1.setDateFormatString("yyyy-MM-dd"); // Định dạng ngày tháng

        JButton btnGetDate1 = new JButton("Get Selected Date");
        btnGetDate1.addActionListener(e -> {
            // Lấy ngày được chọn và hiển thị trong console
            Date selectedDate1 = datePicker1.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Selected Date: " + dateFormat.format(selectedDate1));
        });
        
        datePicker2 = new JDateChooser();
        datePicker2.setPreferredSize(new Dimension(150,30));
        datePicker2.setDateFormatString("yyyy-MM-dd"); // Định dạng ngày tháng

        JButton btnGetDate2 = new JButton("Get Selected Date");
        btnGetDate2.addActionListener(e -> {
            // Lấy ngày được chọn và hiển thị trong console 
            Date selectedDate2 = datePicker2.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Selected Date: " + dateFormat.format(selectedDate2));
        });
		
		JPanel pnname = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnname.getLayout();
		flowLayout.setVgap(10);
		pnname.setBackground(new Color(255, 250, 250,200));
		
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
				new MainGUI_User();
			}
		});
		jbfilter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector vS = new Vector();
				Connection con = new DBController().getConnection();
				String sql = "SELECT result.ID, team1.footballname AS team1_name, result.Score, team2.footballname AS team2_name, result.stadium, result.day, result.time FROM vleague.result JOIN vleague.footballteam AS team1 ON result.team1 = team1.ID JOIN vleague.footballteam AS team2 ON result.team2 = team2.ID WHERE Day BETWEEN ? AND ? ORDER BY Day DESC, Time DESC";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					

		            // Chuyển đổi Date thành chuỗi ngày
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            String formattedDate1 = sdf.format(datePicker1.getDate());
		            String formattedDate2 = sdf.format(datePicker2.getDate());

		   
		            stm.setString(1, formattedDate1);
		            stm.setString(2, formattedDate2);
		            
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
					//e2.printStackTrace();
				}
			}
		});
		
		pnname.add(lbname);
		pnmain1.add(lbfrom);
		pnmain1.add(datePicker1);
		pnmain1.add(lbto);
		pnmain1.add(datePicker2);
		pnmain1.add(jbfilter);
		
		pnmain2.add(pnname, BorderLayout.NORTH);
		pnmain2.add(scrollPane, BorderLayout.CENTER);
		pnmain2.add(pnbutton, BorderLayout.SOUTH);
		
		pnmain.add(pnmain1, BorderLayout.NORTH);
		pnmain.add(pnmain2, BorderLayout.CENTER);
		
		pnbutton.add(jbback);
		
		con.add(pnmain);
		con.add(lbbackground);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("Lịch thi đấu và kết quả");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,750);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new Schedule_result_user();
	}
}
