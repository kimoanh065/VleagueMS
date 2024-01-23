package View_Manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Connection.DBController;
import Connection.DBController;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class FootballPlayer extends JFrame {
	
	Vector vT, vD;
	static JComboBox jcbtendoibong;
	
	public static Vector getvD() {
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT footballplayer.ID, Name, Age, Position, Footballname FROM vleague.footballplayer LEFT JOIN vleague.footballteam ON footballplayer.IDFootballTeam = footballteam.ID";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	
	public static String getMDB() {
		String temp = null;
		Connection con = new DBController().getConnection();
		String sql = "SELECT * FROM vleague.footballteam WHERE Footballname = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, (String) jcbtendoibong.getSelectedItem());
			ResultSet rs = stm.executeQuery();
			if (rs.next())
				temp = rs.getString("ID");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(temp);
		
		return temp;
		
	}

	public FootballPlayer() {
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		JPanel pnnorth = new JPanel();
		pnnorth.setSize(200,400);
		pnnorth.setLayout(new GridLayout(6, 2, -1000, 15));
		
		JLabel macauthu = new JLabel("Mã cầu thủ");
		macauthu.setForeground(new Color(255, 0, 0));
		macauthu.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JLabel tencauthu = new JLabel("Tên cầu thủ");
		tencauthu.setForeground(new Color(34, 139, 34));
		tencauthu.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JLabel tuoi = new JLabel("Tuổi");
		tuoi.setForeground(new Color(0, 191, 255));
		tuoi.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JLabel chucvu = new JLabel("Vị trí");
		chucvu.setForeground(new Color(127, 255, 0));
		chucvu.setFont(new Font("Dialog", Font.BOLD, 13));
		JLabel madoibong = new JLabel("Mã đội bóng");
		madoibong.setForeground(new Color(210, 105, 30));
		madoibong.setFont(new Font("Dialog", Font.BOLD, 13));
		
		
		final JTextField tfmacauthu = new JTextField(10);
		final JTextField tftencauthu = new JTextField(10);
		final JTextField tftuoi= new JTextField(10);
		final JComboBox jcbchucvu = new JComboBox();
		jcbchucvu.setModel(new DefaultComboBoxModel(new String[] {"Huấn luyện viên","Thủ môn", "Tiền đạo", "Hậu vệ","Tiền vệ" }));
		
		jcbtendoibong = new JComboBox(getTDB());
		
		JLabel emty = new JLabel();
		
		JPanel jpbutton = new JPanel();
		jpbutton.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 10));
		
		JButton jbadd = new JButton("Add");
		jbadd.setFont(new Font("Courier New", Font.BOLD, 13));
		jbadd.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/add.png")));
		JButton jbupdate = new JButton("Edit");
		jbupdate.setFont(new Font("Courier New", Font.BOLD, 13));
		jbupdate.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/edit.png")));
		JButton jbdelete = new JButton("Delete");
		jbdelete.setFont(new Font("Courier New", Font.BOLD, 13));
		jbdelete.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/delete.png")));
		JButton jbclear = new JButton("Refresh");
		jbclear.setFont(new Font("Courier New", Font.BOLD, 13));
		jbclear.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/refresh.png")));
		JButton jbback = new JButton("Back");
		jbback.setFont(new Font("Courier New", Font.BOLD, 13));
		jbback.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/home.png")));
		
		
		JPanel pncenter = new JPanel();
		BorderLayout bl_pncenter = new BorderLayout();
		bl_pncenter.setVgap(100);
		bl_pncenter.setHgap(50);
		pncenter.setLayout(bl_pncenter);
		Border bd = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder ttlBorder = BorderFactory.createTitledBorder(bd, "Danh sách cầu thủ");
		pncenter.setBorder(ttlBorder);
		
		JScrollPane scrollPane = new JScrollPane();
		pncenter.add(scrollPane);
		
		vT = new Vector();
		vT.add("Mã cầu thủ");
		vT.add("Tên cầu thủ");
		vT.add("Tuổi");
		vT.add("Chức vụ");
		vT.add("Tên đội bóng");
		
		vD = getvD();
		
		final JTable tb = new JTable();
		tb.setForeground(SystemColor.infoText);
		tb.setFont(new Font("Arial", Font.BOLD, 11));
		tb.setBackground(new Color(255, 255, 255));
		tb.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(tb);
		
		// Tạo một TableCellRenderer để căn giữa dữ liệu trong cột
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        // Đặt renderer cho mỗi cột trong JTable
        for (int i = 0; i < tb.getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
		
		jbclear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfmacauthu.setText("");
		        tftencauthu.setText("");
		        tftuoi.setText("");
		        
			}
		});
		
		jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainGUI();
				setVisible(false);
			}
		});
		
		jbadd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "INSERT INTO vleague.footballplayer VALUES (?, ?, ?, ?, ?)";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfmacauthu.getText());
					stm.setString(2, tftencauthu.getText());
					stm.setInt(3, Integer.parseInt(tftuoi.getText()));
					stm.setString(4, jcbchucvu.getSelectedItem() + "");
					stm.setString(5, getMDB());
					stm.execute();
					JOptionPane.showMessageDialog(null, "Thêm cầu thủ thành công");
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Chưa thêm cầu thủ");
					e1.printStackTrace();
				}
				vD = getvD();
				tb.setModel(new DefaultTableModel(vD, vT));
				
				// Tạo một TableCellRenderer để căn giữa dữ liệu trong cột
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		        
		        // Đặt renderer cho mỗi cột trong JTable
		        for (int i = 0; i < tb.getColumnCount(); i++) {
		            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		        }
			}
		});
		
		
		final String[] oldid = {""};
		tb.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tb.getSelectedRow();
				int column = tb.getSelectedColumn();
				
				tfmacauthu.setText((String)tb.getValueAt(row, 0));
				tftencauthu.setText((String)tb.getValueAt(row, 1));
				tftuoi.setText((String)tb.getValueAt(row, 2));
				jcbchucvu.setSelectedItem((String)tb.getValueAt(row, 3));
				jcbtendoibong.setSelectedItem((String)tb.getValueAt(row, 4));
				
			}
		});
		
		tb.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        int selectedRow = tb.getSelectedRow();
		        int idColumnIndex = 0; 

		        if (selectedRow != -1) {
		            oldid[0] = (String) tb.getValueAt(selectedRow, idColumnIndex);
		        }
		    }
		});
		
		jbupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "UPDATE vleague.footballplayer SET ID = ?, Name = ?, Age = ?, Position = ?, IDFootballTeam = ? WHERE ID = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfmacauthu.getText());
					stm.setString(2, tftencauthu.getText());
					stm.setInt(3, Integer.parseInt(tftuoi.getText()));
					stm.setString(4, jcbchucvu.getSelectedItem() + "");
					stm.setString(5, jcbtendoibong.getSelectedItem() + "");
					stm.setString(6, oldid[0]);
					stm.execute();
					
					stm.execute();
					JOptionPane.showMessageDialog(null, "Cập nhập thành công");
					
					vD = getvD();
					tb.setModel(new DefaultTableModel(vD, vT));
					
					// Tạo một TableCellRenderer để căn giữa dữ liệu trong cột
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			        
			        // Đặt renderer cho mỗi cột trong JTable
			        for (int i = 0; i < tb.getColumnCount(); i++) {
			            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			        }
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Cập nhập không thành công");
					e2.printStackTrace();
				}
			}
		});
		
		
		jbdelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "DELETE FROM vleague.footballplayer WHERE ID = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfmacauthu.getText());
					
					int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa cầu thủ này không?");
					if (choose == 0) {
						stm.execute();
						JOptionPane.showMessageDialog(null, "Xoa thanh cong");
						
						sql = "UPDATE vleague.footballteam set quantity = (quantity - 1) WHERE ID = ?";
						stm = con.prepareStatement(sql);
						stm.setString(1, getMDB());
						stm.execute();
						vD = getvD();
						tb.setModel(new DefaultTableModel(vD, vT));
						
						// Tạo một TableCellRenderer để căn giữa dữ liệu trong cột
						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
				        
				        // Đặt renderer cho mỗi cột trong JTable
				        for (int i = 0; i < tb.getColumnCount(); i++) {
				            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
				        }
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
				}
				}
		});;
		
		jpbutton.add(jbadd);
		jpbutton.add(jbupdate);
		jpbutton.add(jbdelete);
		jpbutton.add(jbclear);
		jpbutton.add(jbback);
		
		pnnorth.add(macauthu);
		pnnorth.add(tfmacauthu);
		pnnorth.add(tencauthu);
		pnnorth.add(tftencauthu);
		pnnorth.add(tuoi);
		pnnorth.add(tftuoi);
		pnnorth.add(chucvu);
		pnnorth.add(jcbchucvu);
		pnnorth.add(madoibong);
		pnnorth.add(jcbtendoibong);
		pnnorth.add(emty);
		pnnorth.add(jpbutton);
		
		pnmain.add(pnnorth, BorderLayout.NORTH);
		
		pnmain.add(pncenter, BorderLayout.CENTER);
		con.add(pnmain, BorderLayout.CENTER);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("Quản lý cầu thủ");

		
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static void main(String[] args) {
		new FootballPlayer();
	}
}
