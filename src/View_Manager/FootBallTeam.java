package View_Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connection.DBController;
import java.awt.SystemColor;

public class FootBallTeam extends JFrame {
	
	Vector vT, vD;
	
	final JTextField tfmadoibong = new JTextField(30);
	final JTextField tftendoibong= new JTextField(50);
	final JTextField tffounding= new JTextField(20);
	final JComboBox jcbmaimage = new JComboBox(getImage());
	
	public static Vector getvD() {
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.footballteam";
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
	
	public static Vector getImage() {
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.image";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				vD.add(rs.getString(1));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}
	
	public Icon getIcon(String d) {
		int width = 250, height = 300;
		Image image = new ImageIcon(getClass().getResource("/icon/" + d + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	
	public FootBallTeam() {
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		JPanel pnnorth = new JPanel();
		pnnorth.setSize(200,400);
		
		JPanel pnnorth_center = new JPanel();
		pnnorth_center.setLayout(new GridLayout(5, 2, -650, 15));
		JPanel pnnorth_east = new JPanel();
		
		final JButton jb_icon = new JButton();
		
		//Set JButton trong suot
		jb_icon.setOpaque(false);
        jb_icon.setBackground(new Color(0, 0, 0, 100));
		
		//Set size cho button hien thi anh cua Doi bong
		Dimension buttonSize = new Dimension(250, 300);
		jb_icon.setPreferredSize(buttonSize);
		
		JLabel madoibong = new JLabel("Mã đội bóng");
		madoibong.setForeground(new Color(255, 0, 0));
		madoibong.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JLabel tendoibong = new JLabel("Tên đội bóng");
		tendoibong.setForeground(new Color(34, 139, 34));
		tendoibong.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JLabel founding = new JLabel("Ngày thành lập");
		founding.setForeground(new Color(0, 191, 255));
		founding.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JLabel maimage = new JLabel("Mã ảnh");
		maimage.setForeground(new Color(210, 105, 30));
		maimage.setFont(new Font("Dialog", Font.BOLD, 13));
		
		jcbmaimage.setSelectedItem(null);
		
		JLabel emty = new JLabel();
		
		JPanel jpbutton = new JPanel();
		jpbutton.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		JButton jbadd = new JButton("Add");
		jbadd.setFont(new Font("Courier New", Font.BOLD, 13));
		jbadd.setIcon(new ImageIcon(FootBallTeam.class.getResource("/iconbutton/add.png")));
		JButton jbupdate = new JButton("Edit");
		jbupdate.setFont(new Font("Courier New", Font.BOLD, 13));
		jbupdate.setIcon(new ImageIcon(FootBallTeam.class.getResource("/iconbutton/edit.png")));
		JButton jbdelete = new JButton("Delete");
		jbdelete.setFont(new Font("Courier New", Font.BOLD, 13));
		jbdelete.setIcon(new ImageIcon(FootBallTeam.class.getResource("/iconbutton/delete.png")));
		JButton jbclear = new JButton("Refresh");
		jbclear.setFont(new Font("Courier New", Font.BOLD, 13));
		jbclear.setIcon(new ImageIcon(FootBallTeam.class.getResource("/iconbutton/refresh.png")));
		JButton jbback = new JButton("Back");
		jbback.setFont(new Font("Courier New", Font.BOLD, 13));
		jbback.setIcon(new ImageIcon(FootBallTeam.class.getResource("/iconbutton/home.png")));
		
		jpbutton.add(jbadd);
		jpbutton.add(jbupdate);
		jpbutton.add(jbdelete);
		jpbutton.add(jbclear);
		jpbutton.add(jbback);
		
		
		pnnorth_center.add(madoibong);
		pnnorth_center.add(tfmadoibong);
		pnnorth_center.add(tendoibong);
		pnnorth_center.add(tftendoibong);
		pnnorth_center.add(founding);
		pnnorth_center.add(tffounding);
		pnnorth_center.add(maimage);
		pnnorth_center.add(jcbmaimage);
		pnnorth_center.add(emty);
		pnnorth_center.add(jpbutton);
		
		JPanel pncenter = new JPanel();
		pncenter.setLayout(new BorderLayout());
		Border bd = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder ttlBorder = BorderFactory.createTitledBorder(bd, "Danh sách đội bóng");
		pncenter.setBorder(ttlBorder);
		
		
		JScrollPane scrollPane = new JScrollPane();
		pncenter.add(scrollPane);
		
		vT = new Vector();
		vT.add("Mã đội bóng");
		vT.add("Tên đội bóng");
		vT.add("Số thành viên");
		vT.add("Ngày thành lập");
		vT.add("Mã image");
		
		vD = getvD();
		
		
		final JTable tb = new JTable();
		tb.setForeground(SystemColor.infoText);
		tb.setBackground(new Color(255, 255, 255));
		tb.setFont(new Font("Arial", Font.BOLD, 11));
		tb.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(tb);
		
		// Tạo một TableCellRenderer để căn giữa dữ liệu trong cột
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        // Đặt renderer cho mỗi cột trong JTable
        for (int i = 0; i < tb.getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        jcbmaimage.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = (String) jcbmaimage.getSelectedItem();
                    if (selectedItem != null) {
                        Icon icon = getIcon(selectedItem);
                        
                        jb_icon.setIcon(icon);
                    }
                } catch (Exception ex) {
                   
                    ex.printStackTrace();
                }
            }
        });
		
		jbclear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfmadoibong.setText("");
		        tftendoibong.setText("");
		        tffounding.setText("");
		        jcbmaimage.setSelectedItem(null);
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
				String sql = "INSERT INTO vleague.footballteam VALUES (?, ?, ?, ?, ?)";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfmadoibong.getText());
					stm.setString(2, tftendoibong.getText());
					stm.setString(3, "0");
					stm.setString(4, tffounding.getText());
					stm.setString(5, (String)jcbmaimage.getSelectedItem() );
					stm.execute();
					JOptionPane.showMessageDialog(null, "Thêm đội bóng thành công");
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Thêm đội bóng không thành công");
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
				tfmadoibong.setText((String)tb.getValueAt(row, 0));
				tftendoibong.setText((String)tb.getValueAt(row, 1));
				tffounding.setText((String)tb.getValueAt(row, 3));
				jcbmaimage.setSelectedItem((String)tb.getValueAt(row, 4));
	
				
			}
		});
		
		jbupdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "UPDATE vleague.footballteam SET ID = ?, footballname = ?, founding = ?, idimage = ? WHERE ID = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfmadoibong.getText());
					stm.setString(2, tftendoibong.getText());
					stm.setString(3, tffounding.getText());
					stm.setString(4, (String) jcbmaimage.getSelectedItem());
					stm.setString(5, tfmadoibong.getText());
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
				String sql = "DELETE FROM vleague.footballteam WHERE ID = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfmadoibong.getText());
					
					int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa cầu thủ này không?");
					if (choose == 0) {
						stm.execute();
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						
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
					JOptionPane.showMessageDialog(null, "Xóa không thành công");
				}
				}
		});;
		
		pnnorth.setLayout(new BorderLayout());
		pnnorth.add(pnnorth_center, BorderLayout.CENTER);
		pnnorth.add(pnnorth_east, BorderLayout.EAST);
		pnnorth_east.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 5));
		
		pnnorth_east.add(jb_icon);
		pnmain.add(pnnorth, BorderLayout.NORTH);
		
		pnmain.add(pncenter, BorderLayout.CENTER);
		con.add(pnmain, BorderLayout.CENTER);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconbutton/football-ball.png"));
		this.setIconImage(logo.getImage());
		
		setTitle("Quản lý đội bóng");

		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static void main(String[] args) {
		new FootBallTeam();
	}

}