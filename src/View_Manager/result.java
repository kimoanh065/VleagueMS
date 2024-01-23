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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connection.DBController;
import java.awt.SystemColor;

public class result extends JFrame {
	Vector vT, vD;
	public static Vector getvD() {
		Connection con = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * from vleague.result";
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
				vtemp.add(rs.getString(7));
				vtemp.add(rs.getString(8));
				vtemp.add(rs.getString(9));
				vD.add(vtemp);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}
	public Icon getIcon(String d) {
		int width = 250, height = 250;
		Image image = new ImageIcon(getClass().getResource("/icon/" + d + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	public static Vector getMDB() {
		Vector v = new Vector();
		
		Connection conn = new DBController().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM vleague.footballteam";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				v.add(rs.getString(1));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return v;
	}
	
	public result() {
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BorderLayout());
		
		JPanel pneast = new JPanel();
		
		JPanel pncenter = new JPanel();
		pncenter.setLayout(new BorderLayout());
		
		JPanel pncenter_center = new JPanel();
		GridLayout gl_pncenter_center = new GridLayout(6,2);
		gl_pncenter_center.setHgap(-400);
		gl_pncenter_center.setVgap(30);
		pncenter_center.setLayout(gl_pncenter_center);
		
		JPanel pncenter_south = new JPanel();
		
		JLabel lbid = new JLabel("Mã trận đấu");
		lbid.setForeground(Color.RED);
		lbid.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbteam1 = new JLabel("Đội 1");
		lbteam1.setForeground(new Color(0, 128, 0));
		lbteam1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLabel lbteam2 = new JLabel("Đội 2");
		lbteam2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbteam2.setForeground(new Color(30, 144, 255));
		JLabel lbscore1 = new JLabel("Điểm đội 1");
		lbscore1.setForeground(new Color(219, 112, 147));
		lbscore1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLabel lbscore2 = new JLabel("Điểm đội 2");
		lbscore2.setForeground(new Color(219, 112, 147));
		lbscore2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		final JTextField tfid = new JTextField();
		tfid.setEditable(false);
		
		final JTextField tfteam1 = new JTextField();
		tfteam1.setEditable(false);
		
		final JTextField tfteam2 = new JTextField();
		tfteam2.setEditable(false);
		
		final JTextField score1 = new JTextField();
		final JTextField score2 = new JTextField();
		
		
		
		JButton jbupdate = new JButton("Edit");
		jbupdate.setFont(new Font("Courier New", Font.BOLD, 13));
		jbupdate.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/edit.png")));
		JButton jbclear = new JButton("Refresh");
		jbclear.setFont(new Font("Courier New", Font.BOLD, 13));
		jbclear.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/refresh.png")));
		JButton jbback = new JButton("Back");
		jbback.setFont(new Font("Courier New", Font.BOLD, 13));
		jbback.setIcon(new ImageIcon(FootballPlayer.class.getResource("/iconbutton/home.png")));
		JPanel jpbutton = new JPanel();
		jpbutton.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 10));
		
		JLabel emty = new JLabel();
		
		
		JScrollPane scrollPane = new JScrollPane();
		Dimension preferredSize = new Dimension(600,750);
        scrollPane.setPreferredSize(preferredSize);
		
		
		
		vT = new Vector();
		vT.add("Mã trận đấu");
		vT.add("Đội 1");
		vT.add("Điểm đội 1");
		vT.add("Tỉ số");
		vT.add("Điểm đội 1");
		vT.add("Đội 2");
		vT.add("Ngày thi đấu");
		vT.add("Giờ thi đấu");
		vT.add("Nơi diễn ra"); 
		
		vD = getvD();
		
		Border bd = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder ttlBorder = BorderFactory.createTitledBorder(bd, "Kết quả");
		pneast.setBorder(ttlBorder);
		
		final JTable tb = new JTable();
		tb.setFont(new Font("Arial", Font.BOLD, 11));
		tb.setBackground(new Color(255, 255, 255));
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
		
		
		final JButton jbteam1 = new JButton();
        jbteam1.setPreferredSize(new Dimension(250, 270));
        
        jbteam1.setOpaque(false);
        jbteam1.setBackground(new Color(0, 0, 0, 100));
        
		
		final JButton jbteam2 = new JButton();
		
		jbteam2.setOpaque(false);
        jbteam2.setBackground(new Color(0, 0, 0, 100));
		
		JLabel lbvs = new JLabel("VS");
		lbvs.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfteam1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = tfteam1.getText();
                    if (selectedItem != null) {
                        Icon icon = getIcon(selectedItem);
                        
                        jbteam1.setIcon(icon);
                    }
                } catch (Exception ex) {
                   
                    ex.printStackTrace();
                }
            }
        });

		tfteam2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    // Xử lý sự kiện khi giá trị thay đổi
                    String selectedItem = tfteam2.getText();
                    if (selectedItem != null) {
                        Icon icon = getIcon(selectedItem);
                        
                        jbteam2.setIcon(icon);
                    }
                } catch (Exception ex) {
                    
                    ex.printStackTrace();
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
				tfid.setText((String)tb.getValueAt(row, 0));
				tfteam1.setText((String)tb.getValueAt(row, 1));
				tfteam2.setText((String)tb.getValueAt(row, 5));
				score1.setText((String)tb.getValueAt(row, 2));
				score2.setText((String)tb.getValueAt(row, 4));
				
			}
		});
		
		jbupdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "UPDATE vleague.result SET Score1 = ?, Score2 = ? WHERE ID = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, score1.getText());
					stm.setString(2, score2.getText());
					stm.setString(3, tfid.getText());
	
					stm.execute();
					JOptionPane.showMessageDialog(null, "Cập nhập thành công");
					
					vD = getvD();
					tb.setModel(new DefaultTableModel(vD, vT));
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Cập nhập không thành công");
					e2.printStackTrace();
				}
			}
		});
		
		jbclear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        score1.setText("");
		        score2.setText("");
			}
		});
		jbback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainGUI();
				setVisible(false);
			}
		});
		//ADD thanh phan
	
		jpbutton.add(jbupdate);
		jpbutton.add(jbclear);
		jpbutton.add(jbback);
		
		
		pncenter_center.add(lbid);
		pncenter_center.add(tfid);
		pncenter_center.add(lbteam1);
		pncenter_center.add(tfteam1);
		pncenter_center.add(lbteam2);
		pncenter_center.add(tfteam2);
		pncenter_center.add(lbscore1);
		pncenter_center.add(score1);
		pncenter_center.add(lbscore2);
		pncenter_center.add(score2);
		
		pncenter_center.add(jpbutton);
		pncenter_south.setLayout(new GridLayout(1, 3, 0, 0));
		
		pncenter_south.add(jbteam1);
		pncenter_south.add(lbvs);
		pncenter_south.add(jbteam2);
		
		pneast.add(scrollPane);
		
		pncenter.add(pncenter_center, BorderLayout.CENTER);
		pncenter.add(pncenter_south, BorderLayout.SOUTH);
		pnmain.add(pncenter, BorderLayout.CENTER);
		pnmain.add(pneast, BorderLayout.EAST);
		pneast.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		pneast.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		con.add(pnmain, BorderLayout.CENTER);
		
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static void main(String[] args) {
		new result();
	}
}
